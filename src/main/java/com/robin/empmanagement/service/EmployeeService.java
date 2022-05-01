package com.robin.empmanagement.service;

import com.robin.empmanagement.exception.UserNotFoundException;
import com.robin.empmanagement.model.Employee;
import com.robin.empmanagement.repository.EmployeeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
//@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(@NotNull Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id)
    {
        employeeRepository.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) throws UserNotFoundException
    {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee Not Found by Id " + id));
    }
}
