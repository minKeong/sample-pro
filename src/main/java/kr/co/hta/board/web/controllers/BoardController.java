package kr.co.hta.board.web.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.hta.board.annotation.LoginUser;
import kr.co.hta.board.service.BoardService;
import kr.co.hta.board.service.UserService;
import kr.co.hta.board.vo.Board;
import kr.co.hta.board.vo.User;
import kr.co.hta.board.web.form.BoardForm;
import kr.co.hta.board.web.views.DownloadView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private String directory = "c:/upload/formfile";

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DownloadView downloadView;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards", boards);
		
		return "board/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam("no") int boardNo, Model model) {
		model.addAttribute("board", boardService.getBoardDetail(boardNo));
		
		return "board/detail.jsp";
	}
	/*
	@RequestMapping("/del.do")
	public String delete(@RequestParam("no") int boardNo, HttpSession session) {
		// 파라미터에서 no를 찾아서 int boardNo에 넣어줘
		// 변수 이름과 파라미터 이름을 다르게 하고 싶을 때 사용한다
		
		// url을 통해 타인의 게시글을 삭제할수도 있기 때문에 아래와 같은 코드를 작성한다
		User loginUser = (User) session.getAttribute("LOGIN_USER");
		boardService.deleteBoard(boardNo, loginUser.getId());
		
		return "redirect:/board/list.do";
	}
	*/
	@RequestMapping("/del.do")
	public String delete(@RequestParam("no") int boardNo, @LoginUser User user) {
		boardService.deleteBoard(boardNo, user.getId());
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("/form.do")
	public String form() {
		return "board/form.jsp";
	}
	/*
	@RequestMapping("/add.do")
	public String add(BoardForm boardForm, HttpSession session) throws Exception {
		
		User user = (User) session.getAttribute("LOGIN_USER");
		
		Board board = new Board();
		board.setTitle(boardForm.getTitle());
		board.setContents(boardForm.getContents());
		board.setNick(user.getId());
		
		MultipartFile upfile = boardForm.getUpfile();
		// upfile이 비어있지 않은 경우에만 파일 이름을 board의 filename에 담는다
		if (!upfile.isEmpty()) {
			String filename = upfile.getOriginalFilename();
			board.setFilename(filename);
			
			FileCopyUtils.copy(upfile.getBytes(), new File(directory, filename));
		}
		boardService.addNewBoard(board);
		
		return "redirect:/board/list.do";
	}
	*/
	@RequestMapping("/add.do")
	public String add(BoardForm boardForm, @LoginUser User user) throws Exception {
		
		System.out.println(boardForm);
		
		Board board = new Board();
		board.setTitle(boardForm.getTitle());
		board.setContents(boardForm.getContents());
		board.setNick(user.getId());
		
		MultipartFile upfile = boardForm.getUpfile();
		// upfile이 비어있지 않은 경우에만 파일 이름을 board의 filename에 담는다
		if (!upfile.isEmpty()) {
			String filename = upfile.getOriginalFilename();
			board.setFilename(filename);
			
			FileCopyUtils.copy(upfile.getBytes(), new File(directory, filename));
		}
		boardService.addNewBoard(board);
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("/down.do")
	public ModelAndView download(@RequestParam("no") int boardNo) {
		ModelAndView mav = new ModelAndView();
		
		Board board = boardService.getBoardDetail(boardNo);
		mav.addObject("directory", directory);
		mav.addObject("filename", board.getFilename());
		mav.setView(downloadView);
		
		return mav;
	}
}
