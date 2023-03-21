package com.slakshmi.coursemanagement.courseadmin;

import java.util.List;

import com.slakshmi.coursemanagement.courseadmin.CourseAdminModel.CourseAdminModelControlerCallBack;
import com.slakshmi.coursemanagement.courselogin.CourseLoginView;
import com.slakshmi.coursemanagement.dto.Course;
import com.slakshmi.coursemanagement.dto.User;

public class CourseAdminController implements CourseAdminControllerCallBack, CourseAdminModelControlerCallBack {

	private CourseAdminViewCallBack courseAdminView;
	private CourseAdminModelCallBack courseAdminModel;
	private User user;

	public CourseAdminController(CourseAdminViewCallBack courseAdminView) {

		this.courseAdminView = courseAdminView;
		courseAdminModel = new CourseAdminModel(this);
	}

	public void processOption(int option, User user) {

		this.user = user;

		switch (option) {
		case 1: {
			List<Course> courseDetails = courseAdminModel.getCourseDetails();
			courseAdminView.print(courseDetails);
			courseAdminView.courseIndex();
			break;
		}
		case 2: {
			Course course = courseAdminView.addCourse();
			if (courseAdminModel.addCourse(course)) {
				courseAdminView.successMessage("Course has been successfully added");
				courseAdminView.courseIndex();
			} else {
				courseAdminView.errorMessage("Please try again! course has not been added.");
				courseAdminView.courseIndex();
			}
		}
		case 3: {
			CourseLoginView courseLoginUserView = new CourseLoginView();
			courseLoginUserView.loginIndex();
		}
		default: {
			System.out.println("Please enter valid option");
			courseAdminView.courseIndex();
		}
		}
	}
}
