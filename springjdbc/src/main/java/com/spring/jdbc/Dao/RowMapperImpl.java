package com.spring.jdbc.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.spring.jdbc.enteties.Student;

public class RowMapperImpl implements org.springframework.jdbc.core.RowMapper<Student>{
	
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		// this is how we map RESULT SET to AN OBJECT
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setCity(rs.getString(3));
		
		
		return student;
	}

	
}
