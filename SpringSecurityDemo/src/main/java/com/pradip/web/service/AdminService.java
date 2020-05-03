package com.pradip.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.pradip.web.entity.User;
import com.pradip.web.repository.UserRepository;

/**
 * @author Pradip
 *
 */
@Service
public class AdminService {

	@Autowired
	private UserRepository userRepository;

	@Secured({"ROLE_ADMIN","ROLE_SUPERUSER"})
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
