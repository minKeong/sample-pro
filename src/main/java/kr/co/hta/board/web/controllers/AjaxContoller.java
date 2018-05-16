package kr.co.hta.board.web.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.hta.board.service.BookService;
import kr.co.hta.board.vo.Book;
import kr.co.hta.board.vo.Criteria;
import kr.co.hta.board.vo.User;

@Controller
@RequestMapping("/ajax")
public class AjaxContoller {

	@RequestMapping("/user.do")
	public @ResponseBody User getUser() {
		User user = new User();
		user.setId("hong");
		user.setPwd("zxcv1234");
		user.setName("홍길동");
		
		return user;
	}

	@RequestMapping("/user2.do")
	@ResponseBody
	public User getUser2() {
		User user = new User();
		user.setId("hong");
		user.setPwd("zxcv1234");
		user.setName("홍길동");
		
		return user;
	}
	
	@RequestMapping("/user3.do")
	public ResponseEntity<User> getUser3() {
		User user = new User();
		user.setId("hong");
		user.setPwd("zxcv1234");
		user.setName("홍길동");
		
		// HttpStatus.OK : 200코드가 내려감
		// 응답 데이터가 있는 경우
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping("/user4.do")
	public ResponseEntity<User> getUser4() {
		
		// HttpStatus.NO_CONTENT : 뭐가 없다..!!
		// 응답 데이터가 없는 경우
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping("/user5.do")
	public @ResponseBody Map<String, Object> getUser5() {
		Map<String, Object> map = new HashMap<>();
		
		User user = new User();
		user.setId("hong");
		user.setPwd("zxcv1234");
		user.setName("홍길동");
		
		if (user != null) {
			map.put("success", true);
			map.put("items", Arrays.asList(user));
		} else {
			map.put("success", false);
		}
		
		return map;
	}
	
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/search.do")
	public @ResponseBody Map<String, Object> search(Criteria c) {
		Map<String, Object> map = new HashMap<>();
		
		List<Book> books = bookService.searchBooks(c);
		if (books.isEmpty()) {
			map.put("success", false);
		} else {
			map.put("success", true);
			map.put("items", books);
		}
		
		return map;
	}
}
