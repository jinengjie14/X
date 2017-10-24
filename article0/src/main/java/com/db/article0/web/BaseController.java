package com.db.article0.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {
	protected String sessionUserId = "";
	protected ResponseUser sessionUser;
	
	@ModelAttribute
	public void getSession(HttpSession httpSession) {
		sessionUser = (ResponseUser) httpSession.getAttribute("user");
		if(null != sessionUser) {
			sessionUserId = sessionUser.getId();
		}
	}

}
