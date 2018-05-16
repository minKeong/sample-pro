package kr.co.hta.board.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)		// 매개변수에 붙일 수 있는 어노테이션
//@Target(ElementType.TYPE)			// 클래스에 붙일 수 있는 어노테이션
//@Target(ElementType.CONSTRUCTOR)	// 생성자에 붙일 수 있는 어노테이션
//@Target(ElementType.FIELD)			// 변수에 붙일 수 있는 어노테이션
//@Target(ElementType.METHOD)			// 메소드에 붙일 수 있는 어노테이션
// 어노테이션이 어떤 시점에 해석되냐
@Retention(RetentionPolicy.RUNTIME)		// 프로그램이 실행될 때 이 어노테이션이 실행되게 하겠다
@Documented								// 문서에 어노테이션 정보가 표시되게 한다
public @interface LoginUser {

}


