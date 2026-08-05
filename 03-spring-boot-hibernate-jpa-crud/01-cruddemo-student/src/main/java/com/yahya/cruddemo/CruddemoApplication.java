package com.yahya.cruddemo;

import com.yahya.cruddemo.dao.StudentDAO;
import com.yahya.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//creatStudent(studentDAO);
			createManyStudents(studentDAO);
		};
	}

	private void createManyStudents(StudentDAO studentDAO) {
		// create 3 students
		System.out.println("Creating 3 new students....");
		Student tempStudent1 = new Student("Ahmed","Waleed","ahmedwaleed@gmail.com");
		Student tempStudent2 = new Student("Essam","Abdo","essamabdo@gmail.com");
		Student tempStudent3 = new Student("Amr","Amir","amramir@gmail.com");


		// save 3 students in the database
		System.out.println("Saving the new 3 students in the database....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void creatStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating a new student....");
		Student tempStudent = new Student("Yahya","Waleed","yahyawaleed@gmail.com");

		// save the student in the database
		System.out.println("Saving the new student in the database....");
		studentDAO.save(tempStudent);

		// display the ID of the new saved  student
		System.out.println("Student Saved. Generated ID: " + tempStudent.getId());
	}
}
