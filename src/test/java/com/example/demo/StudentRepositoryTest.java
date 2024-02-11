package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	JdbcTemplate template;

	StudentRepository repo;

    @Test
    void test() {
        //test 1
        Student student = new Student(55, "Fernando", "Del Pino");
        assertDoesNotThrow( () -> repo.insert(student));

        
        //test 2
        Student student2 = new Student(55, "Fernando", "Del PinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinoooooooooooooooooooooooooooooooooooooooooPinooooooooooooooooooooooooooooooooooooooooo");
        assertThrows( DataIntegrityViolationException.class , 
                () -> {
                    repo.insert(student2);
                    repo.insert(student);
                }, "Duplicate student: entry duplicate primary key failed");
        
        //test 3
        try{//Que pasa si inserto student 1 2 veces
            repo.insert(student);
            repo.insert(student);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    // public void animmous(Student student){ repo.insert(student); }

    // @Test
    // void testDelete() {
    //     // Create a new student
    //     Student student = new Student(1, "John", "Doe");
        
    //     // Insert the student into the repository
    //     repo.insert(student);
        
    //     // Delete the student from the repository
    //     repo.delete(student.getId());
        
    //     // Try to find the deleted student by ID
    //     Student deletedStudent = repo.findById(student.getId());
        
    //     // Assert that the deleted student is null
    //     assertNull(deletedStudent);
    // }

    @Test
    void testFindAll(){
        List<Student> lista = new ArrayList<Student>();
        assertTrue(lista.isEmpty());
        lista = repo.findAll();

        repo.insert(new Student(57,"Alberto","Saz"));

        lista = repo.findAll();

        assertTrue(lista.size() != 0);
    }






    
    

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    
    }

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
        repo = new StudentRepository();
        assertNotNull(template);
		repo.setJdbcTemplate(template);
	}

	@AfterEach
	void tearDown() throws Exception {
	}


}
