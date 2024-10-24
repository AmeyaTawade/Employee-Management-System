package com.ty.empManagementSystem.service;

import java.util.List;

import com.ty.empManagementSystem.dto.ProjectDto;
import com.ty.empManagementSystem.model.ProjectModel;

public interface ProjectService {

	void addProject(ProjectDto project);
	void changeProjectname(long id, String name);
	ProjectModel fetchById(long id);
	List<ProjectModel> fetchAll();
	void deleteProject(long id);
}
