package com.la.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author LA
 * @date 2022-09-13-10:11
 */
@Component//只有在IOC容器中的组件，才会拥有springboot的功能，先加入容器
    //或者在MyConfig中开启属性配置功能
@ConfigurationProperties(prefix = "mycar")//对应配置文件中的值

@Data //使用lombok自动生成get、set方法
@ToString //使用lombok自动生成toString方法
@AllArgsConstructor //有参构造器
@NoArgsConstructor //无参构造器
public class Car {
    private String brand;
    private Integer price;

}
