package com.spring.jdbc.Dao;

import java.util.List;

import com.spring.jdbc.enteties.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> catchThemAll();
}
