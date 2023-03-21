package com.slakshmi.coursemanagement.courseUser;

import java.util.List;

import com.slakshmi.coursemanagement.dto.Course;
import com.slakshmi.coursemanagement.dto.Student;
import com.slakshmi.coursemanagement.dto.User;
import com.slakshmi.coursemanagement.repository.CourseRepository;

public class CourseUserModel implements CourseUserModelCallBack {

	private CourseUserModelControlerCallBack courseController;

	public CourseUserModel(CourseUserModelControlerCallBack courseController) {
		this.courseController = courseController;
	}

	public List<Course> getCourseDetails() {

		List<Course> courseDetails = CourseRepository.getInstance().getCourseDetails();
		return courseDetails;
	}

	public List<Course> getEnrolmentDetails(User user) {
		List<Course> enrolled = CourseRepository.getInstance().getEnrolmentDetails(user);
		// System.out.println("model" + enrolled.get(0).getCourseID());
		return enrolled;
	}

	public boolean validateCourseId(String courseId) {

		return CourseRepository.getInstance().validateCourseId(courseId);
	}

	public boolean updateStudentDetails(User user,String courseId) {
		// TODO Auto-generated method stub
		return CourseRepository.getInstance().updateStudentDetails(user,courseId);
	}

	public interface CourseUserModelControlerCallBack {

	}

}
