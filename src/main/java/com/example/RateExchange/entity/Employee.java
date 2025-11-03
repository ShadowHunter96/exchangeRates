package com.example.RateExchange.entity;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 21:09
 */
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "employee")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;


    @Column(name = "employee_name", length = 45, nullable = false)
    private String employeeName;


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;
}
