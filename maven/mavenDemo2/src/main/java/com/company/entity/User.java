package com.company.entity;

/**
 * Entity of User
 */
public class User {
	// name of user
	private String name;

	// age of user
	private int age;

	// gender os user
	private int gender;

	public User () {

	}

	public User (String name, int age, int gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void setName (String name) {
		this.name = name;
	}

	public void setAge (int age) {
		this.age = age;
	}

	public void setGender (int gender) {
		this.gender = gender;
	}

	public String getName () {
		return this.name;
	}

	public int getAge () {
		return this.age;
	}

	public int getGender () {
		return this.gender;
	}

	@Override
	public String toString() {
		return "User{" + "name=" + this.name + ";age=" + this.age + ";gender=" + this.gender + "}";
	}
}
