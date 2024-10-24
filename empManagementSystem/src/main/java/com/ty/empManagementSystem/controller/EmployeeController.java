package com.ty.empManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.empManagementSystem.dto.EmployeeDto;
import com.ty.empManagementSystem.model.EmployeeModel;
import com.ty.empManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addemployee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto emp) {
		try {
			employeeService.addEmployee(emp);
			return ResponseEntity.ok("Account has been created");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/changeemail")
	public ResponseEntity<String> changeEmail(@RequestParam long id, @RequestParam String email) {
		try {
			employeeService.changeEmail(id, email);
			return ResponseEntity.ok("Your email has been updated");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/fetchemployeebyid")
	public EmployeeModel fetchEmployeeById(@RequestParam long id) {
		try {
			return employeeService.fetchEmployeeById(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/fetchall")
	public List<EmployeeModel> fetchAllEmployee() {
		try {
			return employeeService.fetchAllEmployee();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteEmployee(@RequestParam long id) {
		try {
			employeeService.deleteEmployee(id);
			return ResponseEntity.ok("Your account has been deleted");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/pagination")
	public List<EmployeeModel> fetchPage(@RequestParam int page, @RequestParam int size) {
		try {
			return employeeService.fetchPage(page, size);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("/sort")
	public List<EmployeeModel> sortEmployee() {
		try {
			return employeeService.sortEmployees();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/setdept")
	public ResponseEntity<String> setDepartmentId(@RequestParam long empId,@RequestParam long deptId) {
		try {
			employeeService.setDepartmentId(empId, deptId);
			return ResponseEntity.ok("department id updated");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
