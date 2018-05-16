package kr.co.hta.board.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.User;

// RunWith : 테스트를 수행할 때 함께 시행할 헬퍼클래스를 지정하는 어노테이션
// ContextConfiguration : 경로에 있는 파일을 읽어서 spring-container를 하나 만든다
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/META-INF/spring/test-root-context.xml")
@Transactional
public class UserServiceTest {

	// 보통 beforeclass 단계에 이 명령을 시행시킨다
	@Autowired
	UserService userService;
	
	@Test
	public void testConfig() {
		// userService가 난 null이 아니라고 생각하고 있어 확인해줘
		assertThat(userService, notNullValue());
	}
	
	@Test
	public void testAddNewUser() {
		User user = new User();
		user.setId("pangee");
		user.setPwd("zxcv1234");
		user.setName("팡이");
		
		userService.addNewUser(user);
		User savedUser = userService.getUserDetail(user.getId());
		assertThat(savedUser, notNullValue());
	}
	
	// 일부러 똑같은걸 넣어보고 예외가 발생하는지 확인한다
	// 나는 이 명령을 수행했을 때 SimpleBoardException이 발생할 거라고 확신한다
	@Test(expected=SimpleBoardException.class)
	public void testDuplicateUserAdd() {
		User user = new User();
		user.setId("kong");
		user.setPwd("zxcv1234");
		user.setName("김민경");
		
		userService.addNewUser(user);
	}
}

