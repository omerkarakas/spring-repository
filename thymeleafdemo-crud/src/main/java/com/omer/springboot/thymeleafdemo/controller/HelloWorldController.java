package com.omer.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.omer.springboot.thymeleafdemo.entity.Employee;

@Controller
public class HelloWorldController {


	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("tarih",new Date());
		return "hello";
	}
	

	
}
