package com.example.RateExchange.dto;

import com.example.RateExchange.entity.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 22:16
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long depId;
    private String departmentName;
    private Set<EmployeeDto> employees;

    public DepartmentDto(Long depId, String departmentName) {
        this.depId = depId;
        this.departmentName = departmentName;
    }
}
