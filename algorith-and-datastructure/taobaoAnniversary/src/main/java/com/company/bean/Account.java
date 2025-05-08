package com.company.bean;

public class Account {
    private int id;
    private String name;
    private int[] count;

    public Account(int id, String name, int[] count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int[] count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getCount() {
        return count;
    }
}