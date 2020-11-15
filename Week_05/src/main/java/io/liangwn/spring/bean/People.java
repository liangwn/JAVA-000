package io.liangwn.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by liang on 2020/11/15.
 */
@Data
@AllArgsConstructor
public class People {

    private String name;

    private Integer age;

    private BigDecimal income;
}
