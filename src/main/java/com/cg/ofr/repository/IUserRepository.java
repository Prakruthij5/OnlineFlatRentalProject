package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.ofr.entities.User;


public interface IUserRepository extends JpaRepository<User,Integer>{

	//Object findByUserNameAndPassword(String userName, String password);

	

	//public User findByUserNameAndPassword(User user);

	public User findByUserNameAndPassword(String userName, String password);

	

	

	//public User findByUserNameAndPassword(User user);
	
	

}
