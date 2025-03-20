package com.jbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Addcategoryandcharges;

@Repository
public class Addcategory {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public byte addcategory(Addcategoryandcharges add) {
		Session session=sessionfactory.openSession();
		try {
			
			
			Query query=session.createQuery("FROM Addcategoryandcharges Where category=:name");
			query.setParameter("name", add.getCategory());
			Addcategoryandcharges addcategory=(Addcategoryandcharges) query.uniqueResult();
			if(addcategory==null) {
				session.save(add);
				session.beginTransaction().commit();
				return 1;
			}
			else {
				return 2;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return 3;
		}
		finally {
			session.close();
		}
	}
	public List<Addcategoryandcharges> getallcategory(){
		Session session=sessionfactory.openSession();
		try {
			Query query=session.createQuery("FROM Addcategoryandcharges");
			List<Addcategoryandcharges>list=query.list();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
		
	}
	
	public Addcategoryandcharges getcategorybyid(int id) {
		Session session=sessionfactory.openSession();
		try {
			Addcategoryandcharges newobj=session.get(Addcategoryandcharges.class, id);
			return newobj;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
	}
	
	public String updatecategory(Addcategoryandcharges add) {
		Session session=sessionfactory.openSession();
		try {
			session.update(add);
			session.beginTransaction().commit();
			return "data updated sucessfully";
		}catch(Exception e) {
			e.printStackTrace();
			return "something went wrong";
		}
		finally {
			session.close();
		}
		
		
	}

}
