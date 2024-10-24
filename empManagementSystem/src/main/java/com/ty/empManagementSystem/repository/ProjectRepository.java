package com.ty.empManagementSystem.repository;

import java.util.List;

import com.ty.empManagementSystem.dto.ProjectDto;
import com.ty.empManagementSystem.model.ProjectModel;

public interface ProjectRepository {

	void addProject(ProjectDto project);
	void changeProjectname(long id, String name);
	ProjectModel fetchById(long id);
	List<ProjectModel> fetchAll();
	void deleteProject(long id);
}
