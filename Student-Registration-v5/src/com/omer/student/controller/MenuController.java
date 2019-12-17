package com.omer.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	@RequestMapping("/menu")
	public String mainMenu() {
		
		return "main-menu";
	}
	
}
