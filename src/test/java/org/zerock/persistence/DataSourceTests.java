package org.zerock.persistence;


import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests { 

	@Setter(onMethod_= {@Autowired})
	DataSource dataSource;
	
	@Setter(onMethod_= {@Autowired})
	SqlSessionFactory sqlSessionFactory;
	
	@Test
    public void testConnection() { // 커넥션풀 테스트( hikariCP)
		try {
			Connection con=dataSource.getConnection();
			log.info("커넥션풀 테스트 성공");
		} catch (SQLException e) {
			fail(e.getMessage());
			log.info("커넥션풀 테스트 실패");
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testMyBatis() {
		SqlSession session=sqlSessionFactory.openSession();
		Connection con=session.getConnection();
		log.info(con);
		log.info("MyBatis 연결성공");
	}
	
}









