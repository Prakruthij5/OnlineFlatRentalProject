package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Tenant;

@Repository
public interface ITenantRepository extends JpaRepository<Tenant,Integer> {

	/*
	 * @Query("select t.tenant_id from Tenant t inner join User u where t.user.userId=u.userId and u.userId=:userId"
	 * ) public Integer getTenantId(Integer userId);
	 */


}
