package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.QuizVO;

//quiz01화면 요청
@Controller
@RequestMapping("/quiz")
public class QuizController {

	//화면 요청
	@RequestMapping("/quiz01")
	public String quizView() {
		
		return "quiz/quiz01";	
	}
	//RequestParam으로 값을 받아서 바로 출력하는 방법1	
//	@RequestMapping("/join")
//	public String join( Model model,
//			
//					   @RequestParam("id") String id,
//					   @RequestParam("pw") String pw,
//					   @RequestParam("name") String name,
//					   @RequestParam("email") String email	) {
//					   
//		 model.addAttribute("id", id);
//		 model.addAttribute("pw", pw);		  
//		 model.addAttribute("name", name);		   
//		 model.addAttribute("email", email);
//		
//		return "quiz/quiz01_ok";
//	}

	
//VO에 값 설정후 ModelAttribute로 불러오는 방법2
	
	//폼요청
		@RequestMapping("/join")
		public String join(@ModelAttribute("vo") QuizVO vo){

			return "quiz/quiz01_ok";		
		}	
	
/////////////////////////////////////////////////////////////////////////////////
//quiz02
	
	
	//quiz02화면 요청
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
//RequestParam으로 값을 받아서 바로 출력하는 방법1
//	@RequestMapping("/birthForm")
//	public String birthForm(Model model,
//							@RequestParam("year") String year,
//							@RequestParam("month") String month,
//							@RequestParam("day") String day,
//							@RequestParam("msg") String msg ) {
//			model.addAttribute("year", year);
//			model.addAttribute("month", month);
//			model.addAttribute("day", day);
//			model.addAttribute("msg", msg);
//			
//			
//		
//		return "quiz/result";
//	}

//redirect로 하는 방법2
	
	//result화면 요청
	@RequestMapping("/result") 
	public String result() {
		return "quiz/result";
	}
	
	//폼요청
	@RequestMapping("/birthForm")
	public String birthForm(@RequestParam("year") String year,
							@RequestParam("month") String month,
							@RequestParam("day") String day,
							@RequestParam("msg") String msg,
							RedirectAttributes ra
			) {
			
		String str = year + "-" + month + "-" + day + "-" + msg;
		ra.addFlashAttribute("msg", str); //리다이렉트 시에 1번 사용가능		
		return "redirect:/quiz/result"; //다시 컨트롤러를 태움
	}
	
}
