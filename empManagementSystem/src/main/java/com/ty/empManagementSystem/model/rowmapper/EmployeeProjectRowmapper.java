package com.ty.empManagementSystem.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ty.empManagementSystem.model.EmployeeProjectModel;

public class EmployeeProjectRowmapper implements RowMapper<EmployeeProjectModel> {

	@Override
	public EmployeeProjectModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeProjectModel employeeProjectModel = new EmployeeProjectModel();
		employeeProjectModel.setEmployeeId(rs.getLong("employee_id"));
		employeeProjectModel.setProjectId(rs.getInt("project_id"));
		return null;
	}

	
}
