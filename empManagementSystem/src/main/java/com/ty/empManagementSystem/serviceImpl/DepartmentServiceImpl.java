package com.ty.empManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.empManagementSystem.dto.DepartmentDto;
import com.ty.empManagementSystem.model.DepartmentModel;
import com.ty.empManagementSystem.repository.DepartmentRepository;
import com.ty.empManagementSystem.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public void addDept(DepartmentDto dept) {
		departmentRepository.addDept(dept);
	}

	@Override
	public void changeDepartmentName(long id, String name) {
		departmentRepository.changeDepartmentName(id, name);
	}

	@Override
	public DepartmentModel fetchDept(long id) {
		return departmentRepository.fetchDept(id);
	}

	@Override
	public List<DepartmentModel> fetchAll() {
		return departmentRepository.fetchAll();
	}
	
	@Override
	public void deleteDepartment(long id) {
		departmentRepository.deleteDepartment(id);
	}	

}
