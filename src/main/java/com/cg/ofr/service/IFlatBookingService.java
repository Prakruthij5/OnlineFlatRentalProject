package com.cg.ofr.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;

public interface IFlatBookingService {

	public String addFlatBooking(FlatBooking flat);
	
	public List<FlatBooking> viewAllFlatBooking();
	
	public List<FlatBooking> updateFlatBooking(Integer bookingNo, String location) throws
	  FlatBookingNotFoundException;
	 
	public List<FlatBooking> deleteFlatBooking(Integer bookingNo) throws
	  FlatBookingNotFoundException;
	 
	public FlatBooking viewFlatBooking(Integer bookingNo) throws
	  FlatBookingNotFoundException;
	 
	 
	
}
