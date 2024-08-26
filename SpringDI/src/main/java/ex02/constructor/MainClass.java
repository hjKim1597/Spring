package ex02.constructor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		// 자바문법
//	Hotel hotel = new Hotel(new Chef() );
//	hotel.getChef().cooking();

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");

		ctx.getBean("hotel", Hotel.class); // hotel 이름의 Hotel 클래스를 찾아줘

		Hotel hotel = ctx.getBean("hotel", Hotel.class);
		hotel.getChef().cooking();
		
		
	}
}