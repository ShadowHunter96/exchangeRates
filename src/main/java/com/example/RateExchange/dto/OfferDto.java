package com.example.RateExchange.dto;

import com.example.RateExchange.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by User: Vu
 * Date: 11.10.2025
 * Time: 22:48
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {


    private long id;
    private String name;
    private BigDecimal priceWithoutVat;
    private LocalDate offerDate;
    private String marketUrl;
    private UserDto user;
    private BigDecimal priceAssurance;
    private Boolean sent;
    private Boolean deleted;
    private LocalDateTime lastUpdate;

    public OfferDto(long id, String name, BigDecimal priceWithoutVat, LocalDate offerDate, String marketUrl, BigDecimal priceAssurance, Boolean sent, Boolean deleted, LocalDateTime lastUpdate) {
        this.id = id;
        this.name = name;
        this.priceWithoutVat = priceWithoutVat;
        this.offerDate = offerDate;
        this.marketUrl = marketUrl;
        this.priceAssurance = priceAssurance;
        this.sent = sent;
        this.deleted = deleted;
        this.lastUpdate = lastUpdate;
    }
}