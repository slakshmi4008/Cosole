package com.slakshmi.coursemanagement.courselogin;

import com.slakshmi.coursemanagement.dto.User;
import com.slakshmi.coursemanagement.dto.UserCredentials;
import com.slakshmi.coursemanagement.repository.CourseRepository;

public class CourseLoginModel implements CourseLoginModelCallBack {
	private CourseLoginModelControlerCallBack courseLoginUserController;

	public CourseLoginModel(CourseLoginModelControlerCallBack courseLoginUserController) {
		super();
		this.courseLoginUserController = courseLoginUserController;
	}

	public void checkCredentials(String userName, String password, String loginType) {

		User user = CourseRepository.getInstance().checkValidUser(userName, password, loginType);
		if (user != null) {

			courseLoginUserController.loginSuccess(user);

		} else {
			courseLoginUserController.loginFailiure("\nInvalid Credentials. Please try again!\n");
		}

	}

	public interface CourseLoginModelControlerCallBack {

		void loginSuccess(User user);

		void loginFailiure(String string);

	}

}
