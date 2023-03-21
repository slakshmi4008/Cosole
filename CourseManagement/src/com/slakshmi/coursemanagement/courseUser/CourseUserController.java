package com.slakshmi.coursemanagement.courseUser;

import java.util.List;

import com.slakshmi.coursemanagement.courseUser.CourseUserModel.CourseUserModelControlerCallBack;
import com.slakshmi.coursemanagement.courselogin.CourseLoginView;
import com.slakshmi.coursemanagement.dto.Course;
import com.slakshmi.coursemanagement.dto.Student;
import com.slakshmi.coursemanagement.dto.User;

public class CourseUserController implements CourseUserControllerCallBack, CourseUserModelControlerCallBack {

	private CourseUserViewCallBack courseView;
	private CourseUserModelCallBack courseModel;
	private User user;

	public CourseUserController(CourseUserViewCallBack courseView) {
		courseModel = new CourseUserModel(this);
		this.courseView = courseView;
	}

	public void processOption(int option, User user) {
		this.user = user;

		switch (option) {
		case 1: {
			List<Course> courseDetails = courseModel.getCourseDetails();
			courseView.print(courseDetails);
			courseView.courseIndex();
			break;
		}
		case 2: {
			List<Course> enrolled = courseModel.getEnrolmentDetails(user);
			if (enrolled.isEmpty()) {
				courseView.errorMessage("There is no enrollment in your acccount");
			} else {
				courseView.print(enrolled);
			}
			courseView.courseIndex();
			break;
		}
		case 3: {
			String courseId = courseView.getCourseID();
			if (courseId != null) {
				validateCourseId(courseId);

			} else {
				courseView.errorMessage("Please enter valid details");
			}
			courseView.courseIndex();
			break;

		}
		case 4: {
			CourseLoginView courseLoginUserView = new CourseLoginView();
			courseLoginUserView.loginIndex();
		}
		default: {
			courseView.errorMessage("Please enter valid option");
		}
		}

	}

	private void validateCourseId(String courseId) {
		boolean isCorrect = courseModel.validateCourseId(courseId);
		if (isCorrect) {
			updateStudentDetails(user, courseId);

			// Student student = courseView.getStudentDetails(courseId);
			// updateStudentDetails(student);
		} else {
			courseView.errorMessage("Invalid Course ID! Please enter valid Course ID");
		}

	}

	private void updateStudentDetails(User user, String courseId) {
		if (courseModel.updateStudentDetails(user, courseId)) {
			courseView.successMessage("You have been successfully enrolled");
		} else {
			courseView.errorMessage("Please enter valid details");
		}

	}

}
