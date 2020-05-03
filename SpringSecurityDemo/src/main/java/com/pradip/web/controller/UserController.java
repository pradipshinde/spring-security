package com.pradip.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Pradip
 *
 */
@Controller
public class UserController {

	@GetMapping("/hello")
	public String helloController() {
		return "Hello World";
	}

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
}
