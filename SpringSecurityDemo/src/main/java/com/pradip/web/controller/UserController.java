package com.pradip.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.pradip.web.entity.User;

/**
 * @author Pradip
 *
 */
@Controller
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/home")
	public String getHome(@AuthenticationPrincipal User user, ModelMap modelMap) {
		LOGGER.info("User inforamtion {}", user);
		modelMap.put("user", user);
		return "home";
	}

}
