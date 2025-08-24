package com.example.RateExchange.controller;

import com.example.RateExchange.dto.RateItemDto;
import com.example.RateExchange.service.RateItemService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/rate-items", produces = MediaType.APPLICATION_JSON_VALUE)
public class RateItemController {

    private  RateItemService rateItemService;

    public RateItemController( RateItemService rateItemService) {
        this.rateItemService = rateItemService;
    }

    @GetMapping
    public ResponseEntity<List<RateItemDto>> getRates(
            @RequestParam(name = "usedb", defaultValue = "true") boolean usedb)  {

        return ResponseEntity.ok(rateItemService.getRates(usedb));
    }



}
