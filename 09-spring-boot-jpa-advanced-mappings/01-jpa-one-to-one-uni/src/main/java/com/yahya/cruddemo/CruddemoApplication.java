package com.yahya.cruddemo;

import com.yahya.cruddemo.dao.AppDao;
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
			deleteInstructor(appDao);
		};
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("deleting instructor with id -" + id);
		appDao.deleteInstructorById(id);
		System.out.println("Done");
	}

//	private void findInstructor(AppDao appDao) {
//		int id = 1;
//		System.out.println("finding instrucor with id: " +id);
//		Instructor dbInstructor = appDao.findInstructorById(id);
//		System.out.println("Instructor with ID " + id+ " :"+ dbInstructor);
//		System.out.println("instructor details: " +dbInstructor.getInstructorDetail());
//	}

//	private void createInstructor(AppDao appDao) {
//		Instructor tempInstructor = new Instructor("Yahya","Waleed","yahya@gmail.com");
//		InstructorDetail tempInstructorDetail = new InstructorDetail("springCodes", "sleeping");
//
//		// associate the two objects
//		tempInstructor.setInstructorDetail(tempInstructorDetail);
//
//		// save new instructor
//		System.out.println("saving new instructor: " + tempInstructor);
//		appDao.save(tempInstructor); // will also save tempInstructorDetail because of cascade
//		System.out.println("done");
//	}


}
