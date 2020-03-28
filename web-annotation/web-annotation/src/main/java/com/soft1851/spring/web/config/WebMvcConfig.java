package com.soft1851.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * @ClassName WebMvcConfig
 * @Description TODO
 * @Author 田震
 * @Date 2020/3/24
 **/
@Configuration
@ComponentScan("com.soft1851.spring.web")
/**
 * 让webMvc的注释生效
 */
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 配置视图解析器
     * @return
     */
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver(){
        return new SpringResourceTemplateResolver();
    }
    /**
     * 设置前缀后缀
     * @return
     */
    private ITemplateResolver templateResolver(){
        //classpath:/代表resources目录
        springResourceTemplateResolver().setPrefix("classpath:/templates/");
        //设置映射访问的后缀
        springResourceTemplateResolver().setSuffix(".html");
        springResourceTemplateResolver().setTemplateMode(TemplateMode.HTML);
        springResourceTemplateResolver().setCharacterEncoding("UTF-8");
        return springResourceTemplateResolver();
    }
    @Bean
    public TemplateEngine templateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        return engine;
    }
    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}