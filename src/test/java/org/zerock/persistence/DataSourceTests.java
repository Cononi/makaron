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
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jua.makaron.domain.CustomerDTO;
import com.jua.makaron.phonecert.service.PhoneCertService;
import com.jua.makaron.register.service.RegisterCertService;
import com.jua.makaron.utilities.SHA256Util;
import com.jua.makaron.utilities.SignatureCreate;
import com.jua.makaron.vo.PhoneCertVO;
import com.jua.makaron.vo.SMSKeyVO;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests { 
	

	@Autowired
	SMSKeyVO smskeys;
	
	@Autowired
	RegisterCertService service;
	
	@Autowired
	PhoneCertService serviceP;
	
	@Setter(onMethod_= {@Autowired})
	DataSource dataSource;
	
	@Setter(onMethod_= {@Autowired})
	SqlSessionFactory sqlSessionFactory;
	
	@Test
    public void testConnection() { // 커넥션풀 테스트( hikariCP)
		log.info("으이");
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
	
	@Test
	public void testSMS() {
		SignatureCreate signatureCreate = new SignatureCreate();
		signatureCreate.sendSMS(smskeys,"01048121565","테스트 암호 입니다. 155532");
	}
	
	@Test
	public void tes() {
		log.info("-----------------------------------------------------------------------------");
		if(service.idCheck("hong")) {
			log.info("-----------------------------------------------------------------------------");
			log.info("성공");
		} else {
			log.info("-----------------------------------------------------------------------------");
			log.info("실패");
		}
	}
	
	
	//테스트 검증
	@Test
	public void Testss() {
		PhoneCertVO vo = new PhoneCertVO();
		vo.setPhone_no("01048121565");
		vo.setToken("123456");
		serviceP.phoneCertInsert(vo);
	}
	
	@Test
	public void Testss2() {
		PhoneCertVO vo = serviceP.phoneCertHistoryNumber("01048121565");
		String s = SHA256Util.getEncrypt("123456", vo.getSalt());
		
		if(s.equals(vo.getToken())) {
			log.info("------------------------------------------------------------------");
			log.info("아주 기냥 판박이네!");
		}
		
	}
	
	@Test
	public void Testss3() {
		int s = serviceP.phoneCertHistoryCount("01048121565");
		
		if(s > 2) {
			log.info("------------------------------------------------------------------");
			log.info("금일 인증 횟수 초과입니다!!");
		}
	}
	
}









