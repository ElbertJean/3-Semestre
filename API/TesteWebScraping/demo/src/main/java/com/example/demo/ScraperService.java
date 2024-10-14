package com.example.demo;

import java.util.Set;

public interface ScraperService {
    Set<ResponseDTO> getSearch(String search);
}
