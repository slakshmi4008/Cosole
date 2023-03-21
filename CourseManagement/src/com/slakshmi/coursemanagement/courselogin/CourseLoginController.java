package com.slakshmi.coursemanagement.courselogin;

import com.slakshmi.coursemanagement.courseUser.CourseUserView;
import com.slakshmi.coursemanagement.courseadmin.CourseAdminView;
import com.slakshmi.coursemanagement.courselogin.CourseLoginModel.CourseLoginModelControlerCallBack;
import com.slakshmi.coursemanagement.dto.User;

public class CourseLoginController implements CourseLoginControllerCallBack, CourseLoginModelControlerCallBack {

	private CourseLoginViewCallBack courseLoginUserView;
	private CourseLoginModelCallBack courseLoginUserModel;

	public CourseLoginController(CourseLoginViewCallBack courseLoginUserView) {
		this.courseLoginUserView = courseLoginUserView;
		courseLoginUserModel = new CourseLoginModel(this);
	}

	public void checkCredentials(String userName, String password, String loginType) {

		courseLoginUserModel.checkCredentials(userName, password, loginType);

	}

	public void loginSuccess(User user) {

		if (user.getUserType().equals("user")) {

			CourseUserView courseView = new CourseUserView(user);

			courseView.start();

		} else if (user.getUserType() == "admin") {

			CourseAdminView courseAdminView = new CourseAdminView(user);
			courseAdminView.start();

		} else if (user.getUserType() == "trainer") {
			// to be developed
		}

	}

	public void loginFailiure(String string) {
		CourseLoginView.errorMessage("Invalid credentials.Please check your username and password.");
		courseLoginUserView.loginIndex();

	}

}
