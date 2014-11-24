import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;






import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;
import com.hibernate.annotation.entity.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hibernate.xml"})

public class EmployeeHibernateTemplete {
	
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private static Session session;	
	
	
	@Autowired
	private HibernateTemplate hibernateTemplete;
	
	@Test
	public void test() {
		System.out.println(hibernateTemplete);
	}
	@Test
	public void testFindEmployeeWithHQL() {
		List<Employee> employeelist = hibernateTemplete.find("From Employee");
		
		displayEmployee(employeelist);
	}
		
	
	
//	@Test
//	public void testGetEmployeeByPk() {
//		
//		System.out.println(hibernateTemplete);
//		
//		//Get the Employee using spring
//		Employee employee = hibernateTemplete.get(Employee.class, 1); // ที่ติดต่อกับ  database แล้วต้องไป comment pom.xml แล้วต้องไป set password ที่ properties ที่ database
//		
//		System.out.println("first name :" +employee.getFirstName());
//		System.out.println("last name :" +employee.getLastName());
//	}
//	
////	@Test
////	public void testFindEmployeeHQL() {
////		List<Employee> employeelist = hibernateTemplete.find("From Employee");
////		
////		for(Employee employee : employeelist) {
////			System.out.println("First Name :" +employee.getFirstName()
////					+"Last Name :" +employee.getLastName() // การต่อ string
////					+"Salary :" +employee.getSalary());
////			
////			//System.out.println("Last Name :" +employee.getLastName());
////			//System.out.println("Salary :" +employee.getSalary());
////			
////		}
////	}
//	
////	@Test // แบบที่ 1
////	public void testFindDepartmentHQL() {
////		List<Department> departmentlist = hibernateTemplete.find("From Department");
////		
////		for(Department department : departmentlist) {
////			System.out.println("Name : "+department.getName());
////					+"Last Name :" +department.getLastName() // การต่อ string
////					+"Salary :" +employee.getSalary());
//			
//			//System.out.println("Last Name :" +employee.getLastName()); ไม่ต่อ string
//			//System.out.println("Salary :" +employee.getSalary());
//			
//	
//	@Test // แบบที่ 2 การใส่ค่าแบบ parameter 
//	public void testFindEmployeeWithHQLByParameter() {
//		List<Employee> employeelist = hibernateTemplete.find("From Employee where id = ?",new Integer[] {1});//{1} คือการใส่ parameter ี่ต้องการให้แสดงค่า
//		
//		for(Employee employee : employeelist) {
//			System.out.println("First Name :" +employee.getFirstName()
//					+"Last Name :" +employee.getLastName() // การต่อ string					
//					+"Salary :" +employee.getSalary());
//		}
//	}
//
//	
	private void displayEmployee(List<Employee> employeelist) {
		
		for(Employee employee : employeelist) {
			System.out.println("First Name :" +employee.getFirstName()
					+"Last Name :" +employee.getLastName() // การต่อ string
					+"Salary :" +employee.getSalary());
		}
	}
	
	@Test
	public void testFindEmployeeWithNameQuery() {
		
		List<Employee> employeelist = hibernateTemplete.findByNamedQuery("findAllEmployee");
		displayEmployee(employeelist);
	}
	
	@Test
	public void testFindEmployeeWithCriteria() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		criteria.add(Restrictions.eq("firstName", "John"));
		
		List<Employee> employeelist = hibernateTemplete.findByCriteria(criteria);
		displayEmployee(employeelist);
		
		
	}
	
//	private void EmployeeAdd() {
//		
//		Session session = sessionFactory.openSession();
//		
//		session.getTransaction().begin();
//		
//		Employee employee8 = new Employee("David","Coper","Bangkok","IT",30,50000);
//		Employee employee9 = new Employee("Titan","Lang","Samutprakran","IT",40,70000);
//		
//		 
//		
//		session.save(employee8);
//		session.save(employee9);
//		
//		session.getTransaction().commit();
//		
//		
//		
//	}
//	
//	private static void ListEmployee() {
//		session = sessionFactory.openSession();
//		List<Employee> result = session.createQuery("FROM Employee").list();
//		
//		System.out.println("total :" + result.size() + "records");
//		
//		for(Employee employee : result) {
//			System.out.println("firstName :" +employee.getFirstName()
//					+ "lastName :" +employee.getLastName()
//					+ "Address :" +employee.getAddress()
//					+ "Position :" +employee.getPosition()
//					+ "Age :" +employee.getAge()
//					+ "Salary :" +employee.getSalary());
//		}
//	}
	
	@Test
	public void insertEmployeeTest() {
		
		Employee employee = new Employee();
        employee.setFirstName("Natechanok");
        employee.setLastName("Klinjun");
        employee.setAge(30);
        employee.setSalary(20000);
        
        hibernateTemplete.save(employee);
		
		
	}
	
	
//	@Test
//	public void updateEmployeeTest() {
//		
//		Employee employee = (Employee) hibernateTemplete.get(Employee.class,1);
//		employee.setSalary(70000.00);
//		 
//		hibernateTemplete.update(employee);
//               
//        
//				
//	}
	
	@Test //การเขียน test
	public void deleteEmployeeTest() {
		
		Employee employee = (Employee) hibernateTemplete.get(Employee.class,8);
		
		
		hibernateTemplete.delete(employee);
               
 
	}
	
	
}
