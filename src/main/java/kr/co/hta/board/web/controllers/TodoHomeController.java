package kr.co.hta.board.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoHomeController {

	@RequestMapping("/todoHome")
	public String home() {
		return "todo.html";
	}
}
