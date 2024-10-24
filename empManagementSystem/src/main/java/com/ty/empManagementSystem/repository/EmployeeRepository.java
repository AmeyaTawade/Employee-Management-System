package com.ty.empManagementSystem.repository;

import java.util.List;

import com.ty.empManagementSystem.dto.EmployeeDto;
import com.ty.empManagementSystem.model.EmployeeModel;

public interface EmployeeRepository {

	void addEmployee(EmployeeDto emp);
	void changeEmail(long id, String email);
	EmployeeModel fetchEmployeeById(long id);
	List<EmployeeModel> fetchAllEmployee();
	void deleteEmployee(long id);
	List<EmployeeModel> fetchByDepartmentId(long id);
	List<EmployeeModel> fetchPage(int page, int size);
	List<EmployeeModel> sortEmplpoyee();
	void setDepartmentId(long empId, long deptId);
}
