package com.training.spring.app;

import com.training.spring.bean.ExampleComponent;
import com.training.spring.bean.Hello;
import com.training.spring.bean.Humen;
import org.hibernate.criterion.Example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Date: 10/31/2014
 * Time: 3:21 PM
 *
 * @author assanai.manurat
 */
public class HelloApp { // ��� run

    public static void main(String[] args) {

        loadXmlClasspathApplicationContext();
    }

    private static void loadXmlClasspathApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println("############### Hello ###################");
        System.out.println("hello : " + hello);
        System.out.println("hello.humen : " + hello.getHumen());


        System.out.println("############### Humen ###################");
        Humen humen = (Humen) context.getBean("humen"); //(Humen) cast ����͹�������¹ Obj ��  type /** Ẻ1 
        System.out.println("humen : "+ humen);

        System.out.println("############### Humen Object ###################");
        Humen humenObj = context.getBean(Humen.class);// /**Ẻ2
        System.out.println("humenObj : "+ humenObj);


        ExampleComponent component = context.getBean(ExampleComponent.class);
        System.out.println("component : " + component);
        
//        Humen humen = (Humen) context.getBean("Human");
//        System.out.println(humen);
//        
//        Humen humen = (Humen) context.getBean(humen.);
//        System.out.println(humen);
        
       // hello.getHumen(humen);
        
        System.out.println("Display humen firstName :" +hello.getHumen().getFirstName());
        System.out.println("Display humen lastName :" +hello.getHumen().getLastName());
        
        System.out.println("Display humen firstName :" +humen.getHello().getMessage()); // ��ͧ���� property �applicationContext
        System.out.println("Display humen firstName :" +humen.getHello().getAge());
    }
}
