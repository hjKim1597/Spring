package ex05.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex01.SpringTest;
import ex02.constructor.Chef;
import ex02.constructor.Hotel;
import ex02.setter.MemberDAO;
import ex02.setter.MyDataSource;

@Configuration // 자바 설정파일로 쓸 클래스
public class JavaConfig {

	// <bean id="test" class="ex01.SpringTest" scope="prototype"/>
	@Bean
	public SpringTest test() {
		return new SpringTest();
	}

	// <bean id="chef" class="ex02.constructor.Chef"/>
	@Bean
	public Chef chef() {
		return new Chef();
	}

	// <bean id="hotel" class="ex02.constructor.Hotel"/>
	@Bean
	public Hotel hotel() {
		return new Hotel(chef());
	}

//	<bean id="ds" class="ex02.setter.MyDataSource">
//		<property name="url" value="jdbc:oracle:thin@localhost~~"/> <!-- name="set명" value="값" -->
//		<property name="uid" value="jsp"/> <!-- name="set명" value="값" -->
//		<property name="upw" value="jsp"/> <!-- name="set명" value="값" -->
//	</bean>
	@Bean
	public MyDataSource ds() {

		MyDataSource ds = new MyDataSource();
		ds.setUrl("jdbc:oracle:thin@localhost~~");
		ds.setUid("jsp");
		ds.setUpw("jsp");
		return ds;
	}

//	<bean id="memberDAO" class="ex02.setter.MemberDAO">
//		<property name="myDataSource" ref="ds" /> <!-- 의존성 주입 -->
//	</bean>
	@Bean
	public MemberDAO memberDAO() {
		MemberDAO memberDAO = new MemberDAO();

		memberDAO.setMyDataSource(ds());
		return memberDAO;
	}
}
