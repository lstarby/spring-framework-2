package com.zsinda.spring;


import com.zsinda.spring.service.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com")
public class Ioc {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Ioc.class);
		Test bean = (Test) annotationConfigApplicationContext.getBean("test");
		bean.query();

	}
}
