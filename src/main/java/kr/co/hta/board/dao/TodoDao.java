package kr.co.hta.board.dao;

import java.util.List;

import kr.co.hta.board.vo.Todo;

public interface TodoDao {

	List<Todo> getAllTodos();
	Todo getTodo(int no);
	void addTodo(Todo todo);
	void updateTodo(Todo todo);
	void deleteTodo(int no);
	
	int getSeq();
}
