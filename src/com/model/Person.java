package com.model;

public class Person {
    String name;
    String email;
    String phone;
    Boolean isValidPerson;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getValidPerson() {
        return isValidPerson;
    }

    public void setValidPerson(Boolean validPerson) {
        isValidPerson = validPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isValidPerson=" + isValidPerson +
                '}';
    }
}
