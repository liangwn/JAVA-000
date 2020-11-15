package io.liangwn.spring.config;

import io.liangwn.spring.bean.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liang on 2020/11/15.
 */
@Configuration
public class TeacherConfig {

    @Bean
    public Teacher teacher() {
        return new Teacher("Mary", "female");
    }
}
