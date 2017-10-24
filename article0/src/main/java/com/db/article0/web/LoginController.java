package com.db.article0.web;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.article0.dao.UserDao;
import com.db.article0.domain.User;



@Controller
public class LoginController{
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String addSession(ResponseUser user, HttpSession httpSession) {
		System.out.println(user.getId());
		System.out.println(user.getAccount());
		httpSession.setAttribute("user", user);
		return "/index";
	}
	
	
 }


	
	
	/*	@PostMapping("/auth")
	@ResponseBody
	public String auth(HttpSession httpSession, @Valid UserForm userForm) {
		User user = userDao.findByAccount(userForm.getAccount());
		if (null != user) {
			if (StringUtils.equals(user.getPassword(), userForm.getPassword())) {
				httpSession.setAttribute("sessuser", user);

			
	}
	
		}
		return "redirect:index";
	}
}*/

