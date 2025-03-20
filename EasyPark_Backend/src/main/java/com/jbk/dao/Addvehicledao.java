package com.jbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Addvehicle;
import com.jbk.entity.Outvehicle;

@Repository
public class Addvehicledao {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public String addvehicle(Addvehicle addvehicle) {
		Session session=sessionfactory.openSession();
		try {
			
			session.save(addvehicle);
			session.beginTransaction().commit();
			return "vehicle added sucessfully";
		}catch(Exception e) {
			e.printStackTrace();
			return "something went wrong";
		}
		finally {
		 session.close();
		}
		
		
	}
	
	public List<Addvehicle> getallvehicle(){
		Session session=sessionfactory.openSession();
		try {
			Query query=session.createQuery("FROM Addvehicle");
			List<Addvehicle> list=query.list();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
		
	}
	public Addvehicle generatebills(int id) {
		Session session=sessionfactory.openSession();
		try {
			Addvehicle addvehicle=session.get(Addvehicle.class, id);
			return addvehicle;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
	}
	
	
	public String paybills(Outvehicle outvehicle) {
		Session session=sessionfactory.openSession();
		outvehicle.setPay("Paid");
		try {
			if(outvehicle.getPay().equals("Paid")) {
			session.update(outvehicle);
			Query query=session.createQuery("FROM Addvehicle Where vehicleno=:value");
			query.setParameter("value", outvehicle.getVehicleno());
			Addvehicle addvehicle=(Addvehicle) query.uniqueResult();
			session.delete(addvehicle);
			session.beginTransaction().commit();
			return "Pay bill sucessfully";
			}
			else {
				return "Something went wrong";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
		finally {
			
			session.close();
		}
	}
	public List<Outvehicle> getalloutvehicle() {
		Session session=sessionfactory.openSession();
		try {
			Query query=session.createQuery("FROM Outvehicle Where pay='Paid'");
			List<Outvehicle> list=query.list();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
	}

}
