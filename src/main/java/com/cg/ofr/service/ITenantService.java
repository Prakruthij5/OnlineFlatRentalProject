package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;

public interface ITenantService {

	public Tenant addTenant(Tenant tenant);
	
	public Tenant updateTenant(Integer tenant_id, Tenant tenant1) throws TenantNotFoundException;
	
	public List<Tenant> deleteTenant(int tenant_id) throws TenantNotFoundException ;
	
	public Tenant viewTenant(int tenant_id) throws TenantNotFoundException;
	
	public List<Tenant> viewAllTenant();
	
	
	
	public List<Tenant> validateTenantById(int tenant_Id);
	
}
