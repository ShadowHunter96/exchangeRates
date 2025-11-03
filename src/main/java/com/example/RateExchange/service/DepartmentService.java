package com.example.RateExchange.service;

import com.example.RateExchange.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 21:55
 */
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
}
