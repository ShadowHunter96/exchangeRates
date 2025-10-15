package com.example.RateExchange.service;

import com.example.RateExchange.dto.OfferDto;
import com.example.RateExchange.dto.UserDto;
import com.example.RateExchange.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Created by User: Vu
 * Date: 13.10.2025
 * Time: 21:28
 */
@Service
public class UserDtoMapper implements Function<User, UserDto> {


    @Override
    public UserDto apply(User user) {
        OfferDto offerDto = new OfferDto(user.getOffer().getId(),
                                        user.getOffer().getName(),
                user.getOffer().getPriceWithoutVat(),
                user.getOffer().getOfferDate(),
                user.getOffer().getMarketUrl(),
                user.getOffer().getPriceAssurance(),
                user.getOffer().getSent(),
                user.getOffer().getDeleted(),
                user.getOffer().getLastUpdate()
                );
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getLogin(),
                offerDto


        );
    }
}
