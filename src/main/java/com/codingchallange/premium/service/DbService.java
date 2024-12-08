package com.codingchallange.premium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.codingchallange.premium.importer.ImportCSVPostCodes;
import com.codingchallange.premium.importer.ImportFactors;
import com.codingchallange.premium.model.Premium;
import com.codingchallange.premium.repository.FactorRepository;
import com.codingchallange.premium.repository.PremiumRepository;
import com.codingchallange.premium.repository.RegionRepository;

@Service
public class DbService
{
	@Autowired
	private PremiumRepository premiumRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private FactorRepository factorRepository;
	
	
	@Autowired
	private ImportCSVPostCodes importCSVPostCodes;
	@Autowired
	private ImportFactors importFactors;
	
	
	private <T> boolean saveImportedData(JpaRepository<T, Long> repo, List<T> data)
	{
		if(data != null)
		{
			data.forEach(d -> repo.save(d));
			
			return true;
		}
		
		return false;
	}
	
	
	public Premium saveCalculation(Premium premium)
	{
		return premiumRepository.save(premium);
	}
	
	
	public boolean importRegions(String csv)
	{
		regionRepository.deleteAll();
		
		return saveImportedData(regionRepository, importCSVPostCodes.importCSV(csv));
	}
	
	public boolean importFactors()
	{
		factorRepository.deleteAll();
		
		return saveImportedData(factorRepository, importFactors.importFactors(regionRepository.findDistinctFederalStates()));
	}
}
