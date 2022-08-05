package com.cg.ofr.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.IFlatBookingRepository;
import com.cg.ofr.repository.IFlatRepository;
import com.cg.ofr.service.IFlatBookingService;



@Service
public class FlatBookingService implements IFlatBookingService {
	
	
	@Autowired
    private IFlatBookingRepository flatbookingRepository;

    @Autowired
    private IFlatRepository flatRepository;

    public FlatBooking addFlatBooking(FlatBooking flatbooking) {
        Flat flat=flatbooking.getFlat();
        try {
            flat=flatRepository.findById(flat.getFlatId()).orElseThrow(FlatNotFoundException::new);
            flatbooking.setFlat(flat);
            System.out.println("flat set for flatbooking *****");
        }catch (FlatNotFoundException e) {
            e.printStackTrace();
        }
        flatbookingRepository.save(flatbooking);
        return flatbooking;
    }


    public List<FlatBooking> getAllFlatBooking(){
        return flatbookingRepository.findAll();
     }

    

    
     public FlatBooking updateFlatBooking(Integer bookingNo,FlatBooking flatbooking1) throws FlatBookingNotFoundException{
          Optional<FlatBooking> flatbooking = flatbookingRepository.findById(bookingNo);

          if(flatbooking.isPresent()) {
              FlatBooking fb=flatbooking.get();


            //FlatBooking newFlatBooking = new FlatBooking();
            fb.setBookingFromDate(flatbooking1.getBookingFromDate());
            fb.setBookingToDate(flatbooking1.getBookingToDate());
            fb=flatbookingRepository.save(fb);
            return fb;
          }
          return null;
     }




      public List<FlatBooking> deleteFlatBooking(Integer bookingNo) throws FlatBookingNotFoundException{

          if(!flatbookingRepository.existsById(bookingNo)) {
              throw new FlatBookingNotFoundException(); 
      } 

          flatbookingRepository.deleteById(bookingNo);
      return flatbookingRepository.findAll(); 
      }




      public FlatBooking getFlatBooking(Integer bookingNo) throws  FlatBookingNotFoundException{
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

	


