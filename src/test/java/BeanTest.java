import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;






import com.training.spring.bean.ExampleComponent;
import com.training.spring.bean.Hello;
import com.training.spring.bean.Humen;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //applicationContext หาทั้งหมดที่อยู่ใน class path



public class BeanTest {
	
	@Autowired
	private Hello hello; // เเสดงค่าข้อมูลออกมา มันจะใช้คำสั่งสั้นกว่า
	
	@Autowired
	private Humen humen;
	
	@Autowired
	private ExampleComponent exampleComponent;
	
	/*@Test //run แบบ j-unit ธรรมดา
	public void TestSimpleBean() {
		System.out.println("### This is test for Simple Bean ###");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello = (Hello) context.getBean("hello");
        System.out.println("############### Hello ###################");
       // System.out.println("hello : " + hello);
	}*/
	
	@Test
	public void testAutowiring() {
		System.out.println("########## Autowiried Humen #########");
		System.out.println(hello);
	}
	
	@Test
	public void testAutowiringHumen() {
		System.out.println("########## Autowiried Hello #########");
		System.out.println(humen);
	}
	@Test
	public void TestEampleComponent() {
		System.out.println("Show message :" +exampleComponent);
		System.out.println("Show message :" +exampleComponent.getHello());
		System.out.println("Show message :" +exampleComponent.getHumen());
		System.out.println("Show message :" +exampleComponent.getAddress());
		System.out.println("Show message :" +exampleComponent.getCompany());
	}


}
