package com.yahya.cruddemo;

import com.yahya.cruddemo.dao.AppDao;
import com.yahya.cruddemo.entity.Course;
import com.yahya.cruddemo.entity.Instructor;
import com.yahya.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
//			createInstructor(appDao);
//			findInstructor(appDao);
//			deleteInstructor(appDao);
//			findInstructorDetail(appDao);
//			deleteInstructorDetail(appDao);
			createInstructorWithCourses(appDao);
		};
	}

	private void createInstructorWithCourses(AppDao appDao) {
		Instructor tempInstructor = new Instructor("Ahmed","Waleed","ahmed@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("ahmedCodes", "sleeping");

		// associate the two objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save new instructor
		System.out.println("saving new instructor: " + tempInstructor);
		//appDao.save(tempInstructor); // will also save tempInstructorDetail because of cascade
		System.out.println("done");

		//create courses
		Course course1 = new Course("swimming 101");
		Course course2 = new Course("programming 101");
		Course course3 = new Course("skating 101");

		//add courses to instructor
		tempInstructor.add(course1);
		tempInstructor.add(course2);
		tempInstructor.add(course3);

		// save courses
		System.out.println("saving instructor: " + tempInstructor);
		System.out.println("courses: " + tempInstructor.getCourses());
		appDao.save(tempInstructor); // will save courses as well becasue of cascade.persist
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor detail with id - " + id);
		appDao.deleteInstructorDetailById(id);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDao appDao) {
		int id =1;
		InstructorDetail tempInstructorDetail = appDao.findInstructorDetailById(id);
		System.out.println(tempInstructorDetail);
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("deleting instructor with id -" + id);
		appDao.deleteInstructorById(id);
		System.out.println("Done");
	}

	private void findInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("finding instrucor with id: " +id);
		Instructor dbInstructor = appDao.findInstructorById(id);
		System.out.println("Instructor with ID " + id+ " :"+ dbInstructor);
		System.out.println("instructor details: " +dbInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {
		Instructor tempInstructor = new Instructor("Yahya","Waleed","yahya@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("springCodes", "sleeping");

		// associate the two objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save new instructor
		System.out.println("saving new instructor: " + tempInstructor);
		appDao.save(tempInstructor); // will also save tempInstructorDetail because of cascade
		System.out.println("done");
	}


}
