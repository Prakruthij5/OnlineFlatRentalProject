package com.cg.ofr.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.service.IFlatService;
import com.cg.ofr.serviceimpl.FlatBookingService;
import com.cg.ofr.serviceimpl.LandlordService;
import com.cg.ofr.serviceimpl.TenantService;
import com.cg.ofr.serviceimpl.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Admin")
public class AdminController {

	
	@Autowired
	private LandlordService ilandlordservice;
	
	@Autowired
	private TenantService itenantservice;
	
	@Autowired
	private FlatBookingService iflatbookingService;
	
	@Autowired
	private IFlatService iflatService;
	
	@Autowired
	private TenantService itenantService;
	
	@Autowired
	private UserService iuserService;



	 @PostMapping ("/addLandlord")
	  public Landlord addLandlord(@RequestBody Landlord landlord ) 
	  { System.out.println("request received "+ landlord);
	  
	  return ilandlordservice.addLandlord(landlord); }
	 
	  @PostMapping("/addTenant")
		public Tenant addTenant(@RequestBody Tenant tenant) {
			return itenantservice.addTenant(tenant);
		}
	
	  @PutMapping("/updatelandlord/{landlordId}")
		public Landlord updateLandlord(@PathVariable("landlordId") Integer landlordId,@RequestBody Landlord landlord1 ) throws LandlordNotFoundException{
			return ilandlordservice.updateLandlord(landlordId, landlord1);
			
		}
	  
	  @PatchMapping("/addlandlordFlats/{landlordId}")
	  public Landlord addLandlordFlats(@PathVariable("landlordId")Integer landlordId,@RequestBody Flat flat) throws LandlordNotFoundException{
		  return ilandlordservice.addLandlordFlats(landlordId, flat);
	  }
		
		@PutMapping("/updateTenant/{tenant_id}")
		public Tenant updateTenant(@PathVariable("tenant_id") int tenant_id,@RequestBody Tenant tenant1) throws TenantNotFoundException {
			return itenantservice.updateTenant(tenant_id,tenant1);
		}
	  
	
	@GetMapping("/viewUser/{id}")
	public User viewUser(@PathVariable("id") Integer userId) throws UserNotFoundException{
		return iuserService.viewUser(userId);
		
	}
	
	@GetMapping("/viewAllUser")
	public List<User> viewAllUser(){
	 return iuserService.viewAllUser();
	}
	
	
	@DeleteMapping("/deleteLandlord/{landlordId}")
	public List<Landlord> deleteLandlord(@PathVariable ("landlordId") Integer landlordId) throws LandlordNotFoundException{
		return ilandlordservice.deleteLandlord(landlordId);
	}
	
	
	@DeleteMapping("/deleteTenant/{tenant_id}")
	public List<Tenant>  deleteTenant(@PathVariable("tenant_id") int tenant_id) throws TenantNotFoundException {
		return itenantservice.deleteTenant(tenant_id);
	}
	


	 @PutMapping("/updateFlat/{flatId}")
     public Flat updateFlat(@PathVariable("flatId")Integer flatId,@RequestBody Flat flat1) throws FlatNotFoundException{

     return iflatService.updateFlat(flatId, flat1);
 }
	 

	 
	 @DeleteMapping("/deleteFlat/{flatId}")
		public List<Flat>deleteFlat(@PathVariable("flatId")Integer flatId)throws FlatNotFoundException{
		
			return iflatService.deleteFlat(flatId);
		}

	
 
	 
}
