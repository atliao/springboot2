package com.la.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.la.boot.bean.Car;
import com.la.boot.bean.Pet;
import com.la.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author LA
 * @date 2022-09-12-15:33
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件。默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods：代理Bean方法
 *      默认：Full(true) 调用方法使用IOC容器的同一个实例
 *           Lite(false) 每次调用都产生新的实例
 *                 可用于实现组件依赖
 */
//表明这是一个配置类 == 配置文件
@Configuration(proxyBeanMethods = true)
@Import({User.class, DBHelper.class})//给IOC容器添加组件，自动生成这些类的无参构造器，并生成对象实例
@ConditionalOnMissingBean(name = "cat")//当容器中没有cat组件时，才注入
@ImportResource("classpath:beans.xml")//引入配置文件
//@EnableConfigurationProperties(Car.class)//开启属性配置绑定功能，把Car注册到容器中
public class MyConfig {

    @Bean //给容器中添加组件。默认以方法名为组件id。返回类型就是组件类型。返回的值就是组件在容器中的实例
    //@ConditionalOnBean(name = "cat")//当IOC容器中有cat组件时，才将user01注入IOC
    public User user01(){
        User user = new User("Tom",25);
        //将IOC容器中的对象注入依赖，需要调成true
        user.setPet(getPet());
        return user;
    }

    @Bean("cat2")//可以自定义id
    public Pet getPet(){
        return new Pet("cat");
    }
}
