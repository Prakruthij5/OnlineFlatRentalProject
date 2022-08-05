package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.FlatAddress;

@Repository
public interface IFlatAddressRepository extends JpaRepository <FlatAddress,Integer>{

}
