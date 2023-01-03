package com.la.springboot2.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LA
 * @date 2022-11-17-11:03
 * 自定义检查方法
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {

    /**
     * 真实的检查方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //获取连接并进行测试
        Map<String, Object> map = new HashMap<>();
        if(1 == 1){
            //builder.up();//健康
            builder.status(Status.UP);//健康
            map.put("count",1);
            map.put("ms", 100);
        }else{
            //builder.down();
            builder.status(Status.OUT_OF_SERVICE);//不能服务
            map.put("err", "连接超时");
            map.put("ms",3000);
        }

        builder.withDetail("code", 100).withDetails(map);
    }
}
