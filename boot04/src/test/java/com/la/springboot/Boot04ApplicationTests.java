package com.la.springboot;

import com.la.springboot.bean.Person;
import com.la.springboot.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot04ApplicationTests {


	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	PersonMapper personMapper;

	@Test
	void contextLoads() {
		String sql = "select count(*) from t_account";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		log.info("记录总数:{}", count);
		log.info("数据源类型:{}", dataSource.getClass());
	}

	@Test
	void testPersonMapper(){
		Person person = personMapper.selectById(1);
		log.info("用户信息:{}", person);
	}

}
