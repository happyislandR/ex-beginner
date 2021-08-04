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
	public String receiveInfo(String price1, String price2, String price3) {
		int TotalPrice = Integer.parseInt(price1) + Integer.parseInt(price2) + Integer.parseInt(price3);
		int TotalPriceWithTax = (int)(TotalPrice * 1.1);
		
		application.setAttribute("TotalPrice", TotalPrice);
		application.setAttribute("TotalPriceWithTax", TotalPriceWithTax);
		return "exam03-result";
	}
}
