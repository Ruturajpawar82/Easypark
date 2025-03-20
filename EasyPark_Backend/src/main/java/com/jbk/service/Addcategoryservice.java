package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.Addcategory;
import com.jbk.entity.Addcategoryandcharges;

@Service
public class Addcategoryservice {
	
	@Autowired
	Addcategory addcategorys;
	
	
	public byte addcategory(Addcategoryandcharges add) {
		 byte status=addcategorys.addcategory(add);
		 return status;
	}
	
	
	public  List<Addcategoryandcharges> getallcategory(){
		 List<Addcategoryandcharges> list=addcategorys.getallcategory();
		 return list;
	}
	
	public Addcategoryandcharges getcategorybyid(int id) {
		Addcategoryandcharges newobj=addcategorys.getcategorybyid(id);
		return newobj;
	}
	
	public String updatecategory(Addcategoryandcharges add) {
		String status=addcategorys.updatecategory(add);
		return status;
	}

}
