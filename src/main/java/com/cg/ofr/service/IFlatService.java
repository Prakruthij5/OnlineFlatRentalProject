package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;

public interface IFlatService {

	public Flat addFlat(Flat flat);
	
	 public Flat updateFlat(Integer flatId,Flat flat1) throws FlatNotFoundException;
	
	public List<Flat> deleteFlat(Integer flatId) throws FlatNotFoundException;
	
	public Flat viewFlat(Integer flatId) throws FlatNotFoundException;

	public List<Flat> viewAllFlat();
	 
	 
}