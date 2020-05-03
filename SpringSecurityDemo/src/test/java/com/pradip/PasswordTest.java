package com.pradip;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pradip
 *
 */
public class PasswordTest {

	private String rawPassword = "pradip123";

	@Test
	public void testPassword() {
		
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPassword=encoder.encode("pradip123");
		assertTrue(encoder.matches(rawPassword, encodedPassword));
		
	}

}
