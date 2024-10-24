package com.ty.empManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.empManagementSystem.service.EmployeeProjectService;

@RestController
@RequestMapping("/api/employeeproject")
public class EmployeeProjectController {

	@Autowired
	private EmployeeProjectService employeeProjectService;
	
	@PostMapping("/assignemployee/{projectId}")
	public ResponseEntity<String> assignEmployeesToProject(@PathVariable long projectId,@RequestBody List<Long> employeeIds) {
		try {
			employeeProjectService.assignEmployeesToProject(projectId, employeeIds);
			return ResponseEntity.ok("Employees has been assigned to the projecct");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/assignproject/{employeeId}")
    public ResponseEntity<String> assignProjectsToEmployee(@PathVariable long employeeId, @RequestBody List<Long> projectIds) {
    	try {
			employeeProjectService.assignProjectsToEmployee(employeeId, projectIds);
			return ResponseEntity.ok("Projects has been assigned to the employee");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
	
}
