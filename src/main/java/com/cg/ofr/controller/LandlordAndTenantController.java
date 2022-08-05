package com.cg.ofr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.AdminNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.service.IAdminService;
import com.cg.ofr.service.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/LandlordAndTenant")
public class LandlordAndTenantController {

	@Autowired
    private IUserService userService;

    @Autowired
    private IAdminService adminService;

    @PostMapping("/addAdmin")
    public Admin addAdmin(@Valid @RequestBody  Admin admin) {
        return adminService.addAdmin(admin);
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody  User user) {
        return userService.addUser(user);
    }

    @PostMapping("/adminLogin")
    public Admin adminLogin(@RequestBody Admin admin) throws AdminNotFoundException {
        return adminService.adminLogin(admin.getAdminUserName(),admin.getAdminPassword());
    }

    @PostMapping("/userLogin")
    public User userLogin(@RequestBody User user) throws UserNotFoundException {
        return userService.userLogin(user.getUserName(),user.getPassword());
    }
    
    @GetMapping("/LogOut/{message}")
    public String LogOut(@PathVariable("message")String message) {
        return userService.LogOut(message);
    }
    
}
	
	
	
	
	
	
	
	

