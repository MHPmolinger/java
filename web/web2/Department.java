package cn.neusoft.usermanager.domain;

import java.util.Date;

public class Department {

	private int deptId;
	private String name;
	private Date createTime;
	private String desc;
	private Boolean isNew;//是一个新的部门吗
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name
				+ ", createTime=" + createTime + ", desc=" + desc + ", isNew="
				+ isNew + "]";
	}
	
}
