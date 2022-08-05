package com.cg.ofr.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IFlatRepository;
import com.cg.ofr.repository.ILandlordRepository;
import com.cg.ofr.repository.IUserRepository;
import com.cg.ofr.service.ILandlordService;


@Service
public class LandlordService implements ILandlordService  {
	
	@Autowired
	private ILandlordRepository landlordRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IFlatRepository flatRepository;
	

	public Landlord addLandlord(Landlord landlord) {
		User user=landlord.getUser();
		try {
			user =userRepository.findById(user.getUserId()).orElseThrow(UserNotFoundException::new);
			landlord.setUser(user);
			System.out.println("user set for landlord *******");
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * List<Flat> flats=landlord.getFlatList(); List<Flat> newflats=new
		 * ArrayList<>(); for(Flat f:flats){ try {
		 * flatRepository.findById(f.getFlatId()).orElseThrow(FlatNotFoundException::new
		 * ); newflats.add(f); }
		 * 
		 * catch (FlatNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } landlord.setFlatList(newflats);
		 */
		landlordRepository.save(landlord);
		//return landlordRepository.findAll();
		return landlord;
	}
	
	
	

	public Landlord updateLandlord(Integer landlordId, Landlord landlord1) throws LandlordNotFoundException{
		Optional<Landlord> landlord=landlordRepository.findById(landlordId);
		 
		 if (landlord.isPresent()) {
	            Landlord ld = landlord.get();
	            
	           // Landlord newLandlord=new Landlord();
	            ld.setLandlordName(landlord1.getLandlordName());
	            ld.setLandlordAge(landlord1.getLandlordAge());
	            ld.setFlatList(landlord1.getFlatList());
	            
	    		ld=landlordRepository.save(ld);
	    		return landlord1;
		 }
		 return null;
	}

	
	 public Landlord addLandlordFlats(Integer landlordId,Flat flat) {
	 Optional<Landlord> landlord=landlordRepository.findById(landlordId);
	 
	 if (landlord.isPresent()) { 
		 Landlord ld = landlord.get();
	 
	 List<Flat>flats=(ld.getFlatList()); 
	 flatRepository.save(flat);
	flats.add(flat); ld.setFlatList(flats); System.out.println("flats"+flats);
	 System.out.println("flats"+flat);
	 
	  ld=landlordRepository.save(ld); System.out.println("landlords flats"+ld);
	 return ld; } return null; }
	 
	
	/*public Landlord updateLandlordFlats(Integer landlordId, Flat flat) throws LandlordNotFoundException{
		Optional<Landlord> landlord=landlordRepository.findById(landlordId);
		 
		 if (landlord.isPresent()) {
	            Landlord ld = landlord.get();
	            
	           // Landlord newLandlord=new Landlord();
	            Flat dbflat=null;
	         List<Flat> flats=ld.getFlatList();
	         System.out.println("***"+flats);
	         try {
	        	
				dbflat=flatRepository.findById(flat.getFlatId()).orElseThrow(FlatNotFoundException::new);
			} 
	         catch (FlatNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         
	         flats.add(dbflat);
	         ld.setFlatList(flats);
	        System.out.println("*****"+dbflat);
	            
	    		ld=landlordRepository.save(ld);
	    		System.out.println("***"+ld);
	    		return ld;
	    		
		 }
		 return null;
	}
	*/

	public List<Landlord> deleteLandlord(Integer landlordId)throws LandlordNotFoundException{
		if(!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException();
		}
		landlordRepository.deleteById(landlordId);
		return landlordRepository.findAll();
	
	}


	public Landlord getLandlord(Integer landlordId) throws LandlordNotFoundException{

	if(!landlordRepository.existsById(landlordId)) {
		throw new LandlordNotFoundException();
	}
	return landlordRepository.findById(landlordId).get();
	}


	public List<Landlord> getAllLandlord(){
		return landlordRepository.findAll();
		}


}





	/*
	 * public Landlord updateLandlord(Landlord landlord) throws
	 * LandlordNotFoundException; public Landlord deleteLandlord(Landlord landlord)
	 * throws LandlordNotFoundException; public Landlord viewLandlord(int id) throws
	 * LandlordNotFoundException; public List<Landlord> viewAllLandlord();
	 */

