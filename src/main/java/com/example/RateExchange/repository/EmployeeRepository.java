package com.example.RateExchange.repository;

import com.example.RateExchange.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 21:51
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
