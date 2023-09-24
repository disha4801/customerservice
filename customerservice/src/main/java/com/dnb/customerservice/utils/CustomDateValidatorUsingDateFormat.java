package com.dnb.customerservice.utils;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomDateValidatorUsingDateFormat implements CustomDateValidator {
 
	 private String dateFormat;

	    public CustomDateValidatorUsingDateFormat(String dateFormat) {
	        this.dateFormat = dateFormat;
	    }

	

	@Override
	public boolean isValidDate(LocalDate dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        String temp=dateStr.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        try {
            sdf.parse(temp);
            return true; // Input date is valid
        } catch (ParseException e) {
            return false; // Input date is invalid
        }
    }
				
}
