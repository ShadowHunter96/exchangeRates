package com.example.RateExchange.controller;

import com.example.RateExchange.dto.OfferDto;
import com.example.RateExchange.entity.Offer;
import com.example.RateExchange.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User: Vu
 * Date: 02.10.2025
 * Time: 23:46
 */
@RestController
@RequestMapping("/api/offer")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @PostMapping("/create")
    public ResponseEntity<Offer> create(@RequestBody Offer offer) {
        Offer created = offerService.create(offer);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(offerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Offer>> list(Pageable pageable) {
        return ResponseEntity.ok(offerService.list(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> update(@PathVariable Long id, @RequestBody Offer offer) {
        return ResponseEntity.ok(offerService.update(id, offer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        offerService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/getAllDto")
    public ResponseEntity<List<OfferDto>> getOfferDtos(){
        return ResponseEntity.ok(offerService.getAllOffersDto());
    }
}