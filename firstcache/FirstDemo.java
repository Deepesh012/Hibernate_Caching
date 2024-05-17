package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsp.ProjectWithMaven.Student;

//First Level Caching

public class FirstDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		//by default enabled
		Student student = session.get(Student.class, 1);
		System.out.println(student);
		
		//suppose we do something then again we fetch the same data then it doesn't fire query again to get the same result
		System.out.println("working something");
		Student student2 = session.get(Student.class, 1);
		System.out.println(student2);
		
		
		//contains is a session method which checks it contains object or not
		System.out.println(session.contains(student2));
		
		session.close();
		factory.close();
	}
	
}
