package com.training.spring.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.annotation.entity.Department;
import com.training.spring.dao.DepartmentDao;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	
	public Department findDepartment(Integer id) {
		
		
		//calling DepartmentDao	
		return departmentDao.findDepartmentById(id);
	}
	
	@Test
	public List<Department> findAllDepartment() {
		return departmentDao.findAllDepartment();
		
	}

	public void save(Department department) {
		departmentDao.Save(department);
	}

	public void Update(Department department) {
		departmentDao.Update(department);
	}	
	
	public void Delete(Department department) {
		departmentDao.Delete(department);
	}	

}
