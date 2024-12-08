package com.codingchallange.premium.importer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.codingchallange.premium.model.Region;

@Component
public class ImportCSVPostCodes
{
	private static final String CSV_FILE = "postcodes.csv";
	private static final Path DEFAULT_PATH = Paths.get("src", "main", "resources", "csv", CSV_FILE);
	
	
	public List<Region> importCSV(String csv)
	{
		try(Reader r = (csv == null || csv.isBlank() || csv.isEmpty()) ? Files.newBufferedReader(DEFAULT_PATH) : new StringReader(csv))
		{
			List<Region> regions = new ArrayList<Region>();
			
			CSVParser pars = new CSVParser(r, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreSurroundingSpaces(true).withTrim());
			for(CSVRecord record : pars.getRecords())
			{
				Region region = new Region(
						record.get("REGION1"),
						record.get("REGION3"),
						record.get("REGION4"),
						Long.parseLong(record.get("POSTLEITZAHL")),
						record.get("ORT"));
				
				regions.add(region);
			}
			
			pars.close();
			
			return regions;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
