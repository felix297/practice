package com.company.dao;

import com.company.annotation.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("user")
@Genre
public class User {
    @Value("tom")
    private String name;
    @Value("3")
    private int age;
}