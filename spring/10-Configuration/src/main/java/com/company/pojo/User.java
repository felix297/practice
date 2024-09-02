package com.company.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class User {
    @Value("tom")
    private String name;
    @Value("20")
    private int age;
    @Value("male")
    private String gender;
}