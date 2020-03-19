package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.config.AppConfig;
import com.soft1851.spring.ioc.entity.Phone;
import com.soft1851.spring.ioc.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hyj
 * @Date 2020/3/17 9:56
 * @Description
 */
public class StudentTest {
    public static void main(String[] args) {
        //生成基于注解配置的引用上下文对象
        AnnotationConfigApplicationContext act = new AnnotationConfigApplicationContext(AppConfig.class);
        //更新
        //act.refresh();
        Phone  phone = (Phone) act.getBean("phone");
        phone.setBrand("IphoneXS");
        phone.setPrice(9999.9);
        System.out.println(phone);
        Student student = (Student) act.getBean("student");
        List<String> hobbitsList = new ArrayList<>();
        List<Phone> phonesList = new ArrayList<>();
        Phone  phone1 = (Phone) act.getBean("phone");
        phone1.setBrand("IphoneXS");
        phone1.setPrice(9999.9);
        hobbitsList.add("篮球");
        hobbitsList.add("台球");
        student.setHobbits(hobbitsList);
        phonesList.add(phone1);
        student.setId(1);
        student.setName("hyj");
        student.setPhones(phonesList);
        System.out.println(student);
    }
}
