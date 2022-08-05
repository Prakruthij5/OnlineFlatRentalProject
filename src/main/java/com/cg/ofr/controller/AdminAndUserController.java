package com.cg.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.serviceimpl.FlatBookingService;
import com.cg.ofr.serviceimpl.FlatService;
import com.cg.ofr.serviceimpl.LandlordService;
import com.cg.ofr.serviceimpl.TenantService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin_user")
public class AdminAndUserController {

	

	@Autowired
	private FlatBookingService iflatbookingService;
	
	@Autowired
	private FlatService flatService;
	
	@Autowired
	private TenantService itenantService;
	
	@Autowired
	private LandlordService ilandlordService;
	
	@GetMapping("/viewTenantById/{tenant_id}")
	public Tenant viewTenantById(@PathVariable("tenant_id") int tenant_id) throws TenantNotFoundException {
		return itenantService.viewTenant(tenant_id);
	}
	@GetMapping("/viewAllTenant")
	public List<Tenant> viewAllTenant() {
		return itenantService.viewAllTenant();
	}
	
	@GetMapping("/viewAllFlat")
	public List<Flat>viewAllFlat(){
		return flatService.viewAllFlat();
	}

	 @GetMapping("/getAllFlatBooking")
     public List<FlatBooking> getAllFlatBooking() {

         return iflatbookingService.getAllFlatBooking();
     }

		/*
		 * @GetMapping("/getTenantId/{userId}") public Integer
		 * getTenantId(@PathVariable("userId") Integer userId) { return
		 * itenantService.getTenantId(userId); }
		 */
	  
		@GetMapping("/getLandlordById/{landlordId}")
		public Landlord getLandlordById(@PathVariable("landlordId") Integer landlordId) throws LandlordNotFoundException{
			return ilandlordService.getLandlord(landlordId);
			
		}
		
		@GetMapping("/getAllLandlord")
		public List<Landlord> getAllLandlord(){
		 return ilandlordService.getAllLandlord();
		}
		
	
	
	
	
	
   
	  
}
