package com.jfsd_lab.exp1;

//package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

    private static SessionFactory factory;

    public static void main(String[] args) {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
 
//        insertDept("erdrtr", "sdfsdf", "dfss.com");
//        insertDept("inknkn", "knnnm", "jkjnk,m.com");
        deldept(1);

    }
public static void insertDept(String name,String Location,String HodName) {
	Session session = factory.openSession();
    Transaction transaction = null;
    try {
    	transaction = session.beginTransaction();
    	Department dept = new Department();
    	dept.setName(name);
    	dept.setLocation(Location);
    	dept.setHodName(HodName);
    	 
//    	System.out.println("Inserted One entry");
    	session.save(dept);
    	transaction.commit();
    	System.out.println("Inserted One entry");
    }catch (Exception e) {
        if (transaction != null) transaction.rollback();
        e.printStackTrace();
}
    finally {
    	session.close();
    }}
public static void deldept(int id) {
    Session session = factory.openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        Department dept = session.get(Department.class, id); // Get department by ID
        if (dept != null) {
            session.delete(dept); // Delete the department
            transaction.commit();
            System.out.println("Record Deleted in DB");
        } else {
            System.out.println("Does not exist");
        }
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
}
     
     
}
