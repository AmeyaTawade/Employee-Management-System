package com.ty.empManagementSystem.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ty.empManagementSystem.repository.EmployeeProjectRepository;

@Repository
public class EmployeeProjectRepositoryImpl implements EmployeeProjectRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void assignEmployeesToProject(long projectId, List<Long> employeeIds) {
		String sql = "INSERT INTO employee_projects (employee_id, project_id) VALUES (?, ?)";

		for (Long employeeId : employeeIds) {
			jdbcTemplate.update(sql, employeeId, projectId);
		}
	}

	@Override
	public void assignProjectsToEmployee(long employeeId, List<Long> projectIds) {
		String sql = "INSERT INTO employee_projects (employee_id, project_id) VALUES (?, ?)";
		
		for(Long projectId: projectIds) {
			jdbcTemplate.update(sql, employeeId, projectId);
		}
	}

}
