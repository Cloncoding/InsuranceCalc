package com.codingchallange.premium.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingchallange.Consts;
import com.codingchallange.premium.model.Premium;
import com.codingchallange.premium.service.DbService;

@RestController
@RequestMapping(Consts.URL_API_DB)
public class DbController
{	
	@Autowired
	private DbService dbService;
	
	
	@PostMapping(Consts.URL_DB_IMPORT_REGIONS)
	private ResponseEntity<String> importRegions(@RequestBody(required = false) String csv)
	{
		return new ResponseEntity<String>(dbService.importRegions(csv) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(Consts.URL_DB_IMPORT_FACTORS)
	private ResponseEntity<String> importFactors()
	{
		return new ResponseEntity<String>(dbService.importFactors() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(Consts.URL_DB_IMPORT_ALL)
	private ResponseEntity<String> importAll(@RequestBody(required = false) String csv)
	{
		return new ResponseEntity<String>(dbService.importRegions(csv) && dbService.importFactors() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping(Consts.URL_DB_PREMIUM)
	private ResponseEntity<Premium> savePremium(@RequestBody Premium premium)
	{
		Premium saved = dbService.saveCalculation(premium);
		
		return ResponseEntity.created(URI.create(Consts.URL_DB_PREMIUM + saved.getId())).body(saved);
	}
}
