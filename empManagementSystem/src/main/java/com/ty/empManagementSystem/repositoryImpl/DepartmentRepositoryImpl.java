package com.ty.empManagementSystem.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ty.empManagementSystem.dto.DepartmentDto;
import com.ty.empManagementSystem.model.DepartmentModel;
import com.ty.empManagementSystem.model.rowmapper.DepartmentRowmapper;
import com.ty.empManagementSystem.repository.DepartmentRepository;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addDept(DepartmentDto dept) {
		 String sql = "INSERT INTO departments (name, description) VALUES (?, ?)";
	     jdbcTemplate.update(sql, dept.getName(), dept.getDescription());
	}

	@Override
	public void changeDepartmentName(long id, String name) {
		String sql = "UPDATE departments SET name = ? WHERE id = ?";
		jdbcTemplate.update(sql, name, id);
	}

	@Override
	public DepartmentModel fetchDept(long id) {
		String sql = "SELECT * FROM departments WHERE id =?";
		return jdbcTemplate.queryForObject(sql, new DepartmentRowmapper(), id);
	}

	@Override
	public List<DepartmentModel> fetchAll() {
		String sql = "SELECT * FROM departments";
		return jdbcTemplate.query(sql, new DepartmentRowmapper());
	}
	
	@Override
	public void deleteDepartment(long id) {
		 String updateQuery = "UPDATE employees SET department_id = NULL WHERE department_id = ?";
	     jdbcTemplate.update(updateQuery, id);
	     String deleteQuery = "DELETE FROM departments WHERE id = ?";
	     jdbcTemplate.update(deleteQuery, id);
	}

	

}
