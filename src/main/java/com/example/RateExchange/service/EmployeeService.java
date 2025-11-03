package com.example.RateExchange.service;

import com.example.RateExchange.entity.Department;
import com.example.RateExchange.entity.Employee;
import com.example.RateExchange.exception.ResourceNotFoundException;
import com.example.RateExchange.repository.DepartmentRepository;
import com.example.RateExchange.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * Created by User: Vu
 * Date: 17.10.2025
 * Time: 21:52
 */
@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee getById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee " + employeeId + " not found"));
    }


    public Employee update(Long employeeId, String newName) {
        Employee existing = getById(employeeId);
        if (newName != null) existing.setEmployeeName(newName);
        return employeeRepository.save(existing);
    }

    /** Přiřaď zaměstnance k oddělení (z pohledu zaměstnance). */
    public Employee assignDepartment(Long employeeId, long departmentId) {
        Employee emp = getById(employeeId);
        Department newDep = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department " + departmentId + " not found"));

        Department oldDep = emp.getDepartment();
        if (Objects.equals(oldDep, newDep)) return emp;   // už je přiřazen

        // 1) přidej do nového dep (aby se kvůli orphanRemoval nesmazal)
        link(emp, newDep);

        // 2) případně odpoj ze starého dep
        if (oldDep != null) {
            oldDep.getEmployees().remove(emp);
        }

        return employeeRepository.save(emp);
    }

    /** Odpoj zaměstnance od oddělení (bez smazání zaměstnance). */
    public Employee unassignDepartment(Long employeeId) {
        Employee emp = getById(employeeId);
        Department dep = emp.getDepartment();
        if (dep != null) {
            // pozor na orphanRemoval=true – tady NEodstraňujeme z kolekce, pokud nechceš smazat entitu
            dep.getEmployees().remove(emp); // pokud máš orphanRemoval a nechceš mazat Employee, zvaž jeho vypnutí
            emp.setDepartment(null);
        }
        return employeeRepository.save(emp);
    }

    public void delete(Long employeeId) {
        Employee emp = getById(employeeId);
        Department dep = emp.getDepartment();
        if (dep != null) {
            dep.getEmployees().remove(emp); // s orphanRemoval=true odstranění z kolekce smaže i zaměstnance
        }
        employeeRepository.delete(emp);
    }

    // ——— helpers ———
    private void link(Employee emp, Department dep) {
        emp.setDepartment(dep);
        if (dep.getEmployees() != null) dep.getEmployees().add(emp);
    }
}
