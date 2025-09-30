package com.example.RateExchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by User: Vu
 * Date: 22.08.2025
 * Time: 14:10
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundInDbException extends RuntimeException {
    public NotFoundInDbException(String message) { super(message); }
}


