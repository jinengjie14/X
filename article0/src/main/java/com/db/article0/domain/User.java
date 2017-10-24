package com.db.article0.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.db.article0.utils.PasswordUtil;

@Entity
@Table(name = "user")

public class User /*implements Serializable*/ {

/*	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 2364085883994527299L;
*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(nullable = false)
	@NotEmpty(message = "账号不能为空")
	@Size(min = 3, max = 30, message = "账号长度错误")
	@Pattern(regexp = "[a-zA-Z0-9_@]{3,30}.[a-zA-Z0-9]{1,}", message = "账号格式错误")
	private String account;
	private String email;
	private String mobile;
	@NotEmpty(message = "密码不能为空")
	private String password;
	@NotNull
	  @Column(name = "userid", unique = true, nullable = false, length = 32) //唯一，不允许为空，最大32位
	  private String userid;
	private Timestamp ctime;
	private String verifycode;

	public User() {	
	}

	public User(String account, String password) {
		this.account = account;
		this.password = password;
	}

	public void init() {
		this.setUserid(UUID.randomUUID().toString().replaceAll("-", ""));
		this.setPassword(PasswordUtil.createPassword(password));

	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
