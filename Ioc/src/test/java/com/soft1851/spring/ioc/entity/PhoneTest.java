package com.soft1851.spring.ioc.entity;

import com.soft1851.spring.ioc.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/beans.xml"})
@ContextConfiguration(classes = {AppConfig.class})

public class PhoneTest {
    @Autowired
    private Phone phone;

    @Test
    public void  test(){
        phone.setBrand("IphoneXS");
        phone.setPrice(9999.9);
        System.out.println(phone);
    }

}