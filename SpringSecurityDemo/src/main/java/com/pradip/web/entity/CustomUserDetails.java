package com.pradip.web.entity;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Pradip
 *
 */
public class CustomUserDetails extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	public CustomUserDetails() {
	}

	public CustomUserDetails(User user) {
		this.user = user;
	    this.setPassword(user.getPassword());
	    this.setAuthorities(user.getAuthorities());
	}

	
	@Override
	public String getUsername() {
		return user.getUserName();
	} 

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
