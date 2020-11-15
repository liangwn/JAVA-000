package io.liangwn.spring.annotation;

import io.liangwn.spring.bean.Student;
import io.liangwn.spring.config.StudentConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自动装配Bean
 * Created by liang on 2020/11/15.
 */
public class AnnotationConfigBeanDefinition {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
        Student student = applicationContext.getBean(Student.class);
        System.out.println("student: "+student.toString());
        student.learn();
    }
}
