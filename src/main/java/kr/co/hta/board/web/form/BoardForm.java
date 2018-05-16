package kr.co.hta.board.web.form;

import org.springframework.web.multipart.MultipartFile;

public class BoardForm {

	private int no;
	private String title;
	private String contents;
	// filename이라고 하면 파일 객체가 String객체로 들어가려고 하기 때문에
	// Board에 있는 filename과 이름을 다르게 해야 한다
	private MultipartFile upfile;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public MultipartFile getUpfile() {
		return upfile;
	}
	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	
	@Override
	public String toString() {
		return "BoardForm [no=" + no + ", title=" + title + ", contents=" + contents + ", upfile=" + upfile + "]";
	}
}
