package com.ty.empManagementSystem.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ty.empManagementSystem.model.ProjectModel;

public class ProjectRowmapper implements RowMapper<ProjectModel> {

	@Override
	public ProjectModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectModel projModel = new ProjectModel();
		projModel.setId(rs.getLong("id"));
		projModel.setName(rs.getString("name"));
		projModel.setProdDescription(rs.getString("description"));
		return projModel;
	}

}
