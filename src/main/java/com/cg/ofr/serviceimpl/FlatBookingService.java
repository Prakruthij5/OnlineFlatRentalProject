package com.cg.ofr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.IFlatBookingRepository;
import com.cg.ofr.service.IFlatBookingService;



@Service
public class FlatBookingService implements IFlatBookingService {
	
	
	@Autowired
	private IFlatBookingRepository flatbookingRepository;
	
	public String addFlatBooking(FlatBooking flatbooking) {
		flatbookingRepository.saveAndFlush(flatbooking);
		return "Added";
	}
	
	public List<FlatBooking> viewAllFlatBooking(){
   	 return flatbookingRepository.findAll();
}

	
	
	  public List<FlatBooking> updateFlatBooking(Integer bookingNo,String location) throws FlatBookingNotFoundException{
	  
		  if(!flatbookingRepository.existsById(bookingNo)) { 
		       throw new FlatBookingNotFoundException(); 
		  } 
	  FlatBooking flatbooking=flatbookingRepository.findById(bookingNo).get();
	  
	  flatbooking.setLocation(location);
	  flatbookingRepository.flush();
	  return flatbookingRepository.findAll();
	  }
	  
	 
	  
	  
	  public List<FlatBooking> deleteFlatBooking(Integer bookingNo) throws FlatBookingNotFoundException{
	  
		  if(!flatbookingRepository.existsById(bookingNo)) {
			  throw new FlatBookingNotFoundException(); 
	  } 
	 
		  flatbookingRepository.deleteById(bookingNo);
	  return flatbookingRepository.findAll(); 
	  }
	  
	  
	  
	  
	  public FlatBooking viewFlatBooking(Integer bookingNo) throws  FlatBookingNotFoundException{
	  if(!flatbookingRepository.existsById(bookingNo))
	  { 
		  throw new FlatBookingNotFoundException(); 
		  } 
	  return flatbookingRepository.findById(bookingNo).get();
	
	  
	  
			}

	
	 
     
     
     
     

	
	}

	

		
//	public Flat updateFlatBooking(Flat flat) throws FlatBookingNotFoundException;
//	public Flat deleteFlatBooking(Flat flat) throws FlatBookingNotFoundException;
//	public Flat viewFlatBooking(int id) throws FlatBookingNotFoundException;
//	public List<FlatBooking> viewAllFlatBooking();

	


