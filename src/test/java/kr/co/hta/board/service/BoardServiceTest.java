package kr.co.hta.board.service;

import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import kr.co.hta.board.vo.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/META-INF/spring/test-root-context.xml")
@Transactional
public class BoardServiceTest {

	@Autowired
	BoardService boardService;
	
	@Test
	public void testConfig() {
		assertThat(boardService, notNullValue());
	}
	
	@Test
	public void testGetAllBoards() {
		List<Board> boards = boardService.getAllBoards();
		assertThat(boards.size(), is(7));
	}
	
	@Test
	public void testGetBoardDetail() {
		Board board = boardService.getBoardDetail(2);
		assertThat(board, notNullValue());
	}
	
}


