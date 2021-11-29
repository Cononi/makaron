package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {	//static 초기화 블럭
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로딩
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
	}
	
	@Test
	public void testConnection() {
		try {
			Connection con= DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","book_ex","book_ex");  //연결
			log.info("db 연결 성공");
		} catch (Exception e) {
			log.info("db 연결 실패");
			e.printStackTrace();
		}
		
	}
}
