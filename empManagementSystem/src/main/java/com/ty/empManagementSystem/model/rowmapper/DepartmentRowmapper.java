package com.ty.empManagementSystem.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ty.empManagementSystem.model.DepartmentModel;

public class DepartmentRowmapper implements RowMapper<DepartmentModel> {

	@Override
	public DepartmentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		DepartmentModel deptModel = new DepartmentModel();
		deptModel.setId(rs.getLong("id"));
		deptModel.setName(rs.getString("name"));
		deptModel.setDeptDescription(rs.getString("description"));
		return deptModel;
	}

	
}
