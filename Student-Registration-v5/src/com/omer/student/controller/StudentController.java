package com.omer.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omer.student.entity.Student;
import com.omer.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/list")
	public String listStudents(Model model) {
		
		// get students from service
		List<Student> myStudents = studentService.getStudents();
		
		// add students to model
		model.addAttribute("students",myStudents);
		
		return "list-students";
	}
	
	@GetMapping("/addStudentForm")
	public String addStudentForm(Model model){
		
		//v2:
		Student std = new Student();
		model.addAttribute("student",std);
		
		return "student-form";
	}
	
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		
		return "redirect:/student/list";
		
	}
	
	
	@GetMapping("/updateStudentForm")
	public String updateStudentForm(@RequestParam("studentId") int studentId, Model model){
		
		// get student from the service
		Student student = studentService.getStudent(studentId);
		
		// set student as a model attribute to populate the form
		model.addAttribute("student", student);
		
		//
		
		return "student-form";
	}
		
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int studentId){
		
		studentService.deleteStudent(studentId);
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/searchStudents")
    public String searchStudents(@RequestParam("searchName") String searchName,
                                    Model model) {

        // search customers from the service
        List<Student> students = studentService.searchStudents(searchName);
                
        // add the customers to the model
        model.addAttribute("students", students);

        return "list-students";        
    }
			
}
