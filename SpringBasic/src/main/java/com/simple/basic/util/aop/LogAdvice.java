package com.simple.basic.util.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //AOP클래스
@Component //이 클래스는 component-scan에 읽혀서 bean으로 생성됨
public class LogAdvice {
	
	//해당 클래스를 로그를 사용함 (base 패키지 밑에 존재해야 사용합니다)
	public static final Logger log = LoggerFactory.getLogger(LogAdvice.class);
	
	//advice - 공통기능
	//point cut - 내가 적용할 메서드에 advice 부착하는 행위
	//맨앞 *는 모든 접근제어자에
	//맨마지막 *(..) 모든 메서드에
//	@Before("execution(* com.simple.basic.controller.*Controller.*(..))")
	//@Before("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public void beforeLog() {
		System.out.println("---메서드 실행전 동작---");

	}
	//@After("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public void afterLog() {
		System.out.println("---메서드 실행후 동작---");
		
	}
	
	//@AfterThrowing(pointcut = "execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))",
	//			   throwing= "e" //에러를 처리할 변수명
	//			  )
	public void exceptionLog(Exception e) {
		System.out.println("advice 에러로그: " + e);
		
	}
	
	//@Around - after, before, afterThrowing 세가지를 결합해서 처리할 수 있게 해주는 어노테이션
	//규칙 - 반환은 object로 만들고, 매개변수로 실행변수로 실행시점을 결정지어줄수 있는 ProceedingJoinPoint를 선언함
	//@Around("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public Object arroundLog(ProceedingJoinPoint jp) {
		
		/*
		 메서드로 넘어오는 매개변수 확인가능
		 메서드 실행되는 target 확인가능
		 이런 결과를 수집해서, 전체 log로 찍어주거나 FileOutPut을 이용해서 실행로그 출력을 해줄 수 있음
		*/
		
		long start = System.currentTimeMillis();
	
//		log.info("실행클래스: " + jp.getTarget() );
//		log.info("실행메서드: "+ jp.getSignature().toString() );
//		log.info("매개값: "+ Arrays.toString(jp.getArgs() ) );
		
		Object result = null;
		
		try {
			
			//before
			result = jp.proceed(); //타겟 메서드의 실행
			//after
			
			long end = System.currentTimeMillis();
			
			//log.info("실행시간: " + (end - start) * 0.001 );
			
			String path = "C:\\Users\\user\\Desktop\\course\\Spring\\spring_log\\오늘날짜_log.txt";
			BufferedWriter bos = new BufferedWriter(new FileWriter(path, true));
			bos.write("실행클래스:" + jp.getTarget() + "\n"); //파일을 씀
			bos.write("실행메서드: "+ jp.getSignature().toString() + "\n");
			bos.write("매개값: "+ Arrays.toString(jp.getArgs() ) + "\n" );
			bos.write("실행시간: " + (end - start) * 0.001 + "\n" );
			bos.flush();
			
			bos.close();
			
			
		} catch (Throwable e) {
			e.printStackTrace(); // 해당 메서드에서 에러가 발생하면, 이친구가 로그를 같이 찍음
		}
		
		
		return result; // result를 반환해야 메서드의 정상 흐름으로 돌아감
		
		
	}
}
