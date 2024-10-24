package com.ty.empManagementSystem.repositoryImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ty.empManagementSystem.dto.EmployeeDto;
import com.ty.empManagementSystem.model.EmployeeModel;
import com.ty.empManagementSystem.model.rowmapper.EmployeeRowmapper;
import com.ty.empManagementSystem.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeRowmapper employeeRowmapper;
	@Override
	public void addEmployee(EmployeeDto emp) {
		String sql = "INSERT INTO employees (first_name, last_name, email, department_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getDepartmentId());
	}

	@Override
	public void changeEmail(long id, String email) {
		String sql = "UPDATE employees SET email = ? WHERE id = ?";
		jdbcTemplate.update(sql, email, id);
	}

	@Override
	public EmployeeModel fetchEmployeeById(long id) {
		String sql = "SELECT * FROM employees WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new EmployeeRowmapper(), id);
	}

	@Override
	public List<EmployeeModel> fetchAllEmployee() {
		String sql = "SELECT * FROM employees";
		return jdbcTemplate.query(sql, new EmployeeRowmapper());
	}

	@Override
	public void deleteEmployee(long id) {
		String sql = "DELETE FROM employees WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public List<EmployeeModel> fetchByDepartmentId(long id) {
		String sql = "SELECT * FROM employees WHERE department_id = ?";
		return jdbcTemplate.query(sql, new EmployeeRowmapper(), id);
	}

	@Override
	public List<EmployeeModel> fetchPage(int page, int size) {
		int offset = page * size;
        String sql = "SELECT * FROM employees ORDER BY id LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, size);
                ps.setInt(2, offset);
            }
        }, employeeRowmapper);
	}

	@Override
	public List<EmployeeModel> sortEmplpoyee() {
		 String sql = "SELECT * FROM employees ORDER BY first_name, last_name";
	     return jdbcTemplate.query(sql, new EmployeeRowmapper());
	}

	@Override
	public void setDepartmentId(long empId, long deptId) {
		String sql = "UPDATE employees SET department_id = ? WHERE id = ?";
		jdbcTemplate.update(sql, deptId, empId);
	}
	
	
}
