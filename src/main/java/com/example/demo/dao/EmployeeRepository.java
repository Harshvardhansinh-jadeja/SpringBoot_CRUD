package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//that's all now JPA will have all the CRUD methods in it.
	
	//Now JPA will sort this and implement it by default but you have to give same name.
	public List<Employee> findAllByOrderByFirstNameAsc();
}
