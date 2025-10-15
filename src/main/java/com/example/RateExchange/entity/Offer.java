package com.example.RateExchange.entity;

/**
 * Created by User: Vu
 * Date: 30.09.2025
 * Time: 10:49
 */


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    @Column(name = "price_without_vat")
    private BigDecimal priceWithoutVat;

    @Column(name = "offer_date")
    private LocalDate offerDate;

    @Column(name = "market_url")
    private String marketUrl;

    @OneToOne(mappedBy = "offer")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private User user;

    @Column(name = "price_assurance")
    private BigDecimal priceAssurance;

    private Boolean sent;

    private Boolean deleted;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;


}

