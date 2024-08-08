package com.example.crudapi.Model;

public class UserModel {
    private Long id;
    private String name;
    private int age;
    private Boolean cute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getCute() {
        return cute;
    }

    public void setCute(Boolean cute) {
        this.cute = cute;
    }
}
