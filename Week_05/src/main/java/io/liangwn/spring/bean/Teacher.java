package io.liangwn.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by liang on 2020/11/15.
 */
@Data
@AllArgsConstructor
public class Teacher {

    private String name;

    private String gender;

    public void say() {
        System.out.println("I am teacher");
    }

}
