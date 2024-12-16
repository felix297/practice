package com.company;

import com.company.entity.User;

public class App {
    public static void main(String[] args) {
		User user = new User();
		user.setName("felix");
		user.setAge(24);
		user.setGender(0);

		System.out.println(user.toString());
    }
}
