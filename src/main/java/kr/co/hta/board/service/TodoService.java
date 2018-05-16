package kr.co.hta.board.service;

import java.util.List;

import kr.co.hta.board.vo.Todo;

public interface TodoService {

	List<Todo> getAllTodos();
	Todo getTodo(int no);
	// 삭제된 데이터가 뭔지 내려보내기 위해서 void로 안함
	Todo deleteTodo(int no);
	Todo addTodo(Todo todo);
}
