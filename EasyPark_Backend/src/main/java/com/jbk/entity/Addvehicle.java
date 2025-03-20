package com.jbk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Addvehicle {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String ownername;
	public String vehicleno;
	public String time;
	public String category;
	public int charges;
	public String outvehicletime;
	
	public Addvehicle() {
		
	}

	public Addvehicle(int id, String ownername, String vehicleno, String time, String category, int charges,
			String outvehicletime) {
		super();
		this.id = id;
		this.ownername = ownername;
		this.vehicleno = vehicleno;
		this.time = time;
		this.category = category;
		this.charges = charges;
		this.outvehicletime = outvehicletime;
	}
	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

	public String getOutvehicletime() {
		return outvehicletime;
	}

	public void setOutvehicletime(String outvehicletime) {
		this.outvehicletime = outvehicletime;
	}

	@Override
	public String toString() {
		return "Addvehicle [id=" + id + ", ownername=" + ownername + ", vehicleno=" + vehicleno + ", time=" + time
				+ ", category=" + category + ", charges=" + charges + ", outvehicletime=" + outvehicletime + "]";
	}

	
	
	
	
	

}
