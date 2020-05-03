package com.pradip.web.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.pradip.web.entity.User;
import com.pradip.web.service.AdminService;

/**
 * @author Pradip
 *
 */
@Controller
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/home")
	public String getHome(@AuthenticationPrincipal User user, ModelMap modelMap) {
		LOGGER.info("User inforamtion {}", user);
		modelMap.put("user", user);
		return "home";
	}

	@GetMapping("/test")
	public String testPrinciple(Principal principal, ModelMap modelMap) {
		/*
		 * this is just the username of the user who is logged in and sending this
		 * particular request
		 */
 
		String userName = principal.getName();
		LOGGER.info(" logged in User name {}", userName);
		LOGGER.info("All user information {}", adminService.getAllUser());
		
		modelMap.put("user", userName);
		modelMap.put("users", adminService.getAllUser());
		
		return "test";
	}
}
