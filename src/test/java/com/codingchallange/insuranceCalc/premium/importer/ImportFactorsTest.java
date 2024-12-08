package com.codingchallange.insuranceCalc.premium.importer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingchallange.premium.importer.ImportFactors;
import com.codingchallange.premium.repository.RegionRepository;

@SpringBootTest
public class ImportFactorsTest
{
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private ImportFactors importFactors;
	
	
	@Test
	public void testImportFactors()
	{
		var factors = importFactors.importFactors(regionRepository.findDistinctFederalStates());
		assertEquals(0.5, factors.get(0).getFactor());
	}
}
