package com.ssafy.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/index.do"})
	protected String index() throws Exception {
		return "index";
	}
	
}
