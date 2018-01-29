package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.entity.ResultJsonData;
import com.example.service.EmployeeService;
import com.google.gson.Gson;



@RestController  
public class HelloController {  

	@Autowired
	private Gson gson;
	
	@Autowired
	private EmployeeService employeeService;

	//-------------------Retrieve all Employees------** using diff criteria *--------------------------------------------------
	@RequestMapping("/getEmployees")
	public String hello(ModelMap model) {
	
		ResultJsonData resultJsonData = new ResultJsonData();

		List<Employee> emps = employeeService.findAllEmployees();

		resultJsonData.setEmps(emps);

		return gson.toJson(resultJsonData);
	}
	
	
	//-------------------Retrieve Single Employee------** using diff criteria *--------------------------------------------------
    
    @RequestMapping(value = "/getEmployeeById/{id}", method = RequestMethod.GET)
        public String getEmployeeById(@PathVariable("id") Integer id) {
    	
    	ResultJsonData resultJsonData =new ResultJsonData();
    	
        Employee emp = employeeService.findById(id);
        
     // System.out.println(employeeService.findByAddressAndName("alexandria","ahmed").getId());
    	
   	//  System.out.println(employeeService.findEmployeesByDepartmentName("electronics").getId());
       
        List<Employee> emps=new ArrayList<>();
        
        emps.add(emp);
        
        resultJsonData.setEmps(emps);
		
    	return gson.toJson(resultJsonData);
    }
    
  //-------------------add new Employee------------------------------------------------------
    
  // ------------request body-------- {"id":5,"name":"asmaaAhmedShahin","address":"Alexandria"}
	@RequestMapping(value="/addEmployee" , method = RequestMethod.POST)
	public String addEmployee(ModelMap model ,@Valid	@RequestBody Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return "added successfuly";
	}
	
	
	//-------------------delete employee by id-----------------------------------------
	
    // ------------request body-------- {"id":5,"name":"asmaaAhmedShahin","address":"Alexandria"}
	@RequestMapping(value="/deleteEmployee" , method = RequestMethod.DELETE )
	public String deleteEmployee(ModelMap model, @RequestBody  Employee employee) {
		
		employeeService.removeEmployee(employee);
		
		return "deleted successfuly";
	}
	
	@RequestMapping(value="/updateEmployee/{id}", method = RequestMethod.PUT)
	public String updateEmployee(ModelMap model ,@RequestBody Employee employee , @PathVariable("id") Integer id) {
		
		employeeService.findAllEmployees().forEach(emp -> {
			
			if (emp.getId() != id)
			
				employeeService.saveEmployee(employee);

		});
		
		 return "updated successfuly";
	}
}  