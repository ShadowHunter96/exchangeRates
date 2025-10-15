package com.example.RateExchange.dto;

import com.example.RateExchange.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by User: VU
 * Date: 30.09.2025
 * Time: 11:24
 */
@Getter
@Setter
public class OfferFilterDto {

    private String name;
    private BigDecimal priceWithoutVat;
    private LocalDate offerDate;
    private String marketUrl;
    private User user;
    private BigDecimal priceAssurance;
    private Boolean sent;
    private Boolean deleted;

    private LocalDateTime lastUpdate;
}
