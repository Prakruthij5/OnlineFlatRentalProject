package com.cg.ofr.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;
import com.cg.ofr.service.ITenantService;

@Service
public class TenantService implements ITenantService  {
	
	@Autowired
	private ITenantRepository tenantRepository;
	
	public Tenant addTenant(Tenant tenant) {
		tenantRepository.saveAndFlush(tenant);
		return tenant;
	}
	
	public Tenant updateTenant(Integer tenant_id, Tenant tenant1) throws TenantNotFoundException{
        Optional<Tenant>tenant=tenantRepository.findById(tenant_id);
            if (tenant.isPresent()) {
                Tenant t1=tenant.get();
                t1.setTenant_age(t1.getTenant_age());
                t1.setTenantName(t1.getTenantName());
                t1=tenantRepository.save(t1);
                return t1;
            }
            return null;
        }
	
	public List<Tenant> deleteTenant(int tenant_id) throws TenantNotFoundException {
		if(!tenantRepository.existsById(tenant_id)) {
			throw new TenantNotFoundException();
	    }	
		tenantRepository.deleteById(tenant_id);	
			return tenantRepository.findAll();
}
	
public Tenant viewTenant(int tenant_id) throws TenantNotFoundException{
	    if(!tenantRepository.existsById(tenant_id)) {
	    	
			throw new TenantNotFoundException();
	    }	
			return tenantRepository.findById(tenant_id).get();
	}	



public List<Tenant> viewAllTenant(){
	return tenantRepository.findAll();
}



public List<Tenant> validateTenantById(int tenant_Id) {
	return tenantRepository.findAll();
}	
}



