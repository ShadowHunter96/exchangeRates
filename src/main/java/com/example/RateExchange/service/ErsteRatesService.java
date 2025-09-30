package com.example.RateExchange.service;

import com.example.RateExchange.dto.RateItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;


import java.util.Arrays;
import java.util.List;

/**
 * Created by User: Vu
 * Date: 22.08.2025
 * Time: 10:33
 */
@Service
public class ErsteRatesService {
    private final RestTemplate rt = new RestTemplate();

    @Value("${erste.api.url}")
    private String url;

    public List<RateItemDto> fetchRates() {
        ResponseEntity<RateItemDto[]> resp = rt.getForEntity(url, RateItemDto[].class);
        RateItemDto[] body = resp.getBody();
        if (body == null) throw new IllegalStateException("Empty body from Erste API");
        return Arrays.asList(body);
    }
}
