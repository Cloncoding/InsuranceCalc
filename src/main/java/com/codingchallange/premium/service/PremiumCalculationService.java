package com.codingchallange.premium.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingchallange.premium.model.Factor;
import com.codingchallange.premium.model.Premium;
import com.codingchallange.premium.model.Region;
import com.codingchallange.premium.repository.FactorRepository;
import com.codingchallange.premium.repository.RegionRepository;

@Service
public class PremiumCalculationService
{
	@Autowired
	private FactorRepository factorRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	
	private double getFactorKM(long estimatedKm)
	{
		Optional<Factor> fkm = factorRepository.findFirstKMFactor(estimatedKm);
		if(fkm.isPresent())
		{
			fkm.get().getFactor();
		}
		
		return fkm.isPresent() ? fkm.get().getFactor() : 1;
	}
	
	private double getFactorRegion(long postalCode) throws Exception
	{
		List<Region> postalCodes = regionRepository.findByPostalCode(postalCode);
		
		if(postalCodes.isEmpty())
		{
			throw new Exception("Postalcode not found " + postalCode);
		}
		
		List<Factor> region = factorRepository.findByRegion(postalCodes.get(0).getFederalState());
		return !region.isEmpty() ? region.get(0).getFactor() : 1;
	}
	
	private double getFactorVehicleType(String vehicleType) throws Exception
	{
		List<Factor> types = factorRepository.findByVehicleType(vehicleType);
		
		if(types.isEmpty())
		{
			throw new Exception("Vehicle type not found " + vehicleType);
		}
		
		return !types.isEmpty() ? types.get(0).getFactor() : 1;
	}
	
	
	public Premium calculatePremium(long estimatedKm, long postalCode, String vehicleType) throws Exception
	{
		return new Premium((double)(Math.round((getFactorKM(estimatedKm) * getFactorRegion(postalCode) * getFactorVehicleType(vehicleType)) * 100.0) / 100.0), estimatedKm, postalCode, vehicleType);
	}
}
