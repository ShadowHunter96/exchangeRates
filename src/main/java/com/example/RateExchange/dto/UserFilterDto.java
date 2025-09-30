package com.example.RateExchange.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by User: Vu
 * Date: 29.09.2025
 * Time: 22:40
 */



@Getter
@Setter
public class UserFilterDto {

    private String firstName;
    private String lastName;
    private String login;

    private int page;
    private int size;
    private List<Sort.Order> orderList;
}
