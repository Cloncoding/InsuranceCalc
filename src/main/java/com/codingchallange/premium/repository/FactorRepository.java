package com.codingchallange.premium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingchallange.premium.model.Factor;

import java.util.List;
import java.util.Optional;


@Repository
public interface FactorRepository extends JpaRepository<Factor, Long>
{
	public List<Factor> findByMaxKilometers(long maxKilometers);
	public List<Factor> findByRegion(String region);
	public List<Factor> findByVehicleType(String vehicleType);
	
	@Query("SELECT new Factor(f.factor, f.maxKilometers, f.vehicleType, f.region) FROM Factor f where maxKilometers >= :km ORDER BY maxKilometers ASC FETCH FIRST 1 ROWS ONLY")
	public Optional<Factor> findFirstKMFactor(@Param("km") long km);
}
