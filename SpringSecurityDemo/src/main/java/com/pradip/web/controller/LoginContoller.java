package com.pradip.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Pradip
 *
 */
@Controller
public class LoginContoller {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginContoller.class);

	@GetMapping("/login")
	public String login() {
		LOGGER.info("Login method called");
		return "login";
	}

}
