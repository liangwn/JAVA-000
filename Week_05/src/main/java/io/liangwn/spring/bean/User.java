package io.liangwn.spring.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by liang on 2020/11/15.
 */
@Data
public class User {

    private String name;

    private Integer age;

    private BigDecimal income;
}
