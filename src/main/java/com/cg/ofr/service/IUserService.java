package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;

public interface IUserService {

	public User addUser(User user);

    public User updateUser(Integer userId,User user1) throws UserNotFoundException;

    public User viewUser(int userId) throws UserNotFoundException;

    public List<User> viewAllUser();

    public String LogOut(String message);
 
    public User deleteUser(int userId) throws UserNotFoundException;

	public User userLogin(String userName, String password)throws UserNotFoundException;

    //public User userLogin (String userName ,String password);

	//public User userLogin(User user);
}