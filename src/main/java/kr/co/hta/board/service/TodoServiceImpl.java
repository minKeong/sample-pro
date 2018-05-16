package kr.co.hta.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hta.board.dao.TodoDao;
import kr.co.hta.board.vo.Todo;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoDao todoDao;
	
	@Override
	public List<Todo> getAllTodos() {
		return todoDao.getAllTodos();
	}
	
	@Override
	public Todo getTodo(int no) {
		return todoDao.getTodo(no);
	}
	
	@Override
	public Todo deleteTodo(int no) {
		Todo todo = todoDao.getTodo(no);
		todoDao.deleteTodo(no);
		return todo;
	}
	
	@Override
	public Todo addTodo(Todo todo) {
		int no = todoDao.getSeq();
		todo.setNo(no);
		
		todoDao.addTodo(todo);
		
		return todo;
	}
}
