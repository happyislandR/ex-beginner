package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/receive-info")
	public String receiveInfo(String product1, String product2, String product3) {
		System.out.println("aaa");
		int withoutTax = Integer.parseInt(product1) + Integer.parseInt(product2) + Integer.parseInt(product3);
		int withTax = (int)(withoutTax * 1.1);
		
		application.setAttribute("withoutTax", withoutTax);
		application.setAttribute("withTax", withTax);
		return "exam03-result";
	}
}
