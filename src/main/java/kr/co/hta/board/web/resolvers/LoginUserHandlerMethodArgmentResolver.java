package kr.co.hta.board.web.resolvers;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import kr.co.hta.board.annotation.LoginUser;
import kr.co.hta.board.vo.User;

// 핸들러 메소드의 매개변수를 해석하는 놈
public class LoginUserHandlerMethodArgmentResolver implements HandlerMethodArgumentResolver {

	// 매개변수리졸브를 적용할 수 있는 대상인지 검사하는 역할을 수행한다
	public boolean supportsParameter(MethodParameter parameter) {
		// 로그인 유저가 부착된 파라미터를 갖고있을때만 아래의 리졸브 메소드가 실행된다
		return parameter.hasParameterAnnotation(LoginUser.class);
	}
	
	// supportsParameter()이 true를 반환할 때 실행되는 메소드다
	// resolveArgument() 메소드가 반환하는 객체가 그 매개변수로 전달된다
	// 세션에 있는 로그인 유저를 @LoginUser 어노테이션을 통해서 전달한다
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		return (User) webRequest.getAttribute("LOGIN_USER", NativeWebRequest.SCOPE_SESSION);
	}
	
}
