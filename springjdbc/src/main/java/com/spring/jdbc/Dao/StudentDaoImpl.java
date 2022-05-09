package com.spring.jdbc.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.enteties.Student;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		//Insert Query
		String insertQuery = "INSERT INTO student(Id,Name,City) VALUES(?,?,?)";
		int r = this.jdbcTemplate.update(insertQuery,student.getId(),student.getName(),student.getCity());
		return r;
	}
	public int change(Student student) {
		// Update Data
		String updateQuery = "UPDATE student SET Name=?, City=? WHERE Id=?";
		int r = this.jdbcTemplate.update(updateQuery,student.getName(),student.getCity(),student.getId());
		
		return r;
	}
	public int delete(int studentId) {
		//Delete Query
		String deleteQuery = "DELETE FROM student WHERE Id=?";
		int r = this.jdbcTemplate.update(deleteQuery,studentId);
		return r;
	}

	public Student getStudent(int studentId) {
		// Selecting single student data
		String selectQuery = "SELECT * FROM student WHERE Id=?";
		RowMapper<Student>  rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(selectQuery, rowMapper, studentId);
		
		return student;
	}
	public List<Student> catchThemAll() {
		// selecting multiple rows
		String selectAll = "SELECT * FROM student";
		List<Student> allStudents = this.jdbcTemplate.query(selectAll, new RowMapperImpl());
		return allStudents;
	}
	//getters and setters
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	//@Autowired can be used on the setter methods as well
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	

}
