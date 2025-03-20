package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.Registeruserdao;
import com.jbk.entity.Loginuser;
import com.jbk.entity.Registeruser;

@Service
public class Registeruserservice {
	
	@Autowired
	Registeruserdao userdao;
	
	public byte registeruser(Registeruser user) {
		
		byte status=userdao.registeruser(user);
		return status;
		
	}
	
      public byte login(Loginuser user) {
		
		byte status=userdao.loginuser(user);
		return status;
		
	}

}
