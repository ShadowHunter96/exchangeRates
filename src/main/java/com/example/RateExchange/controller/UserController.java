package com.example.RateExchange.controller;

import com.example.RateExchange.dto.UserFilterDto;
import com.example.RateExchange.entity.User;
import com.example.RateExchange.exception.UpstreamServiceException;
import com.example.RateExchange.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by User: Vu
 * Date: 28.09.2025
 * Time: 21:11
 */
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private UserService userService;

    public UserController( UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/get-all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<User>> getAll(){
        return (ResponseEntity<List<User>>) userService.getAllUsers();
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<User>> saveUser(@RequestBody User user) {
        try {
            Optional<User> saved = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (UpstreamServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/by-firstname")
    public ResponseEntity<List<User>> getByFirstName(@RequestParam("value") String firstName) {
        return ResponseEntity.ok(userService.getByFirstName(firstName));
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.of(userService.getById(id));
    }

    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<User>> searchPost(@RequestBody UserFilterDto filter) {
        return ResponseEntity.ok(userService.findUserPage(filter));
    }




}
