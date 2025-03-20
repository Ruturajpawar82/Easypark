package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Loginuser;
import com.jbk.entity.Registeruser;
import com.jbk.exception.RegisteruserException;
import com.jbk.service.Registeruserservice;

@RestController()
@CrossOrigin("http://localhost:4200")
public class Usercontroller {
	
	@Autowired
	Registeruserservice servicedao;
	
	@PostMapping("/user/register")
	
	public String registeruser(@RequestBody Registeruser user) throws RegisteruserException {
		
		byte status=servicedao.registeruser(user);
		
		if(status==1) {
			return "account created sucessfully";
		}
		else {
			return "account already exist";
		}
		
	}
	
	@PostMapping("/user/login") 
	public String login(@RequestBody Loginuser login ) throws Exception  {
		
		byte status=servicedao.login(login);
		
		if(status==1) {
			return "login sucessfully";
		}
		else  {
			return "invalid creaditials";
		}
		
		
	}

}
