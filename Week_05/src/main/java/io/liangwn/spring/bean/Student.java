package io.liangwn.spring.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by liang on 2020/11/15.
 */
@Data
@Component(value = "student")
public class Student {

    @Value("1")
    private Long id;

    @Value("Mary")
    private String name;

    public void learn() {
        System.out.println("attend one class");
    }
}
