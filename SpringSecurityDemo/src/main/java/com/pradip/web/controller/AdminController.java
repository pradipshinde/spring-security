package com.pradip.web.controller;

import java.security.Principal;

import com.pradip.web.service.AdminService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pradip
 *
 */

@Controller
@RequestMapping("admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @GetMapping("home")
    public String adminHome(Principal principal, ModelMap modelMap) {
        /*
         * this is just the username of the user who is logged in and sending this
         * particular request
         */

        final String userName = principal.getName();
        LOGGER.info(" logged in User name {}", userName);
        LOGGER.info("All user information {}", adminService.getAllUser());

        modelMap.put("user", userName);
        modelMap.put("users", adminService.getAllUser());

        return "admin/home";
    }

}
