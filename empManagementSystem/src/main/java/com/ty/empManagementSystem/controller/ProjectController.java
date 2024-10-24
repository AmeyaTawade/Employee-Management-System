package com.ty.empManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.empManagementSystem.dto.ProjectDto;
import com.ty.empManagementSystem.model.ProjectModel;
import com.ty.empManagementSystem.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/save")
	public ResponseEntity<String> addProject(@RequestBody ProjectDto project) {
		try {
			projectService.addProject(project);
			return ResponseEntity.ok("new project created");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("/changename")
	public ResponseEntity<String> changeProjectname(@RequestParam long id, @RequestParam String name) {
		try {
			projectService.changeProjectname(id, name);
			return ResponseEntity.ok("Project name has been changed");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("/fetchproject")
	public ProjectModel fetchById(@RequestParam long id) {
		try {
			return projectService.fetchById(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/allproject")
	public List<ProjectModel> fetchAll() {
		try {
			return projectService.fetchAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteProject(@RequestParam long id) {
		try {
			projectService.deleteProject(id);
			return ResponseEntity.ok("Your project is deleted");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
