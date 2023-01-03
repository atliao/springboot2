package com.la.springboot;

import com.la.springboot.bean.UserP;
import com.la.springboot.mapper.UserPMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class Boot05ApplicationTests {


	@Autowired
	UserPMapper userPMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void testPersonMapper(){
		UserP person = userPMapper.selectById(1);
		log.info("用户信息:{}", person);
	}

}
