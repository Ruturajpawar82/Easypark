package com.jbk.controller;

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

import com.jbk.entity.Addcategoryandcharges;
import com.jbk.service.Addcategoryservice;

@RestController()
@CrossOrigin("http://localhost:4200")
@RequestMapping("/admin")
public class Admincontroller {
	
	@Autowired
	Addcategoryservice addcategory1;
	
	@PostMapping("/addcategory")
	public String addcategory(@RequestBody Addcategoryandcharges add) {
		
		
		
		byte status=addcategory1.addcategory(add);
		if(status==1) {
			return "category added sucessfully";
		}
		else if(status==2) {
			return "category already exist";
		}
		else {
			return "something went wrong";
		}
		
	}
	
	@GetMapping("/getallcategory")
	public List<Addcategoryandcharges> getallcategory(){
		List<Addcategoryandcharges> list=addcategory1.getallcategory();
		return list;
	}
	
	@GetMapping("/getcategory/{id}")
	public Addcategoryandcharges getcategorybyid(@PathVariable int id) {
		System.err.println(id);
		Addcategoryandcharges newobj=addcategory1.getcategorybyid(id);
		return newobj;
	}
	
	@PutMapping("/updatecategory")
	public String updatecategory(@RequestBody Addcategoryandcharges add) {
		
		String status=addcategory1.updatecategory(add);
		return status;
		
	}

}
