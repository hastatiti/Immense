package com.immense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.immense.service.RandomNumberService;

@Controller
public class NumberController {
	
	//Inject our RandomNumberService
	@Autowired
	private RandomNumberService randomNumberService;
	
	//main page, gets value from service provider adds to model for view purposes
	@GetMapping(value = "/LotteryNumber")
	public String goHome(Model model) {
		int random = randomNumberService.getRandomNumber();
		model.addAttribute("LotteryNumber", random);
		return "home";
	}
}
