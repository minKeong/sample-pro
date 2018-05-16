package kr.co.hta.board.web.interceptors;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor implements HandlerInterceptor {

	// app-context에서 정의한 로그인 없이도 접속을 허용할 uri가 들어있다
	private Set<String> urls;
	public void setUrls(Set<String> urls) {
		this.urls = urls;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 컨트롤러가 실행되기 전에 실행된다
		System.out.println("preHandle() 실행됨");
		
		// 요청한 url의 localhost를 뺀 나머지가 requestURI에 담긴다
		String requestURI = request.getRequestURI();
		// System.out.println(requestURI);
		
		if (urls.contains(requestURI)) {
			return true;
		}
		
		HttpSession session = request.getSession();
		if (session.getAttribute("LOGIN_USER") != null) {
			return true;
		}
		
		response.sendRedirect("/user/login.do?err=deny");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndview)
			throws Exception {
		// 컨트롤러가 실행된 후에 실행된다
		// System.out.println("postHandle() 실행됨");
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 컨트롤러 실행된 후에 항상 실행되며 자주 사용하지 않는다
		
	}

	
}
