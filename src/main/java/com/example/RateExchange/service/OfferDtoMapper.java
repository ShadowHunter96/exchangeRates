package com.example.RateExchange.service;

import com.example.RateExchange.dto.OfferDto;
import com.example.RateExchange.dto.UserDto;
import com.example.RateExchange.entity.Offer;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Created by User: Vu
 * Date: 11.10.2025
 * Time: 22:47
 */
@Service
public class OfferDtoMapper implements Function<Offer, OfferDto> {


    @Override
    public OfferDto apply(Offer offer) {
        UserDto userDto = new UserDto(
                offer.getUser().getId(),
                offer.getUser().getFirstName(),
                offer.getUser().getLastName(),
                offer.getUser().getLogin()

        );
        return new OfferDto(
                offer.getId(),
                offer.getName(),
                offer.getPriceWithoutVat(),
                offer.getOfferDate(),
                offer.getMarketUrl(),
                userDto,
                offer.getPriceAssurance(),
                offer.getSent(),
                offer.getDeleted(),
                offer.getLastUpdate()
        );
    }
}
