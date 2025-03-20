package com.jbk.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Addvehicle;
import com.jbk.entity.Outvehicle;
import com.jbk.service.Addvehicleservice;

@RestController
@CrossOrigin("http://localhost:4200")
public class Addvehiclecontroller {
	
	@Autowired
	Addvehicleservice addvehicleservice;
	
	@PostMapping("/addvehicle")
	public String addvehicle(@RequestBody Addvehicle addvehicle) throws ParseException {
		
		String status=addvehicleservice.Addvehicles(addvehicle);
		return status;
			
	}
	
	@GetMapping("/getvehicle")
	public List<Addvehicle> getallvehicle(){
		List<Addvehicle> list=addvehicleservice.getallvehicle();
		return list;
	}
	@GetMapping("/generatebill/{id}")
	public Outvehicle generatebill(@PathVariable int id) {
		
		
		return addvehicleservice.generatebill(id);
		
	}
	
	@PutMapping("/updatebill")
	
	public String paybills(@RequestBody Outvehicle outvehicle) {
		
		String result=addvehicleservice.paybills(outvehicle);
		return result;
	}
	@GetMapping("/getalloutvehicle")
	
	public List<Outvehicle> getalloutvehicle() {
		List<Outvehicle> list=addvehicleservice.getalloutvehicle();
		return list;
	}

}
