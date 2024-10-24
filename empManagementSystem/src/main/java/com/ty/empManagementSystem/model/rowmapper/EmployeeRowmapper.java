package com.ty.empManagementSystem.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ty.empManagementSystem.model.EmployeeModel;

@Component
public class EmployeeRowmapper implements RowMapper<EmployeeModel>{

	@Override
	public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeModel empModel = new EmployeeModel();
		empModel.setId(rs.getLong("id"));
		empModel.setFirstName(rs.getString("first_name"));
		empModel.setLastName(rs.getString("last_name"));
		empModel.setEmail(rs.getString("email"));
		empModel.setDept_id(rs.getLong("department_id"));
		return empModel;
	}

}
