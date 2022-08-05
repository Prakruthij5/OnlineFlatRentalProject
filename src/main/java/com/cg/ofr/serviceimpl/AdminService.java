package com.cg.ofr.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.AdminNotFoundException;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IAdminRepository;
import com.cg.ofr.service.IAdminService;

@Service
public class AdminService implements IAdminService {

	@Autowired
	private IAdminRepository adminRepository;
	
	public Admin addAdmin(Admin admin) {
        adminRepository.saveAndFlush(admin);
        return admin;
    }
	
	public Admin adminLogin(String adminUserName, String adminPassword) throws AdminNotFoundException {
        Admin admin=adminRepository.findByAdminUserNameAndAdminPassword(adminUserName, adminPassword);
        if(admin==null) {
        	 throw new AdminNotFoundException("Invalid Admin");
           
        }
        return admin;
	}
	
	public String SignOut(String message) {
	       if(message.equals("SignOut")) {
	           return "signed out succesfully";
	       }
	       return "Still Signed in";
	    }
	
}
	
