package com.slakshmi.coursemanagement.courseUser;

import java.util.List;

import com.slakshmi.coursemanagement.dto.Course;
import com.slakshmi.coursemanagement.dto.User;

public interface CourseUserModelCallBack {

	List<Course> getCourseDetails();

	List<Course> getEnrolmentDetails(User user);

	boolean validateCourseId(String courseId);

	boolean updateStudentDetails(User user, String courseId);

}
