###Ioc容器
 ##核心接口
 - org.springframework和org.springframecontext.beans
 ###容器工作步骤
 1配置元数据
 - 基于xml配置：在<beans> 标签中配置元数据
 - 基于注解配置：大大简化配置
 - 基于java配置:使用java类未定义javaBean
 2实例化容器
 3使用容器
 - 依赖：构造器注入 setter注入
 
 ###关于spring配置和注解说明
 1基于xml方式来做bean的配置
 - <bean> 标签使用：id class
 - 构造器注入:ref 引用其他对象
 - setter注入:p:简写形式
 2两种方式获得xml中bean
 - 配置类一定要加上@Configutation 配置类中配置bean 方法：要加上@Bean
 ```
@ContextConfiguration
public class AppConfig {
    @Bean
    public Book book(){
        return new Book();
    }
}
```
3如何在springFramework中获得java配置类bean
- main方法
 ```
public class BookTest {
    public static void main(String[] args) {
        //生成基于注解配置的引用上下文对象
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //手动开启扫包
        ctx.scan("com.soft1851.spring.ioc.config");
        //ctx.refresh();
        Book book = (Book) ctx.getBean("book");
        book.setName("java");
        book.setPrice(99.9);
        System.out.println(book);
    }
}
```
###JDBC配置
- 开启注解支持扫包
- 通过context上下文读取
- 数据元
- JDBC模板
