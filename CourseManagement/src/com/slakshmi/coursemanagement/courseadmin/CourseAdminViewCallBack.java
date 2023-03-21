package com.slakshmi.coursemanagement.courseadmin;

import java.util.List;

import com.slakshmi.coursemanagement.dto.Course;

public interface CourseAdminViewCallBack {

	void courseIndex();

	void print(List<Course> courseDetails);

	Course addCourse();

	void successMessage(String string);

	void errorMessage(String string);

}
