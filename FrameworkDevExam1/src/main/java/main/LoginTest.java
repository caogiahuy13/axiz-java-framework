package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.service.impl.MockProductService;

public class LoginTest {
	private static final String BEANS_XML = "beans.xml";

	public static void main(String[] args) {
		final ApplicationContext appContext = new ClassPathXmlApplicationContext(BEANS_XML);
		final MockProductService mockProductService = appContext.getBean(MockProductService.class);

		System.out.println(mockProductService.find());
	}
}
