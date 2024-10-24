package com.ty.empManagementSystem.service;

import java.util.List;

import com.ty.empManagementSystem.dto.EmployeeDto;
import com.ty.empManagementSystem.model.EmployeeModel;

public interface EmployeeService {

	void addEmployee(EmployeeDto emp);
	void changeEmail(long id, String email);
	EmployeeModel fetchEmployeeById(long id);
	List<EmployeeModel> fetchAllEmployee();
	void deleteEmployee(long id);
	List<EmployeeModel> fetchPage(int page, int size);
	List<EmployeeModel> sortEmployees();
	void setDepartmentId(long empId,long deptId);
}
