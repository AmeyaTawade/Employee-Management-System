package com.ty.empManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.empManagementSystem.dto.DepartmentDto;
import com.ty.empManagementSystem.model.DepartmentModel;
import com.ty.empManagementSystem.repository.DepartmentRepository;
import com.ty.empManagementSystem.service.DepartmentService;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public ResponseEntity<String> addDepartment(@RequestBody DepartmentDto dept) {
		try {
			departmentService.addDept(dept);
			return ResponseEntity.ok("New Department has been added");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("/changedept")
	public ResponseEntity<String> changeDepartmentName(@RequestParam long id, @RequestParam String name) {
		try {
			departmentService.changeDepartmentName(id, name);
			return ResponseEntity.ok("Department name has been changed");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("/fetchdept")
	public DepartmentModel fetchDept(@RequestParam long id) {
		try {
			return departmentService.fetchDept(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("alldept")
	public List<DepartmentModel> fetchAll() {
		try {
			return departmentService.fetchAll();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteDepartment(@RequestParam long id) {
		try {
			departmentService.deleteDepartment(id);
			return ResponseEntity.ok("Department has been deleted");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
