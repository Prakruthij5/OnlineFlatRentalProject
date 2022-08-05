package com.cg.ofr.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;

public interface ILandlordService {

	
	public Landlord addLandlord(Landlord landlord);
	
	public Landlord addLandlordFlats(Integer landlordId,Flat flat) ;
	
	//public Landlord updateLandlordFlats(Integer landlordId, Flat flat) throws LandlordNotFoundException;
	
	public Landlord updateLandlord(Integer landlordId,Landlord landlord1) throws LandlordNotFoundException;
	
	public List<Landlord> deleteLandlord(Integer landlordId)throws LandlordNotFoundException;
	
	public Landlord getLandlord(Integer landlordId) throws LandlordNotFoundException;
	
	public List<Landlord> getAllLandlord();
	
}
