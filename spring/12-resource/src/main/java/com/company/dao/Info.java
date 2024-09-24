package com.company.dao;

import com.company.annotation.Genre;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("info")
public class Info {
    User user;

    @Genre
    public Info (User user) {
        this.user = user;
    }
}