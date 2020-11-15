package io.liangwn.spring.xml;

import io.liangwn.spring.bean.School;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liang on 2020/11/15.
 */
public class CustomSpringXmlBeanDefinition {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:BeanConfig.xml");
        classPathXmlApplicationContext.refresh();
        School school = (School) classPathXmlApplicationContext.getBean("mySchool");
        System.out.println("school: "+school.toString());
    }
}
