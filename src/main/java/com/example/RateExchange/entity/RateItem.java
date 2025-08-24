package com.example.RateExchange.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "rate_item")
public class RateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    @SequenceGenerator(name="primary_sequence", sequenceName="primary_sequence", allocationSize=1, initialValue=10000)
    private Long id;

    @Column(nullable = false, unique = false)
    private String shortName;

    @Column(nullable = false, unique = false)
    private LocalDateTime validFrom;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private Double move;

    @Column
    private Double amount;

    @Column
    private Double valBuy;

    @Column
    private Double valSell;

    @Column
    private Double currMid;

    @Column
    private Double version;

    @Column
    private Double cnbMid;

    @Column
    private Double ecbMid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getMove() {
        return move;
    }

    public void setMove(Double move) {
        this.move = move;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getValBuy() {
        return valBuy;
    }

    public void setValBuy(Double valBuy) {
        this.valBuy = valBuy;
    }

    public Double getValSell() {
        return valSell;
    }

    public void setValSell(Double valSell) {
        this.valSell = valSell;
    }

    public Double getCurrMid() {
        return currMid;
    }

    public void setCurrMid(Double currMid) {
        this.currMid = currMid;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public Double getCnbMid() {
        return cnbMid;
    }

    public void setCnbMid(Double cnbMid) {
        this.cnbMid = cnbMid;
    }

    public Double getEcbMid() {
        return ecbMid;
    }

    public void setEcbMid(Double ecbMid) {
        this.ecbMid = ecbMid;
    }


}
