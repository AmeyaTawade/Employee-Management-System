package com.ty.empManagementSystem.model;

public class DepartmentModel {

	private long id;
	private String name;
	private String  deptDescription;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptDescription() {
		return deptDescription;
	}
	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}
	
}
