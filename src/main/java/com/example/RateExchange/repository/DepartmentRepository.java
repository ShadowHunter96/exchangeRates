package com.example.RateExchange.repository;

import com.example.RateExchange.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 21:44
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
