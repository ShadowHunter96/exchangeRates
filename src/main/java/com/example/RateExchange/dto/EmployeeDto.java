package com.example.RateExchange.dto;

import com.example.RateExchange.entity.Department;
import jakarta.persistence.*;
import lombok.*;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 22:14
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long employeeId;
    private String employeeName;
    private DepartmentDto department;

    public EmployeeDto(Long employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }
}
