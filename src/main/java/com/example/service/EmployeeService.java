package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAllEmployees();
	
	public Employee findById(Integer id);

	public Employee findFirstEmployee();
	
	public Employee findByAddressAndName(String address,String name);
    
	public Employee findEmployeesByDepartmentName(String name);
    
	public void saveEmployee(Employee e);
	
	public void removeEmployee(Employee e);
}
