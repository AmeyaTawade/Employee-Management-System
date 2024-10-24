package com.ty.empManagementSystem.repository;

import java.util.List;

public interface EmployeeProjectRepository {
	
	void assignEmployeesToProject(long projectId, List<Long> employeeIds);
	void assignProjectsToEmployee(long employeeId, List<Long> projectIds);
}
