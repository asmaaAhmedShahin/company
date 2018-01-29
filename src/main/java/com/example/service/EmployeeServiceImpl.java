package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepository;
import com.example.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAllEmployees() {

		// Iterable<Employee> employees= employeeRepository.findAll();

		List<Employee> emps = new ArrayList<Employee>();

		employeeRepository.findAll().forEach(emps::add);

		return emps;
	}
	
	public Employee findById(Integer id) {

		return employeeRepository.findById(id);
	} 
	
	public Employee findEmplyeeByAddress() {

		return employeeRepository.findByAddress("alexandria");
	}

	public Employee findFirstEmployee() {

		return employeeRepository.findOne(1);
	}

	public Employee findByAddressAndName(String address, String name) {

		return employeeRepository.findByAddressAndName(address, name);
	}

	public Employee findEmployeesByDepartmentName(String name) {

		return employeeRepository.findEmployeesByDepartmentName(name);
	}

	public void saveEmployee(Employee e) {
		

		employeeRepository.save(e);
	}
	
	public void removeEmployee(Employee e) {
		

		employeeRepository.delete(e);
	}
	

}
