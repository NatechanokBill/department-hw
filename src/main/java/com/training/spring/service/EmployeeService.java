package com.training.spring.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.annotation.entity.Employee;
import com.training.spring.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	
	
	public Employee findEmployee(Integer id) {
		
		
		//calling EmployeeDao	
		return employeeDao.findEmployeeById(id);
	}
	
	
	//findEmployeeId
	//findAllEmployee
	//save
	//update
	//delete
	
	@Test
	public List<Employee> findAllEmployee() {
		return employeeDao.findAllEmployee();
			
	}
	
	public void save(Employee employee) {
		employeeDao.Save(employee);
	}
	
	public void Update(Employee employee) {
		employeeDao.Update(employee);
	}	
		
	public void Delete(Employee employee) {
		employeeDao.Delete(employee);
	}	
	
	
	
}
