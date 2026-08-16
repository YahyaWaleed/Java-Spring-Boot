package com.yahya.cruddemo;

import com.yahya.cruddemo.dao.AppDao;
import com.yahya.cruddemo.entity.*;
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
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
//			createCourseAndStudents(appDao);
//			findCourseAndStudents(appDao);
//			findStudentAndCourses(appDao);
//			addMoreCoursesForStudent(appDao);
//			deleteCourse(appDao);
			deleteStudent(appDao);
		};
	}

	private void deleteStudent(AppDao appDao) {
		int id = 2;
		appDao.deleteStudentById(id);
		System.out.println("student deleted");
	}

	private void addMoreCoursesForStudent(AppDao appDao) {
		int studentId = 2;
		Student student = appDao.findStudentAndCoursesByStudentId(studentId);

		Course course1 = new Course("fencing");
		Course course2 = new Course("shooting");

		student.addCourse(course1);
		student.addCourse(course2);

		appDao.update(student);
	}

	private void findStudentAndCourses(AppDao appDao) {
		int id = 2;
		Student student = appDao.findStudentAndCoursesByStudentId(id);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudents(AppDao appDao) {
		int courseId = 10;
		Course course = appDao.findCourseAndStudentsByCourseId(courseId);
		System.out.println(course);
		System.out.println(course.getStudents());
		System.out.println("Done");
	}

	private void createCourseAndStudents(AppDao appDao) {
		Course newCourse = new Course("olympic lifting 101");
		Student student1 = new Student("Yahya","Waleed", "yahya@gmail.com");
		Student student2 = new Student("Ahmed","omar", "ahmed@gmail.com");
		Student student3 = new Student("Mohamed","loay", "mohamed@gmail.com");

		newCourse.addStudent(student1);
		newCourse.addStudent(student2);
		newCourse.addStudent(student3);

		appDao.save(newCourse);

		System.out.println("Done");
	}

	private void deleteCourseAndReviews(AppDao appDao) {
		int courseId = 11;
		appDao.deleteCourseById(courseId);
		System.out.println("Done");
	}

	private void retrieveCourseAndReviews(AppDao appDao) {
		int courseId = 11;
		Course tempCourse = appDao.findCourseAndReviewByCourseId(courseId);
		System.out.println("course --> " + tempCourse);
		System.out.println("reviews -- > " + tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDao appDao) {
		Course tempCourse = new Course("Horse riding");
		tempCourse.addReview(new Review("good"));
		tempCourse.addReview(new Review("easy to follow"));
		appDao.save(tempCourse);
		System.out.println("Done");
	}

	private void deleteCourse(AppDao appDao) {
		int id = 10;
		Course courseToDelete = appDao.findCourseById(id);
		appDao.deleteCourseById(id);
		System.out.println("Course Deleted!");
	}

	private void updatingCourse(AppDao appDao) {
		int id = 12;

		// find course with id 2
		Course tempCourse = appDao.findCourseById(id);

		// change the course
		tempCourse.setTitle("driving manual");

		// update the course
		appDao.updateCourse(tempCourse);

		System.out.println("Done!");
	}

	private void updatingInstructor(AppDao appDao) {
		int id = 1;

		// find insturctor with id 1
		Instructor tempInstructor = appDao.findInstructorById(id);

		// change instructor
		tempInstructor.setLastName("tester");
		System.out.println("done");

		// update instructor
		appDao.updateInstructor(tempInstructor);
	}

	private void findCoursesForInstructor(AppDao appDao) {
		int id = 2;
		System.out.println("finding instructor with id: " + id);
		Instructor tempInsructor = appDao.findInstructorById(id);
		System.out.println("tempInstructor: " + tempInsructor);

		System.out.println("finding courses for instructor with id : " + id);
		List<Course> courseList = appDao.findCoursesById(id);

		// associate objects
		tempInsructor.setCourses(courseList);
		System.out.println("associated courses: " + tempInsructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int id = 1;
		System.out.println("finding instructor with id: " + id);
		Instructor tempInsructor = appDao.findInstructorById(id);
		System.out.println("tempInstructor: " + tempInsructor);
		System.out.println("associated courses: " + tempInsructor.getCourses());
		System.out.println("Done");
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
