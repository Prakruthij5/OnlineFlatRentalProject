package com.cg.ofr.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IUserRepository;
import com.cg.ofr.service.IUserService;


@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	public User addUser(User user) {
		userRepository.saveAndFlush(user);
		return user;	
		
	}
	
	public User updateUser(Integer userId,User user1) throws UserNotFoundException{
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()) {
            User u1=user.get();

            u1.setUserName(user1.getUserName());
            u1.setPassword(user1.getPassword());
            u1=userRepository.save(u1);
            return u1;

        }
        return null;

    }
	
	
	public User viewUser(int userId) throws UserNotFoundException{
		if(!userRepository.existsById(userId)) {
			throw new UserNotFoundException();
		}
		return userRepository.findById(userId).get();
		}

	public List<User> viewAllUser(){
		return userRepository.findAll();
	}
	
	
	
	 public User deleteUser(int userId) throws UserNotFoundException {
			
			if(!userRepository.existsById(userId)) {
				throw new UserNotFoundException();
			}
			
			
			User user=new User();
			user = userRepository.findById(userId).get();
			
			userRepository.deleteById(userId);
			return user;
		}
	  
	
	 /* public User userLogin(User user) {
		User user=user.getUserType();
		try {
		user=userRepository.findByUserNameAndPassword(user.getUserType()).orElseThrow(UserNotFoundException::new);
		user.setUserName(user);
		user.setPassword(user);
		  
		 System.out.println("flat set for flatbooking *****");
      }catch (UserNotFoundException e) {
          e.printStackTrace();
      }
	        userRepository.save(user);
	        return user;
	
}*/
	 /*public User userLogin (User user){
		
	      if( userRepository.findByUserNameAndPassword(user) != null) {
	          return user;
	      }
	      return null;
	    }
}*/
	 public User userLogin(String userName, String password) throws UserNotFoundException {
		 User user=userRepository.findByUserNameAndPassword(userName, password);
		 if (user==null) {
	        	throw new UserNotFoundException("Invalid user");
	        }
		
             return user;   
}
	 
	 public String LogOut(String message) {
	       if(message.equals("LogOut")) {
	           return "Logged out succesfully";
	       }
	       return "Still Logged in";
	    }
}
	

/*
 * public User viewUser(int id) throws UserNotFoundException; public List<User>
 * viewAllUser(); public User validateUser(String username,String password)
 * throws UserNotFoundException; public User addUser(User user); public User
 * updateUser(User user); public User updatePassword(User user,String newpass);
 * public User removeUser(User user);
 */