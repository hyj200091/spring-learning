package com.soft1851.spring.ioc.entity;

import java.util.List;

public class Student {
    private Integer id;
    private String name;
    private List<String> hobbits;
    private List<Phone> phones;
    public Student(){}

    public Student(Integer id, String name, List<String> hobbits, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.hobbits = hobbits;
        this.phones = phones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbits() {
        return hobbits;
    }

    public void setHobbits(List<String> hobbits) {
        this.hobbits = hobbits;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbits=" + hobbits +
                ", phones=" + phones +
                '}';
    }
}
