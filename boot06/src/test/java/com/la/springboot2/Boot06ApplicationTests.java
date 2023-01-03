package com.la.springboot2;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Boot06ApplicationTests {

	@Autowired
	StringRedisTemplate redisTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void redisTest(){
		ValueOperations<String, String> operations = redisTemplate.opsForValue();

		operations.set("user","liao");

		String users = operations.get("users");
		System.out.println(users);
	}

}
