package com.biz.readbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.readbook.service.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	BookService bService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		model.addAttribute("BOOKS", bService.selectAll());
		
		return "home";
	}
	
}
