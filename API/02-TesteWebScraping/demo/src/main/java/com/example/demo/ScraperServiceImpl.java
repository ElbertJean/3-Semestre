package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class ScraperServiceImpl implements ScraperService {

    // URLs dos portais que serão raspados.
    private final List<String> urls = Arrays.asList(
        "https://g1.globo.com/"
        // "https://www.cnnbrasil.com.br/",
        // "https://www.uol.com.br/"
    );

    @Override
    public Set<ResponseDTO> getSearch() {
        Set<ResponseDTO> responseDTOS = new HashSet<>();
        System.out.println("Buscando notícias...");

        for (String url : urls) {
            extractNews(responseDTOS, url);
        }

        return responseDTOS;
    }

    private void extractNews(Set<ResponseDTO> responseDTOS, String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements newsCards = document.select("a");
    
            for (Element card : newsCards) {
                String link = card.attr("href");
    
                // Normaliza o link para sempre ser completo com https
                if (!link.startsWith("http")) {
                    link = "https:" + link;
                }
    
                // Verifica se o link começa exatamente com "https://g1.globo.com/"
                if (link.startsWith("https://g1.globo.com/")) {
                    System.out.println("Link válido: " + link);
    
                    // Aqui você pode adicionar a lógica de coleta de dados, se necessário.
                    // scrapeNewsDetailsG1(responseDTOS, link);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    // private void scrapeNewsDetailsG1(Set<ResponseDTO> responseDTOS, String newsUrl) {
    //     try {
    //         Document initialPage = Jsoup.connect(newsUrl).get();

    //         // Verificando redirecionamento
    //         String redirectedUrl = initialPage.select("script").html()
    //             .replaceAll(".*window.location.replace\\(\"", "")
    //             .replaceAll("\"\\);.*", "");

    //         if (!redirectedUrl.isEmpty()) {
    //             newsUrl = redirectedUrl;
    //         }

    //         Document newsPage = Jsoup.connect(newsUrl).get();

    //         // Coletando título e data
    //         String title = newsPage.select(".content-head__title").text();
    //         String datePublished = newsPage.select("[itemprop=datePublished]").attr("content");

    //         // Exibindo o título e a data no console
    //         System.out.println("Título: " + title);
    //         System.out.println("Data: " + datePublished);

    //         // Coletando o conteúdo completo
    //         Elements contentElements = newsPage.select(".content-text__container");
    //         StringBuilder fullContent = new StringBuilder();

    //         for (Element content : contentElements) {
    //             fullContent.append(content.text()).append(System.lineSeparator());
    //         }

    //         // Exibindo o conteúdo coletado
    //         System.out.println("Conteúdo: " + fullContent);

    //         // Criando e adicionando o DTO
    //         ResponseDTO responseDTO = new ResponseDTO(title, newsUrl);
    //         responseDTO.setContent(fullContent.toString());
    //         responseDTO.setDate(datePublished);

    //         responseDTOS.add(responseDTO);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}
