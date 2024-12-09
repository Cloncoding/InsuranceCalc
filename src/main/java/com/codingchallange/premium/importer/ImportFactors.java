package com.codingchallange.premium.importer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.codingchallange.premium.model.Factor;


@Component
public class ImportFactors
{
	private static final double DEFAULT_FACTOR = 1.0;
	
	
	public List<Factor> importFactors(List<String> states)
	{
		List<Factor> factors = new ArrayList<Factor>();
		
		// set km factor
		factors.add(new Factor(0.5, 5000, null, null));
		factors.add(new Factor(1, 10000, null, null));
		factors.add(new Factor(1.5, 20000, null, null));
		factors.add(new Factor(2, Long.MAX_VALUE, null, null));
		
		
		// set region factors
		double factor = DEFAULT_FACTOR;
		
		for(String state : states)
		{
			factors.add(new Factor((double)(Math.round(factor * 100.0) / 100.0), 0, null, state));
			factor += 0.1;
		}
		
		// set vehicle factors
		factor = 100 + DEFAULT_FACTOR;
		
		for(String vehicleType : new String[]
				{
						"Cabrio",
						"Coupè",
						"Kleinwagen",
						"Kompaktwagen",
						"Kombi",
						"SUV",
						"VAN"
				})
		{
			factors.add(new Factor((double)(Math.round(factor * 100.0) / 100.0), 0, vehicleType, null));
			factor += 0.1;
		}
		
		return factors;
	}
}
