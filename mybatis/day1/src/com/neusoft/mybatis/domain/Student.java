package com.neusoft.mybatis.domain;

import java.util.Date;

public class Student {

	private String stuId;
	private String name;
	private Date birthday;
	private String mobile;
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", name=" + name + ", birthday="
				+ birthday + ", mobile=" + mobile + "]";
	}
	
}
