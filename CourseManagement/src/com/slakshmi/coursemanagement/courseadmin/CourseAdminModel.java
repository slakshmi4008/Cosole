package com.slakshmi.coursemanagement.courseadmin;

import java.util.List;

import com.slakshmi.coursemanagement.courselogin.CourseLoginController;
import com.slakshmi.coursemanagement.dto.Course;
import com.slakshmi.coursemanagement.repository.CourseRepository;

public class CourseAdminModel implements CourseAdminModelCallBack {

	private CourseAdminModelControlerCallBack courseLoginUserController;

	public CourseAdminModel(CourseAdminModelControlerCallBack courseLoginAdminController) {

		this.courseLoginUserController = courseLoginUserController;
	}

	public List<Course> getCourseDetails() {
		List<Course> courseDetails = CourseRepository.getInstance().getCourseDetails();
		return courseDetails;
	}

	public boolean addCourse(Course course) {

		return CourseRepository.getInstance().addCourse(course);
	}

	public interface CourseAdminModelControlerCallBack {

	}
}
