package com.la.boot;

import ch.qos.logback.core.db.DBHelper;
import com.la.boot.bean.Pet;
import com.la.boot.bean.User;
import com.la.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author LA
 * @date 2022-09-11-15:29
 * 主程序类
 * @SpringBootApplication：这是一个springboot应用
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.la.boot")
//@SpringBootApplication //等价于上面三个
//@SpringBootApplication(scanBasePackages = "com.la")//改变路径，拓展范围
public class MainApplication {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }
       /* //3.从容其中获取组件
        User user01 = run.getBean("user01",User.class);
        System.out.println(user01);

        //获取的是同一个组件
        Pet cat1 = run.getBean("cat",Pet.class);
        Pet cat2 = run.getBean("cat",Pet.class);
        System.out.println(cat1==cat2);

        //也可以获取配置类对象，及调用方法
        MyConfig config = run.getBean(MyConfig.class);
        //根据配置类获取对象，也是一样的，都是获取的容器中的实例
        Pet cat01 = config.getPet();
        Pet cat02 = config.getPet();
        System.out.println(cat01==cat02);

        User user = run.getBean("user01",User.class);
        Pet cat = run.getBean("cat",Pet.class);
        System.out.println("容器中User的Pet是否为容器本省的Pet" + (cat==user.getPet()));

        //4.查看@Import注入的对象
        String[] beanNamesForType = run.getBeanNamesForType(User.class);//获取该类型的IOC中存在的所有组件的名称
        for(String s : beanNamesForType){
            System.out.println(s);
        }

        DBHelper dbHelper = run.getBean(DBHelper.class);
        System.out.println(dbHelper);*/

        boolean b1 = run.containsBean("cat");
        System.out.println("容器中是否有cat组件：" + b1);

        boolean b2 = run.containsBean("cat2");
        System.out.println("容器中是否有cat2组件：" + b2);

        boolean b3 = run.containsBean("user01");
        System.out.println("容器中是否有user01组件：" + b3);

        boolean baby = run.containsBean("baby");
        boolean littleCat = run.containsBean("littleCat");
        System.out.println("baby:" + baby);
        System.out.println("littleCat:" + littleCat);

    }
}
