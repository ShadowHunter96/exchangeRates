package com.example.RateExchange.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.time.LocalDateTime;


public class RateItemDto {
    @NotNull
    @Size(max = 255)
    private String shortName;

    private LocalDateTime validFrom;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String country;

    private Double move;

    private Double amount;

    private Double valBuy;

    private Double valSell;

    private Double currMid;

    private Double version;

    private Double cnbMid;

    private Double ecbMid;


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
