package com.codingchallange.premium.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "regions")
public class Region
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String federalState;
	private String country;
	private String city;
	private long postalCode;
	private String district;
	
	
	public Region()
	{
		
	}
	
	
	public Region(String federalState, String country, String city, long postalCode, String district)
	{
		this.federalState = federalState;
		this.country = country;
		this.city = city;
		this.postalCode = postalCode;
		this.district = district;
	}
	
	
	public Long getId()
	{
		return id;
	}
	
	
	public String getFederalState()
	{
		return federalState;
	}
	
	public void setFederalState(String federalState)
	{
		this.federalState = federalState;
	}
	
	
	public String getCountry()
	{
		return country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	
	public long getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(long postalCode)
	{
		this.postalCode = postalCode;
	}
	
	
	public String getDistrict()
	{
		return district;
	}
	
	public void setDistrict(String district)
	{
		this.district = district;
	}
}
