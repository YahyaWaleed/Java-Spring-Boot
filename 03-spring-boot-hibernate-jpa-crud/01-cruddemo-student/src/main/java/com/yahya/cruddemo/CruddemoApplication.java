package com.yahya.cruddemo;

import com.yahya.cruddemo.dao.StudentDAO;
import com.yahya.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//creatStudent(studentDAO);
			//createManyStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int stuId = 4;

		studentDAO.delete(stuId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentID = 1;
		Student myStudent = studentDAO.findByID(studentID);

		// update first name
		myStudent.setFirstName("Abdullah");

		// update in the database
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findByLastName("Bika");

		//display list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create student
		Student tempStudent4 = new Student("Hamo", "Bika", "7amobika@gmail.com");

		// save student
		System.out.println("saving student in the db....");
		studentDAO.save(tempStudent4);

		// display id of the saved student
		System.out.println("Generated ID of the saved student: " + tempStudent4.getId());

		// read student record based on his ID (pk)
		studentDAO.findByID(tempStudent4.getId());

		// display student
		System.out.println("Student Found: " + studentDAO.findByID(tempStudent4.getId()));
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
