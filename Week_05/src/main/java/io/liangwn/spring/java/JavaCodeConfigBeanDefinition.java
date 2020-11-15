package io.liangwn.spring.java;

import io.liangwn.spring.bean.Teacher;
import io.liangwn.spring.config.TeacherConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过Java代码装配Bean
 * Created by liang on 2020/11/15.
 */
public class JavaCodeConfigBeanDefinition {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TeacherConfig.class);
        Teacher teacher = applicationContext.getBean(Teacher.class);
        System.out.println("teacher: "+teacher.toString());
        teacher.say();

    }
}
