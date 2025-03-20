package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Loginuser;
import com.jbk.entity.Registeruser;

@Repository
public class Registeruserdao {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public byte registeruser(Registeruser user) {
		Session session=sessionfactory.openSession();
		try {
			Query query=session.createQuery("FROM Registeruser Where email=:name");
			query.setParameter("name", user.getEmail());
			Registeruser user1=(Registeruser)query.uniqueResult();
			if(user1==null) {
				session.save(user);
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
	
	public byte loginuser(Loginuser user) {
		Session session=sessionfactory.openSession();
		try {
			Query query=session.createQuery("FROM Registeruser Where username=:name");
			query.setParameter("name", user.getUsername());
			Registeruser newuser=(Registeruser)query.uniqueResult();
		
			if(newuser!=null && newuser.getPassword().equals(user.getPassword())) {
				System.out.println("hello");
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

}
