package com.db.article0.web;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;



public class UserForm {

	@NotBlank(message = "账号不能为空")
	@Pattern(regexp = "[a-zA-Z0-9_@]{3,30}.[a-zA-Z0-9]{1,}", message = "账号格式错误")
	private String account;
	@NotBlank(message = "密码不能为空")
	@Size(min = 6, max = 16, message = "密码长度错误")
	private String password;

	private String userid;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


}
