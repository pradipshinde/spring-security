package com.pradip.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradip.web.entity.User;
import com.pradip.web.repository.UserRepository;

/**
 * @author Pradip
 *
 */
@Service
public class UserService {


@Autowired 
private UserRepository userRepository;

public User getUserDetail(Long id) {
	return userRepository.getOne(id);
}

}
