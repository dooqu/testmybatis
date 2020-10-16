package com.dooqu.testmybatis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class People {
    @Value("${name:${java.home}}")
    private String name;
    private int age;
}
