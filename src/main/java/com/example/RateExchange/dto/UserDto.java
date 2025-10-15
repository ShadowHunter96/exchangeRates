package com.example.RateExchange.dto;

import com.example.RateExchange.entity.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Created by User: Vu
 * Date: 13.10.2025
 * Time: 21:29
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private OfferDto offer;

    public UserDto(Long id, String firstName, String lastName, String login) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }
}
