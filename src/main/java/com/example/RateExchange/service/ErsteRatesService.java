package com.example.RateExchange.service;

import com.example.RateExchange.dto.RateItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    private static final String URL =
            "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates" +
                    "?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";

    public List<RateItemDto> fetchRates() {
        ResponseEntity<RateItemDto[]> resp = rt.getForEntity(URL, RateItemDto[].class);
        RateItemDto[] body = resp.getBody();
        if (body == null) throw new IllegalStateException("Empty body from Erste API");
        return Arrays.asList(body);
    }
}
