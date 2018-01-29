package com.example.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	Employee findByAddress(String address);

	Employee findById(Integer id);
	
	Employee findByAddressAndName(String address,String name);
		
	@Query("select e from Employee e inner join e.depId d where d.name = :name ")
    public Employee findEmployeesByDepartmentName( @Param("name") String name);
	
	
	
}
