package io.liangwn.spring.xml;

import io.liangwn.spring.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过XML装配bean
 * Created by liang on 2020/11/15.
 */
public class XmlPropertyBeanDefinition {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:spring-bean-config.xml");
        classPathXmlApplicationContext.refresh();

        User user = classPathXmlApplicationContext.getBean(User.class);
        System.out.println("user: "+user.toString());
        classPathXmlApplicationContext.close();
    }
}
