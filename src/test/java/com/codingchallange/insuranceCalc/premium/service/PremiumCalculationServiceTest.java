package com.codingchallange.insuranceCalc.premium.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingchallange.premium.model.Premium;
import com.codingchallange.premium.service.PremiumCalculationService;

@SpringBootTest
public class PremiumCalculationServiceTest
{

    @Autowired
    private PremiumCalculationService premiumCalculationService;

    @Test
    public void testCalculatePremium() throws Exception
    {
        Premium premium = premiumCalculationService.calculatePremium(15000, 51674, "SUV");
        assertEquals(Math.round((1.5 * 1.4 * 1.5) * 100.0) / 100.0, premium.getPremiumAmount());
    }
}

