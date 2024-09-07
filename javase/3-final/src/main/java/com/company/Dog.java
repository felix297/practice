package com.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private final String name = "tom";
    private int age;
    private String gender;

    public void setName (String name) {
        this.name = name;
    }
}