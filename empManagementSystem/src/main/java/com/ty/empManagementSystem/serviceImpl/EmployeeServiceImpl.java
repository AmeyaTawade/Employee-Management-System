package com.ty.empManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.empManagementSystem.dto.EmployeeDto;
import com.ty.empManagementSystem.model.EmployeeModel;
import com.ty.empManagementSystem.repository.EmployeeRepository;
import com.ty.empManagementSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(EmployeeDto emp) {
		employeeRepository.addEmployee(emp);
	}

	@Override
	public void changeEmail(long id, String email) {
		employeeRepository.changeEmail(id, email);
	}

	@Override
	public EmployeeModel fetchEmployeeById(long id) {
		return employeeRepository.fetchEmployeeById(id);
	}

	@Override
	public List<EmployeeModel> fetchAllEmployee() {
		return employeeRepository.fetchAllEmployee();
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteEmployee(id);
	}

	@Override
	public List<EmployeeModel> fetchPage(int page, int size) {
		return employeeRepository .fetchPage(page, size);
	}

	@Override
	public List<EmployeeModel> sortEmployees() {
		return employeeRepository.sortEmplpoyee();
	}

	@Override
	public void setDepartmentId(long empId, long deptId) {
		employeeRepository.setDepartmentId(empId, deptId);
	}

}
