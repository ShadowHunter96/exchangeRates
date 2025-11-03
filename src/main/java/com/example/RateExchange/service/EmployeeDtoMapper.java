package com.example.RateExchange.service;

import com.example.RateExchange.dto.DepartmentDto;
import com.example.RateExchange.dto.EmployeeDto;
import com.example.RateExchange.entity.Department;
import com.example.RateExchange.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 22:36
 */
@Service
public class EmployeeDtoMapper implements Function<Employee, EmployeeDto> {
    @Override
    public EmployeeDto apply(Employee employee) {
        if (employee == null) return null;

        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                toDepartmentDto(employee.getDepartment())
        );
    }

    private DepartmentDto toDepartmentDto(Department department) {
        if (department == null) return null;
        return new DepartmentDto(department.getDepartmentId(), department.getDepartmentName());
    }
}
