package com.ty.empManagementSystem.service;

import java.util.List;

public interface EmployeeProjectService {

	void assignEmployeesToProject(long projectId, List<Long> employeeIds);
	void assignProjectsToEmployee(long employeeId, List<Long> projectIds);
}
