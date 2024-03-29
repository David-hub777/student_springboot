package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Student;

class StudentTest {

	Student student;

	@Test
	void testGetApellidoWhenApellidoIsNotEmpty() {
		// when
		student = new Student(1, "juan", "apellaniz");

		// then
		assertEquals("apellaniz", student.getApellido());
	}

	@Test
	void testGetApellidoWhenApellidoIsEmpty() {
		// when
		student = new Student(1, "juan", null);

		// then
		assertEquals(null, student.getApellido());
	}

	@Test
	void testSetApellido() {
		fail("Not yet implemented");
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
