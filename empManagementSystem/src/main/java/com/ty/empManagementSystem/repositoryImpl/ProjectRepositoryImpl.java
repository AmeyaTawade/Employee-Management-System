package com.ty.empManagementSystem.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ty.empManagementSystem.dto.ProjectDto;
import com.ty.empManagementSystem.model.ProjectModel;
import com.ty.empManagementSystem.model.rowmapper.ProjectRowmapper;
import com.ty.empManagementSystem.repository.ProjectRepository;


@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addProject(ProjectDto project) {
		String sql = "INSERT INTO projects (name, description) VALUES (?, ?)";
		jdbcTemplate.update(sql, project.getName(), project.getDescription());
	}

	@Override
	public void changeProjectname(long id, String name) {
		String sql = "UPDATE projects SET name = ? WHERE id = ?";
		jdbcTemplate.update(sql, name, id);
	}

	@Override
	public ProjectModel fetchById(long id) {
		String sql = "SELECT * FROM projects WHERE id =?";
		return jdbcTemplate.queryForObject(sql, new ProjectRowmapper(), id);
	}

	@Override
	public List<ProjectModel> fetchAll() {
		String sql = "SELECT * FROM projects";
		return jdbcTemplate.query(sql, new ProjectRowmapper());
	}

	@Override
	public void deleteProject(long id) {
		String sql = "DELETE FROM projects WHERE id = ?";
		jdbcTemplate.update(sql, id);
		
	}
	
	

}
