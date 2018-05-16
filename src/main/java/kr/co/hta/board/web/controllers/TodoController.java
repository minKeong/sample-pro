package kr.co.hta.board.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.hta.board.service.TodoService;
import kr.co.hta.board.vo.Todo;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	// path : 
	@RequestMapping(value="/todo/", method=RequestMethod.GET)
	@ResponseBody
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}
	
	// @PathVariable : rest 형태로 값을 전달하고 받은 후 원하는 데이터를 얻기 위해서 사용한다
	// localhost/todo/23
	// localhost/type/pc/no/23
	// RequestMapping("type/{a}/no/{b}")
	// public String xx(@PathVariable("a") String x, @PathVariable("b") int y)
	@RequestMapping(value="/todo/{no}", method=RequestMethod.GET)
	@ResponseBody
	public Todo getTodo(@PathVariable("no") int no) {
		return todoService.getTodo(no);
	}
	
	@RequestMapping(value="/todo/{no}", method=RequestMethod.DELETE)
	@ResponseBody
	public Todo deleteTodo(@PathVariable("no") int no) {
		return todoService.deleteTodo(no);
	}
	
	@RequestMapping(value="/todo/", method=RequestMethod.POST)
	@ResponseBody
	public Todo addTodo(@RequestBody Todo todo) {
		Todo newTodo = todoService.addTodo(todo);
		return newTodo;
	}
	
}
