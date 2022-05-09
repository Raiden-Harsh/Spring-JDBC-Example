package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.Dao.StudentDaoImpl;
import com.spring.jdbc.enteties.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("My Program started**********************");
		// Spring JDBC -> Jdbc Template
		
		/*WE ARE NOT USING THIS AS WE ARE NOT USING THE XML FILE	
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDaoImpl studentDao = context.getBean("studentDao", StudentDaoImpl.class);

		/*
		 * UPDATE OPERATION Student stu = new Student();
		 *  stu.setId(327);
		 * stu.setName("Raiden"); 
		 * stu.setCity("Chandhigarh"); 
		 * int result =
		 * studentDao.change(stu); 
		 * System.out.println("Studnet added #"+result);
		 */
		
		/* TO INSERT
		 * studentDao.insert(stu);
		 * 
		 */
		//TO DELETE
		/*
		 * int result = studentDao.delete(1);// this will remove Adam entry form the
		 * database System.out.println("Enteries Deleted #"+result);
		 */
		//TO SELECT SINGLE ROW
		/*
		 * Student student = studentDao.getStudent(666); 
		 * System.out.println(student);
		 */
		// TO SELECT MULTIPLE/ALL ROWS
		List<Student> allStudents = studentDao.catchThemAll();
		// To print this list we will be using for-each loop
		for(Student s:allStudents) {
			System.out.println(s);
			System.out.println("****************************************************");// just a spacer to look cool
		}
	}
	
	
	
}
