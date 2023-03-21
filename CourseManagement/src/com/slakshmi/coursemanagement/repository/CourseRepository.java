package com.slakshmi.coursemanagement.repository;

import java.util.ArrayList;
import java.util.List;
import com.slakshmi.coursemanagement.dto.Course;
import com.slakshmi.coursemanagement.dto.Student;
import com.slakshmi.coursemanagement.dto.User;
import com.slakshmi.coursemanagement.dto.UserCredentials;

public class CourseRepository {

	private static CourseRepository courseDbRepository;

	private List<UserCredentials> user = new ArrayList<>();
	private List<Course> courseDetails = new ArrayList<>();
	private List<Student> studentDetails = new ArrayList<>();

	private CourseRepository() {

	}

	public static CourseRepository getInstance() {
		if (courseDbRepository == null) {
			courseDbRepository = new CourseRepository();
			courseDbRepository.initialSetup();
		}
		return courseDbRepository;
	}

	private void initialSetup() {
		user.add(new UserCredentials("0001", "admin", "admin", "ZSGS"));
		user.add(new UserCredentials("0002", "lakshmi", "user", "1234"));
		courseDetails.add(new Course("C001", "JAVA", "3 months", 3000f, "01/03/2023", "31/05/2023"));
		courseDetails.add(new Course("C002", "HTML-CSS", "2 months", 1500f, "01/03/2023", "30/04/2023"));
		studentDetails.add(new Student("S001", "lakshmi", "Lakshmi Priya", "2001-08-30", "9922558899", "C001"));

	}

	public List<Course> getCourseDetails(String courseID, List<Course> enrolled) {

		for (Course course : courseDetails) {
			if (course.getCourseID().equals(courseID)) {
				enrolled.add(course);
			}
		}
		return enrolled;

	}

	public List<Course> getCourseDetails() {
		return courseDetails;

	}

	public UserCredentials checkValidUser(String userName, String password, String loginType) {

		for (UserCredentials userCredentials : user) {
			if (userCredentials.getUserName().equals(userName) && userCredentials.getPassword().equals(password)
					&& userCredentials.getUserType().equals(loginType)) {

				return userCredentials;
			}
		}
		return null;
	}

	public List<Course> getEnrolmentDetails(User user) {
		String courseID = "";
		List<Course> enrolled = new ArrayList<>();
		for (Student student : studentDetails) {
			if (student.getUserName().equals(user.getUserName())) {
				courseID = student.getCourseID();
				enrolled = getCourseDetails(student.getCourseID(), enrolled);
			}
		}
		return enrolled;
	}

	public boolean validateCourseId(String courseId) {
		for (Course course : courseDetails) {
			if (course.getCourseID().equals(courseId)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * public boolean updateStudentDetails(Student student) { studentDetails.add(new
	 * Student ("S002",student.getUserName(),student.getName(),student.getDOB(),
	 * student.getMobileNum(),student.getCourseID())); System.out.println("update" +
	 * studentDetails.size()); return true; }
	 */
	public boolean updateStudentDetails(User user, String courseId) {
		for (Student student : studentDetails) {
			if (student.getUserName().equals(user.getUserName())) {
				studentDetails.add(new Student("S002", student.getUserName(), student.getName(), student.getDOB(),
						student.getMobileNum(), courseId));
				return true;
			}
		}
		return false;
	}

	public boolean addCourse(Course course) {
		return courseDetails.add(new Course(course.getCourseID(), course.getCourseName(), course.getDuration(),
				course.getFee(), course.getStartDate(), course.getEndDate()));

	}

}
