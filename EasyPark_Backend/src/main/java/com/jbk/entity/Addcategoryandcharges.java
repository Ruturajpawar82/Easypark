package com.jbk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "add_category")
public class Addcategoryandcharges {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String category;
	private byte hours;
	private int charges;
	
	public Addcategoryandcharges() {
		
	}

	public Addcategoryandcharges(int id, String category, byte hours, int charges) {
		super();
		this.id = id;
		this.category = category;
		this.hours = hours;
		this.charges = charges;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte getHours() {
		return hours;
	}

	public void setHours(byte hours) {
		this.hours = hours;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

	@Override
	public String toString() {
		return "Addcategory [id=" + id + ", category=" + category + ", hours=" + hours + ", charges=" + charges + "]";
	}
	
	

}
