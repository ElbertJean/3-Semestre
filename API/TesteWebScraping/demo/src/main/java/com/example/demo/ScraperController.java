package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@RestController
@CrossOrigin("/*")
@RequestMapping(path = "/")
public class ScraperController {
    
    @Autowired
    ScraperService scraperService;

    @GetMapping(path = "/{search}")
    public Set<ResponseDTO> getSearch(@PathVariable String search) {
        return  scraperService.getSearch(search);
    }
}