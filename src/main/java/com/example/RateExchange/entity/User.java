package com.example.RateExchange.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

/**
 * Created by User: Vu
 * Date: 28.09.2025
 * Time: 20:56
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String login;
    @com.fasterxml.jackson.annotation.JsonIgnore
    private String password;
    @OneToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "offer_id", referencedColumnName = "id", unique = true)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Offer offer;
}

