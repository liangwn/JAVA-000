package io.liangwn.spring.bean;

import lombok.Data;

import java.util.List;

/**
 * Created by liang on 2020/11/15.
 */
@Data
public class School {

    private List<Klass> klassList;
}
