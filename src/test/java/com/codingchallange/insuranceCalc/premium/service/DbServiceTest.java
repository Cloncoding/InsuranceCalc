package com.codingchallange.insuranceCalc.premium.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingchallange.premium.model.Premium;
import com.codingchallange.premium.service.DbService;

@SpringBootTest
public class DbServiceTest
{
	@Autowired
	private DbService dbService;
	
	
	@Test
	public void testSaveCalculation()
	{
		Premium p = dbService.saveCalculation(new Premium(50, 5000, 51674, "VAN"));
		assertNotNull(p.getId());
	}
}
