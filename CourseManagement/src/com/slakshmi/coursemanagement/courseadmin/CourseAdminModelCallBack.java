package com.slakshmi.coursemanagement.courseadmin;

import java.util.List;

import com.slakshmi.coursemanagement.dto.Course;

public interface CourseAdminModelCallBack {

	List<Course> getCourseDetails();

	boolean addCourse(Course course);

}
