package com.cg.ofr.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;

public interface IFlatBookingService {
	
	public FlatBooking addFlatBooking(FlatBooking flatbooking);

    public List<FlatBooking> getAllFlatBooking();

    public FlatBooking updateFlatBooking(Integer bookingNo,FlatBooking flatbooking1) throws
      FlatBookingNotFoundException;

    public List<FlatBooking> deleteFlatBooking(Integer bookingNo) throws
      FlatBookingNotFoundException;

    public FlatBooking getFlatBooking(Integer bookingNo) throws
      FlatBookingNotFoundException;
	 
	
}
