package com.codingchallange.premium.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "factors")
public class Factor
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nonnull
	private double factor;
	
	private long maxKilometers;
	private String vehicleType;
	private String region;
	
	
	public Factor()
	{
		
	}
	
	
	public Factor(double factor, long maxKilometers, String vehicleType, String region)
	{
		this.factor = factor;
		
		this.maxKilometers = maxKilometers;
		this.vehicleType = (vehicleType != null && !vehicleType.isBlank()) ? vehicleType : "-";
		this.region = (region != null && !region.isBlank()) ? region : "-";
	}
	
	
	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public long getMaxKilometers() {
		return maxKilometers;
	}

	public void setMaxKilometers(long maxKilometers) {
		this.maxKilometers = maxKilometers;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Long getId() {
		return id;
	}
}
