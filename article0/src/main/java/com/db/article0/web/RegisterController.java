package com.db.article0.web;



import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.article0.dao.UserDao;
import com.db.article0.domain.User;
import com.db.article0.utils.Result;




@Controller
public class RegisterController {

	
   @Autowired
   private UserDao userDao;

   
   
   @GetMapping("register")
   public String save(){
	   return "register";
	   
   }
   
   @PostMapping("/register_auth")
   @ResponseBody
   public Map<String, Object> create(HttpSession httpSession ,@Valid UserForm userForm){
	   User newuser = new User();
/*	   newuser.setId(UUID.randomUUID().toString());*/
	   newuser.setAccount(userForm.getAccount());
	   newuser.setPassword(userForm.getPassword());
	   newuser.setUserid(UUID.randomUUID().toString());
	   newuser.setCtime(new Timestamp(System.currentTimeMillis()));
	   userDao.save(newuser);
	   return Result.toUrl("/login");
	   
   }
   

}
