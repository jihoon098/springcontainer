package kr.co.itcen.springcontainer.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import kr.co.itcen.springcontainer.user.User;

public class ContainerTest {

	public static void main(String[] args) {
		
		//testBeanFactory();
		
		testApplicationContext();
	}
	
	public static void testApplicationContext() {
		//ApplicationContext는 인터페이스.		//xml만 인식가능...그래서 java config를 하려면 다른컨테이러를 사용해야한다.
		ApplicationContext appCtxt = new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");
		//error: 같은 타입의 빈이 1개 이상 있는경우
		//		 타입으로 가져오면 예외 발생.
		//User user = appCtxt.getBean(User.class);
		
		//id로 가져오기
		//id로 명시했기때문에 getBean이 어떤 형태인지 모름. 따라서 캐스티을 해줘야힘.
		User user1 = (User)appCtxt.getBean("user1");
		System.out.println(user1);
		
		//name으로 가져오기. 
		User usr2 = (User)appCtxt.getBean("usr2");
		System.out.println(usr2);
		
		// singleton 확인
		User user2 = (User)appCtxt.getBean("user2");
		System.out.println(usr2 == user2);
		
		// User(Long, String) 으로 생성된 빈 가져오기
		User user3 = (User)appCtxt.getBean("user3");
		System.out.println(user3);
		
		// User() 으로 생성되고 프로퍼티 세팅을 한(setter) 빈 가져오기
		User user4 = (User)appCtxt.getBean( "user4" );
		System.out.println(user4);
		
		// DI 설정한 빈 가져오기
		User user5 = (User)appCtxt.getBean( "user5" );
		System.out.println(user5);
		
		// DI 설정한 빈 가져오기2
		User user6 = (User)appCtxt.getBean( "user6" );
		System.out.println(user6);
		
		
		
		((ConfigurableApplicationContext)appCtxt).close();
	}
	

	//어플리케이션 어디서든지 Spring Container(ApplicationContext) 가져오는법
	//WebApplicationContextUtils.getWebApplicationContext(sc) 여기서 sc는 servlet context임
	//ApplicationContext appCtxt = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
	//UserService userService = appCtxt.getBean(UserService.class);
	
	
	public static void testBeanFactory() {
		//bean설정 기반
		BeanFactory bf1 = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext01.xml"));
		User user1 = bf1.getBean(User.class);
		
		System.out.println(user1);
		
		//컨테이너를 또 생성 .  어노테이션기반
		//config소스폴더 . 소스폴더 밑에는 패키지
		BeanFactory bf2 = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext02.xml"));
		User user2 = bf2.getBean(User.class);
		
		System.out.println(user2);
		
	}
	
}
