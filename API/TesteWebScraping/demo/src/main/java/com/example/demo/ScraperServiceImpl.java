package com.example.demo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ScraperServiceImpl implements ScraperService {
    @Value("#{'${website.urls}'.split(',')}")
    List<String> urls;

    @Override
    public Set<ResponseDTO> getSearch(String search) {
        Set<ResponseDTO> responseDTOS = new HashSet<>();

        String formattedSearch = search.replace(" ", "+");
        System.out.println("URLS: " + urls);

        for (String url: urls) {
            if (url.contains("g1")) {
                extractNewsDataG1(responseDTOS, url + formattedSearch);
            }
            if (url.contains("cnn")) {
                extractNewsDataCNN(responseDTOS, url + formattedSearch + "&orderby=date&order=desc");
            }
        }

        return responseDTOS;
    }

    private void extractNewsDataG1(Set<ResponseDTO> responseDTOS, String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements newsCards = document.select(".widget.widget--card.widget--info");

            for (Element card : newsCards) {
                String link = card.select("a").attr("href");

                if (!link.startsWith("http")) {
                    link = "https:" + link;
                }

                if (!link.contains("2Fnoticia%2F")) {
                    continue;
                }

                scrapeNewsDetailsG1(responseDTOS, link);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void extractNewsDataCNN(Set<ResponseDTO> responseDTOS, String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements newsCards = document.select(".home__list__tag");

            for (Element card : newsCards) {
                String link = card.attr("href");

                if (!link.startsWith("http")) {
                    link = "https://www.cnnbrasil.com.br" + link;
                }

                scrapeNewsDetailsCNN(responseDTOS, link);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scrapeNewsDetailsG1(Set<ResponseDTO> responseDTOS, String newsUrl) {
        try {
            Document initialPage = Jsoup.connect(newsUrl).get();

            String redirectedUrl = initialPage.select("script").html()
                .replaceAll(".*window.location.replace\\(\"", "")
                .replaceAll("\"\\);.*", "");

            if (!redirectedUrl.isEmpty()) {
                newsUrl = redirectedUrl;
            }

            Document newsPage = Jsoup.connect(newsUrl).get();

            String title = newsPage.select(".content-head__title").text();
            String datePublished = newsPage.select("[itemprop=datePublished]").attr("content");

            Elements contentElements = newsPage.select(".content-text__container");
            StringBuilder fullContent = new StringBuilder();

            for (Element content : contentElements) {
                fullContent.append(content.text()).append(System.lineSeparator());
            }

            if (!fullContent.toString().contains("Manoel Gomes")) {
                return;
            }

            ResponseDTO responseDTO = new ResponseDTO(title, newsUrl);
            responseDTO.setContent(fullContent.toString());
            responseDTO.setDate(datePublished);

            responseDTOS.add(responseDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scrapeNewsDetailsCNN(Set<ResponseDTO> responseDTOS, String newsUrl) {
        try {
            Document newsPage = Jsoup.connect(newsUrl).get();
            String title = newsPage.select(".single-header__title").text();
            String datePublished = newsPage.select(".single-header__time").text();

            Elements contentElements = newsPage.select(".single-content p");
            StringBuilder fullContent = new StringBuilder();

            for (Element content : contentElements) {
                fullContent.append(content.text()).append(System.lineSeparator());
            }

            if (!fullContent.toString().contains("Manoel Gomes")) {
                return;
            }

            ResponseDTO responseDTO = new ResponseDTO(title, newsUrl);
            responseDTO.setContent(fullContent.toString());
            responseDTO.setDate(datePublished);

            responseDTOS.add(responseDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}