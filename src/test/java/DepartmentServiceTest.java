import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hibernate.annotation.entity.Department;
import com.training.spring.service.DepartmentService;
import com.training.spring.service.EmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hibernate.xml"})


public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@Test
	public void testDepartmentByIdShouldFoundData() throws Exception {

		Department department = departmentService.findDepartment(1);
		
		System.out.println(department);
	}
	
	@Test
	public void testFindAllDepartment()  {

		List<Department> department = (List<Department>) departmentService.findAllDepartment();
		
		System.out.println(department);
	}
	
	@Test
	public void Save() {
		Department department = new Department(6,"IC");
		Department department2 = new Department("IC");
		departmentService.save(department);	
	}
	
	@Test
	public void Update() {
		Department department = departmentService.findDepartment(1);
		department.setName("ADMIN");
		departmentService.Update(department);
		
	}

	@Test
	public void Delete() {
		Department department  = departmentService.findDepartment(1);
		
		departmentService.Delete(department);
		
	}
	
	

}
