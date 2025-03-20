package com.jbk.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.Addvehicledao;
import com.jbk.dto.Currenttime;
import com.jbk.entity.Addvehicle;
import com.jbk.entity.Generatebill;
import com.jbk.entity.Outvehicle;

@Service
public class Addvehicleservice {
	
	
	@Autowired
	Addvehicledao addvehicledao;
	
	@Autowired
	 Currenttime current;
	
	@Autowired
	SessionFactory sessionfactory;
	
	public String Addvehicles(Addvehicle addvehicle) throws ParseException {
		
		String time = addvehicle.getTime(); 

		// Parse the ISO 8601 timestamp (Z means UTC)
		Instant instant = Instant.parse(time);

		// Convert to LocalDateTime with a specific timezone (e.g., IST)
		ZoneId zoneId = ZoneId.of("Asia/Kolkata"); // Change as per requirement
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);

		// Format to desired output
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String newDate = zonedDateTime.format(outputFormat);

		addvehicle.setTime(newDate);
		String result = addvehicledao.addvehicle(addvehicle);
		return result;

	}
	
	public List<Addvehicle> getallvehicle(){
		List<Addvehicle>list=addvehicledao.getallvehicle();
		return list;
	}
	public Outvehicle generatebill(int id) {
		Addvehicle addvehicle=addvehicledao.generatebills(id);
		String intime=addvehicle.getTime();
		String outtime=current.getcurrenttime();
	
		DateTimeFormatter datetimeformat=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		LocalDateTime indate=LocalDateTime.parse(intime, datetimeformat);
		LocalDateTime outdate=LocalDateTime.parse(outtime, datetimeformat);
		
		Duration between=Duration.between(indate, outdate);
		int duration =(int)between.toHours();
		int total=(int)duration*addvehicle.getCharges();
		 
		Generatebill bills=new Generatebill();
		bills.setHours(duration);
		bills.setTotal(total);
		Outvehicle outvehicle=new Outvehicle();
		outvehicle.setOwnername(addvehicle.getOwnername());
		outvehicle.setVehicleno(addvehicle.getVehicleno());
		outvehicle.setTime(addvehicle.getTime());
		outvehicle.setCategory(addvehicle.getCategory());
		outvehicle.setCharges(addvehicle.getCharges());
		outvehicle.setOutvehicletime(outtime);
		outvehicle.setGeneratebill(bills);
		
		Session session=sessionfactory.openSession();
		try {
	        Transaction transaction = session.beginTransaction(); 
	        session.save(outvehicle);
	        transaction.commit(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close(); // Ensure session is closed
	    }
		return outvehicle;
		
	}
	
	public String paybills(Outvehicle outvehicle) {
		String status=addvehicledao.paybills(outvehicle);
		return status;
	}
	
	public List<Outvehicle> getalloutvehicle(){
		List<Outvehicle> list=addvehicledao.getalloutvehicle();
		return list;
	}
	
	
}
