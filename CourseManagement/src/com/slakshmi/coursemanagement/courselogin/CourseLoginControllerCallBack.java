package com.slakshmi.coursemanagement.courselogin;

public interface CourseLoginControllerCallBack {

	void checkCredentials(String userName, String password, String loginType);

}
