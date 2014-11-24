import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.hibernate.annotation.entity.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:hibernate.xml"})

public class EmployeeSessionFactory {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Test
	public void testGetSessionFromSessionFactory() {
		
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class, 1);
		
		System.out.println(employee);
		
		session.close();
	
	}
	
	@Test // เป็นการเรียก resposition โดยตรง testFindHQLByFirstName,testFindCriteriaByFirstNameAndLastName,testFindByNameQuery
	public void testFindHQLByFirstName() {
		
		Session session = sessionFactory.openSession();
		
		List<Employee> employeelist = session.createQuery("FROM Employee e Where e.firstName ='Bill'").list();
		
		System.out.println(employeelist);
		session.close();
	}
	
	
	@Test
	public void testFindCriteriaByFirstNameAndLastName() {
		
		Session session = sessionFactory.openSession();
		
		Criteria criteria =session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("firstName", "Bill")); 
		criteria.add(Restrictions.eq("lastName", "KKK")); 
		List<Employee> employeeList = criteria.list();
		System.out.println(employeeList);
		
		session.close();
		
	}
	
	@Test
	public void testFindByNameQuery(){
		
		Session session = sessionFactory.openSession();
		
		List<Employee> allEmployee = session.getNamedQuery("findAllEmployee").list(); 
		
		System.out.println(allEmployee);
		session.close();
	}
	
}
