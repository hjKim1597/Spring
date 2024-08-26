package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		//자바방식
//		SpringTest test = new SpringTest();
//		test.hello();
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("application-context.xml");
		
		
		SpringTest test = ctx.getBean(SpringTest.class); // getbean은 ioc 컨테이너 박스에서 필요한 객체를 꺼낸다
		test.hello();
		
		SpringTest test2 = ctx.getBean(SpringTest.class); // 동일한객체가 반환 되어서 값은 같음 // 
		System.out.println(test == test2);
	}
}
