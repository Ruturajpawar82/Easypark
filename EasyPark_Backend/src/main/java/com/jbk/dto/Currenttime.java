package com.jbk.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class Currenttime {
	
	public String getcurrenttime() {
		LocalDateTime localtime=LocalDateTime.now();
		DateTimeFormatter datetime=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String currenttime=localtime.format(datetime);
		return currenttime;
	}

}
