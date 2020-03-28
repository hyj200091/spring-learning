package com.soft1851.spring.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @ClassName WebApplicationConfig
 * @Description web应用配置，替代web.xml
 * @Author 田震
 * @Date 2020/3/24
 **/
public class WebApplicationConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //创建一个基于注解的web应用的上下文配置对象，实用AnnotationConfigRegistry
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //将WebMvcConfig的配置类注册进来
        ctx.register(WebMvcConfig.class);
        //设置servletContext
        ctx.setServletContext(servletContext);
        //刷新
        ctx.refresh();
        //映射规则的配置
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        //添加规则
        registration.addMapping("/");
        //设置该servlet的启动优先级
        registration.setLoadOnStartup(1);
    }
}