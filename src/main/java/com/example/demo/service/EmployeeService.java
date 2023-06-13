package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

//use of this interface and it's implementation is just to delegates the calls of DAO to Controller
public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);
}
