package com.company;

public class LoanConsumer {

    String name;
    int age;
    int salary; // Euro /year

    public LoanConsumer(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}
