package com.la.springboot2;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static java.lang.Integer.sum;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LA
 * @date 2022-11-16-10:40
 */
@DisplayName("Junit5g功能测试类")
@SpringBootTest //如果要用spring容器中的对象，需要加上该注解
public class Junit5Test {

    @DisplayName("测试displayName注解")
    @Test
    void testDisplayName(){
        System.out.println("测试1");
    }

    //@Disabled 禁用
    @DisplayName("测试方法2")
    @Test
    void test2(){
        System.out.println("测试2");
    }

    //规定超时时间，超出时间后，报错
    @DisplayName("测试超时")
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS) //500ms后超时
    @Test
    void testTimeout() throws InterruptedException {
        System.out.println("测试超时");
        //Thread.sleep(600);
    }

    //重复测试
    @DisplayName("重复测试")
    @RepeatedTest(3)
    @Test
    void test3(){
        System.out.println("重复测试");
    }

    @DisplayName("简单断言")
    @Test
    void test11(){
        int sum = sum(3,6);
        assertEquals(9, sum,"业务逻辑计算失败");
        Object o1 = new Object();
        Object o2 = new Object();
        assertEquals(o1, o2, "不是同一个对象");
    }

    @DisplayName("组合断言")
    @Test
    void test22(){
        assertAll("test",
                ()-> assertTrue(true && true, "结果不为true"),
                ()-> assertEquals(1,2, "结果不为1")
        );
    }

    int sum(int i, int j){
        return i + j;
    }

    //每个单元测试之前执行
    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了...");
    }

    //每个单元测试之后执行
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了...");
    }

   //所有单元测试之前执行
    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了...");
    }

    //所有单元测试之后执行
    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试结束了");
    }

}
