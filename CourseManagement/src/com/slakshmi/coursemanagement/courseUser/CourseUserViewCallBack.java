package com.slakshmi.coursemanagement.courseUser;

import java.util.List;

import com.slakshmi.coursemanagement.dto.Course;

public interface CourseUserViewCallBack {

	void courseIndex();

	void print(List<Course> courseDetails);

	void errorMessage(String string);

	String getCourseID();

	void successMessage(String string);

}
