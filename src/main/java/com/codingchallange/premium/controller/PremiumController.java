package com.codingchallange.premium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.codingchallange.Consts;
import com.codingchallange.premium.model.Premium;
import com.codingchallange.premium.service.PremiumCalculationService;


@RestController
@RequestMapping(Consts.URL_API_PREMIUM)
public class PremiumController
{
	@Autowired
	private PremiumCalculationService premiumCalculationService;
	
	
	@PostMapping(Consts.URL_PREMIUM_CALCULATE)
	public ResponseEntity<?> calculatePremium(@RequestParam long km, @RequestParam long postalCode, @RequestParam String vehicleType)
	{
		try
		{
			Premium p = premiumCalculationService.calculatePremium(km, postalCode, vehicleType);			
			return new RestTemplate().postForEntity(Consts.URL_LOCALHOST + Consts.URL_API_DB_PREMIUM, p, Premium.class);
		}
		catch(Exception e)
		{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
