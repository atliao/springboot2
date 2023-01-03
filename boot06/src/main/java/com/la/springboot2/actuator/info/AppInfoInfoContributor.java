package com.la.springboot2.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author LA
 * @date 2022-11-18-15:53
 * 自定义检查方法
 */
@Component
public class AppInfoInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg", "你好")
                .withDetail("hello", "liao")
                .withDetails(Collections.singletonMap("world", "666"));
    }
}
