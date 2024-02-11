package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.internal.configuration.MockAnnotationProcessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.StudentController;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

// @ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest2 {

	@Autowired
	StudentController controller;

	@Autowired
	MockMvc mockmvc;
	@Mock
	private StudentService service;


	@Test
	void testInsertarEstudianteForm() {
		// RequestBuilder requestBuilder;
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/insertStudent");
		requestBuilder.queryParam("nombre", "Fernando")
				.queryParam("apellido", "Del Pino");
		try {
			MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
			ModelAndView modelAndView = mvcResult.getModelAndView();
			assertEquals("fin", modelAndView.getViewName());
			assertNotNull(modelAndView.getModel().get("estudiantes"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("NO debería producirse la exception");
		}
			
		// given
		Model model = new ExtendedModelMap();
		when(service.insertStudent(new Student())).thenReturn(createMockedList());
		// when
		String finPage = controller.insertarEstudiante(new Student(), model);
		// then
		assertEquals("fin", finPage);

		assertNotNull(model.getAttribute("estudiantes"));
		assertInstanceOf(List.class, model.getAttribute("estudiantes"));

		List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
		assertFalse(lista.isEmpty());

	}
	@Test
	void testInsertarEstudiante() {
		// given
		Model model = new ExtendedModelMap();
		when(service.insertStudent(new Student())).thenReturn(createMockedList());
		// when
		String finPage = controller.insertarEstudiante(new Student(), model);
		// then
		assertEquals("fin", finPage);

		assertNotNull(model.getAttribute("estudiantes"));
		assertInstanceOf(List.class, model.getAttribute("estudiantes"));

		List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
		assertFalse(lista.isEmpty());

	}

	private List<Student> createMockedList() {
		List<Student> listaPrecreada = new ArrayList<Student>();
		listaPrecreada.add(new Student(1, "ignacio", "bielsa"));
		listaPrecreada.add(new Student(2, "alejandro", "tesan"));
		return listaPrecreada;
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		controller = new StudentController();
		controller.setService(service);

	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testActualizarEstudiante() {
		// given
		Model model = new ExtendedModelMap();
		int studentId = 1;
		Student existingStudent = new Student(studentId, "NombreActual", "ApellidoActual");
        Student updatedStudent = new Student(studentId, "NuevoNombre", "NuevoApellido");
		when(service.searchStudentById(studentId)).thenReturn(existingStudent);
        when(service.updateStudentList(studentId)).thenReturn(updatedStudent);

		// when
		String finPage = controller.actualizarEstudiante(studentId, model);
		// then
		assertEquals("fin", finPage);

		assertNotNull(model.getAttribute("estudiantes"));
		assertInstanceOf(List.class, model.getAttribute("estudiantes"));

		List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
		assertFalse(lista.isEmpty());
	}

	@Test
	void testBorrarEstudiante() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarEstudiantes() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

}
