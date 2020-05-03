package com.pradip.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pradip.web.entity.CustomUserDetails;
import com.pradip.web.entity.User;
import com.pradip.web.repository.UserRepository;

/**
 * @author Pradip
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)  {
		User user = userRepository.findByUserName(username);
		if(user==null) {
			LOGGER.info("User Name or Password was incorrect");
			throw new UsernameNotFoundException("User Name or Password was incorrect");
		}

		return new CustomUserDetails(user);
	}
}
