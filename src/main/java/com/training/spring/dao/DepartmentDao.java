package com.training.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hibernate.annotation.entity.Department;



	@Repository
	public class DepartmentDao {
	
	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	public Department findDepartmentById(Integer id) {
		
		
		return hibernateTemplate.get(Department.class, id);
	}
	
	public List<Department> findAllDepartment() {
		return hibernateTemplate.find("from Department");
	}
	
	public void Save(Department department){
		hibernateTemplate.save(department);
	}
	

	public void Update(Department department){
		hibernateTemplate.update(department);
	}
	

	public void Delete(Department department){
		hibernateTemplate.delete(department);
	}

}
