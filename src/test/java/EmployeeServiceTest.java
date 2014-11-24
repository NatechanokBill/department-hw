import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hibernate.annotation.entity.Employee;
import com.training.spring.service.EmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hibernate.xml"})

public class EmployeeServiceTest { //เราจะ test class
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testEmployeeByIdShouldFoundData() throws Exception {

		Employee employee = employeeService.findEmployee(1);
		
		System.out.println(employee);
	}
	
/*	@Test
	public void testFindAllEmployee()  {

		List<Employee> employee = (List<Employee>) employeeService.findAllEmployee();//findAllEmployee ชื่อที่ไปตั้ง
		
		System.out.println(employee);
	}*/
	
	@Test
	public void Save() {
		Employee employee = new Employee("Billy","Klinjunnn");
		employeeService.save(employee);
		
	}
	
	/*@Test
	public void Update() {
		Employee employee = employeeService.findEmployee(4);
		employee.setSalary(8588559);
		employeeService.Update(employee);
		
	}
*/
	/*@Test
	public void Delete() {
		Employee employee = employeeService.findEmployee(18);
		
		employeeService.Delete(employee);
		
	}*/
}
