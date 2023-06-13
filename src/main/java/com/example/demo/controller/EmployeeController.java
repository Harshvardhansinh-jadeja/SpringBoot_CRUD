package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private EmployeeService employeeService;
	
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		List<Employee> theEmployees = employeeService.findAll();
		model.addAttribute("employees", theEmployees );
		return "employee/list-employee";
	}
	
	@GetMapping("/showFormAdd")
	public String addEmployee(Model model){
			//here we create new employee object to bind the data betweeen two pages
			Employee employee = new Employee();
			
			//now thymleaf will access this employee for binding
			model.addAttribute("employee",employee);
			
			return  "employee/employee-form";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("employeeId") int theId, Model model) {
		//get the employee from the service
		Employee employee = employeeService.findById(theId);
		
		//set employee to populate the form in next html page.
		model.addAttribute("employee",employee);
		
		return "employee/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
			employeeService.save(theEmployee);
			
			return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormDelete")
	public String deleteEmployee(@RequestParam("employeeId") int theId)
	{
		
		
		 employeeService.deleteById(theId); 
		
		return "redirect:/employee/list";
	}
	


}
