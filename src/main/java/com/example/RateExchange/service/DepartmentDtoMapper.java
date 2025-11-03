package com.example.RateExchange.service;

import com.example.RateExchange.dto.DepartmentDto;
import com.example.RateExchange.dto.EmployeeDto;
import com.example.RateExchange.entity.Department;
import com.example.RateExchange.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 22:18
 */
@Service
public class DepartmentDtoMapper implements Function<Department, DepartmentDto> {

    @Override
    public DepartmentDto apply(Department department) {

        Set<EmployeeDto> employeeDtos = new LinkedHashSet<>();
        if (department.getEmployees() != null) {
            for (Employee e : department.getEmployees()) {
                employeeDtos.add(toEmployeeDto(e));
            }
        }

        return new DepartmentDto(
                department.getDepartmentId(),
                department.getDepartmentName(),
                employeeDtos
        );
    }

    private EmployeeDto toEmployeeDto(Employee e) {
        if (e == null) return null;
        return new EmployeeDto(e.getEmployeeId(), e.getEmployeeName());
    }
}
