package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {
//Sirve para unir el campo de la insercion con el de la database
	@Override // lo que hace esto es mapear la estructura de la tabla para que luego podamos
				// trabajar con ella
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setNombre(rs.getString("nombre"));
		student.setApellido(rs.getString("apellido"));
		return student;
	}


}
