package cn.neusoft.usermanager.domain;

import java.util.Date;

public class User {

	private String name;
	private String gender;
	private Date birthday;
	private String loves;
	private String xueli;
	private String resume;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getLoves() {
		return loves;
	}
	public void setLoves(String loves) {
		this.loves = loves;
	}
	public String getXueli() {
		return xueli;
	}
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", birthday="
				+ birthday + ", loves=" + loves + ", xueli=" + xueli
				+ ", resume=" + resume + "]";
	}
	
	
}
