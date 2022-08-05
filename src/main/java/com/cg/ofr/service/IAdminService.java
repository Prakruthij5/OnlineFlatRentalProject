package com.cg.ofr.service;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.exception.AdminNotFoundException;

public interface IAdminService {

	//Admin adminLogin(Admin admin);

	public Admin addAdmin(Admin admin);
	
	public String SignOut(String message);
	
	//public Admin adminLogin(Admin admin);


	public Admin adminLogin(String adminUserName, String adminPassword) throws AdminNotFoundException;
	
}
