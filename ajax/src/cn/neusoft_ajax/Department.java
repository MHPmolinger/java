package cn.neusoft_ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Department {

	private String id;
	private String name;
	private Date createTime;//创建时间
	private List<Employee> emps=new ArrayList<Employee>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
}
