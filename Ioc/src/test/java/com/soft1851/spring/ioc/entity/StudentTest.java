package com.soft1851.spring.ioc.entity;

import com.soft1851.spring.ioc.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/beans.xml"})
@ContextConfiguration(classes = {AppConfig.class})
public class StudentTest {
    @Autowired
    private Student student;
    @Test
    public void  test(){
        List<String> hobbitsList = new ArrayList<>();
        List<Phone> phonesList = new ArrayList<>();
        Phone phone = new Phone();
        phone.setBrand("IphoneXS");
        phone.setPrice(9999.9);
        hobbitsList.add("篮球");
        student.setHobbits(hobbitsList);
        phonesList.add(phone);
        student.setId(1);
        student.setName("hyj");
        student.setPhones(phonesList);
        System.out.println(student);
    }
}