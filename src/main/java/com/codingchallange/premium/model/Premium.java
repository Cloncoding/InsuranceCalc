package com.codingchallange.premium.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "premiums")
public class Premium
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double premiumAmount;
	private long estimatedKm;
	private long postalCode;
	private String vehicleType;
	
	
	public Premium()
	{
		
	}
	
	public Premium(double premiumAmount, long estimatedKm, long postalCode, String vehicleType)
	{
		this.premiumAmount = premiumAmount;
		this.estimatedKm = estimatedKm;
		this.postalCode = postalCode;
		this.vehicleType = vehicleType;
	}
	
	
	public Long getId()
	{
		return id;
	}
	
	
	public double getPremiumAmount()
	{
		return premiumAmount;
	}
	
	public void setPremiumAmount(double premiumAmount)
	{
		this.premiumAmount = premiumAmount;
	}
	
	
	public long getEstimatedKm()
	{
		return estimatedKm;
	}
	
	public void setEstimatedKm(long estimatedKm)
	{
		this.estimatedKm = estimatedKm;
	}
	
	
	public long getRegionCode()
	{
		return postalCode;
	}
	
	public void setRegionCode(long regionCode)
	{
		this.postalCode = regionCode;
	}
	
	
	public String getVehicleType()
	{
		return vehicleType;
	}
	
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType = vehicleType;
	}
}
