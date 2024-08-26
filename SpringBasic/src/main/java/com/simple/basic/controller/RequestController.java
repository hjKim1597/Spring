package com.simple.basic.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.MemberVO;

@Controller
@RequestMapping("/request") //이 컨트롤러 모든 요청 결로 앞에 /request를 붙일것임
public class RequestController {

	// void 형은 들어온 요청 경로가 , 나가는 경로가 됩니다 (화면경로)
//	@RequestMapping("/req_ex01")
//	public void ex01() {
//	}
	
	@RequestMapping("/req_ex01")
	public String ex01() {
		
		return "request/req_ex01"; //화면경로
	}
	
	
	//@RequestMapping(value = "/basic", method = RequestMethod.GET) // (옵션=값) // get만 허용함
	//@RequestMapping(value = "/basic", method = RequestMethod.POST) // post만 허용함
 	//@RequestMapping("/basic") // get, post 둘다 허용함
	
	@RequestMapping({"/basic", "/basic2"}) // 중괄호로 요청 여러개를 하나로 묶음
	public String basic() {
		
		System.out.println("basic요청 실행됨");
		
		return null;
	}
	
	//@GetMapping("/basic3") // 리퀘스트 맵핑 + get만 허용
	@PostMapping("/basic3") // 리퀘슽 맵핑 + post만 허용
	public String basic3() {
		System.out.println("basic3요청 실행됨");
		return null;
	}
	//////////////////////////////////////////////////////////////////////

	//ex02화면요청 경로
	@RequestMapping("/req_ex02")
	public String ex02() {
		return "request/req_ex02";
	}
	
	
	//리퀘스트 객체로 값 받기
//	@RequestMapping(value = "/param", method = RequestMethod.POST)
//	public String param(HttpServletRequest request) {
//		
//		System.out.println( request.getParameter("id") );
//		System.out.println( request.getParameter("pw") );
//		System.out.println( request.getParameterValues("inter") );
//		
//		
//		//잘~~~~ 처리해서~~
//		//결과화면
//		return "request/req_ex02_ok";
//	}
	
	
	//@RequsetParam방식 - 반드시 값을 화면에서 넘겨야 함 (필수)
	//required = false 는 값이 없더라도 오류페이지가 나오지 않고 통과하게 됩니다 기본이 true이기 때문
	//defaultValue 는 값이 없을 때 기본값을 지정할 수 있음
//	@RequestMapping(value = "/param", method = RequestMethod.POST)
//	public String param(@RequestParam("id") String x,  //@RequestParam("인풋태그의 name") 
//						@RequestParam("pw") String y,
//						@RequestParam(value = "inter", required = false, defaultValue = "") ArrayList<String> list) {//id값을 받아 변수 x에 맵핑함
//						//리퀘스트 파람은 무조건 값이 있어야함 없으면 400오류
//						
//		
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(list);
//		
//		//잘~~~~ 처리해서~~
//		//결과화면
//		return "request/req_ex02_ok";
//	}
	
	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param( MemberVO vo) { //MemberVO 값들 맵핑
					
	System.out.println(vo.toString());
						

		//잘~~~~ 처리해서~~
		//결과화면
		return "request/req_ex02_ok";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
