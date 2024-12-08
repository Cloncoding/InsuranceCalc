package com.codingchallange.premium.repository;

import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codingchallange.premium.model.Region;

@Repository
@Order(9)
public interface RegionRepository extends JpaRepository<Region, Long>
{
	@Query("SELECT DISTINCT r.federalState FROM Region r")
	public List<String> findDistinctFederalStates();
	
	List<Region> findByPostalCode(long postalCode);
}
