package com.ty.empManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.empManagementSystem.repository.EmployeeProjectRepository;
import com.ty.empManagementSystem.service.EmployeeProjectService;

@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService{

	@Autowired
	private EmployeeProjectRepository employeeProjectRepository;
	
	@Override
	public void assignEmployeesToProject(long projectId, List<Long> employeeIds) {
		employeeProjectRepository.assignEmployeesToProject(projectId, employeeIds);
		
	}

	@Override
	public void assignProjectsToEmployee(long employeeId, List<Long> projectIds) {
		employeeProjectRepository.assignProjectsToEmployee(employeeId, projectIds);
	}

	
	

}
