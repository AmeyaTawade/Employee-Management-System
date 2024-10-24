package com.ty.empManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.empManagementSystem.dto.ProjectDto;
import com.ty.empManagementSystem.model.ProjectModel;
import com.ty.empManagementSystem.repository.ProjectRepository;
import com.ty.empManagementSystem.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public void addProject(ProjectDto project) {
		projectRepository.addProject(project);
	}

	@Override
	public void changeProjectname(long id, String name) {
		projectRepository.changeProjectname(id, name);
	}

	@Override
	public ProjectModel fetchById(long id) {
		return projectRepository.fetchById(id);
	}

	@Override
	public List<ProjectModel> fetchAll() {
		return projectRepository.fetchAll();
	}

	@Override
	public void deleteProject(long id) {
		projectRepository.deleteProject(id);
	}

	
}
