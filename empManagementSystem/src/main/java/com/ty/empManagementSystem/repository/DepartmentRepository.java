package com.ty.empManagementSystem.repository;

import java.util.List;

import com.ty.empManagementSystem.dto.DepartmentDto;
import com.ty.empManagementSystem.model.DepartmentModel;

public interface DepartmentRepository {

	void addDept(DepartmentDto dept);
	void changeDepartmentName(long id, String name);
	DepartmentModel fetchDept(long id);
	List<DepartmentModel> fetchAll();
	void deleteDepartment(long id);
	
}
