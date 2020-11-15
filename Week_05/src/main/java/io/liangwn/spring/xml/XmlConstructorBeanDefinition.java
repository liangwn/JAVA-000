package io.liangwn.spring.xml;

import io.liangwn.spring.bean.People;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过XML装配bean
 * Created by liang on 2020/11/15.
 */
public class XmlConstructorBeanDefinition {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:spring-bean-constructor-config.xml");
        classPathXmlApplicationContext.refresh();

        People people = classPathXmlApplicationContext.getBean(People.class);
        System.out.println("people: "+people.toString());
        classPathXmlApplicationContext.close();
    }
}
