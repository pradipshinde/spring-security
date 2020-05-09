package com.pradip.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pradip.web.entity.User;

/**
 * @author Pradip
 *
 */

@Controller
@RequestMapping("account")
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@GetMapping("/home")
	public String getHome(@AuthenticationPrincipal final User user, final ModelMap modelMap) {
		LOGGER.info("User inforamtion {}", user);
		modelMap.put("user", user);
		return "common/home";
	}
}
