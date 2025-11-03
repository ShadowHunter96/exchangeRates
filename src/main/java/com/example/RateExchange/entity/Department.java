package com.example.RateExchange.entity;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 21:06
 */
import jakarta.persistence.*;
import lombok.*;


import java.util.Set;


@Entity
@Table(name = "department")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;


    @Column(name = "department_name", length = 25, nullable = false, unique = true)
    private String departmentName;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees;
}