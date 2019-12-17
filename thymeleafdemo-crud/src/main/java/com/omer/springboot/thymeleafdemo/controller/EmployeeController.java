package com.omer.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omer.springboot.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	List<Employee> empList;
	
	@PostConstruct
	public void loadEmps() {
		empList= new ArrayList<>();
		
		empList.add(new Employee("Omer","Karakas","omerk@bilgeadam.com" ));
		empList.add(new Employee("Ali","Can","alic@bilgeadam.com" ));
		empList.add(new Employee("Furkan","Karagöz","furkang@bilgeadam.com" ));
		
	}
	
	@GetMapping("/list")
	public String listEmps(Model model) {
		model.addAttribute("employees",empList);
		return "employees/emplist-bs";
	}	
	
	@GetMapping("/add")
	public String showFormEmpty(Model model) {
		Employee emp = new Employee();
		emp.setFirstName("Benim Adım");
		emp.setLastName("Benim Soyadım");
		emp.setEmail("benim@mailim");
		model.addAttribute("employee",emp);
		
		return "employees/emp-form";
		// employees/emp-form.html'yi çağır
	}
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute("employee") Employee emp) {
		
		//olunca aç
		//employeeService.save(emp);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/update")
	public String showFormUpdate(@RequestParam("employeeId") int empId, Model model) {
		
		Employee emp = new Employee();
		//olunca ac
		//Employee emp = employeeService.findById(empId);
		
		model.addAttribute("employee", emp);
		
		return "employees/emp-form";
		// employees/emp-form.html'yi çağır
	}	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int empId) {
		
		//olunca ac
		//Employee emp = employeeService.deleteById(empId);
		
		
		return "redirect:/employees/list";
	}	
}	
	
}
 