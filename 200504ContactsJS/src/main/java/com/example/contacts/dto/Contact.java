package com.example.contacts.dto;

public class Contact {

    public String name;
    public String lastName;
    public int id;
    public int age;

    public Contact() {
    }

    public Contact(String name, String lastName, int id, int age) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
