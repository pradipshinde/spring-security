package com.pradip.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pradip.web.entity.User;

/**
 * @author Pradip
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u left join fetch u.authorities where u.userName=:userName")
	User findByUserName(String userName);

}
