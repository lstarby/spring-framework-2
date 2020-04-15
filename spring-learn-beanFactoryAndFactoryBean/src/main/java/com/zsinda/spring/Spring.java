package com.zsinda.spring;


import com.zsinda.spring.FactoryBean.UserService;
import com.zsinda.spring.FactoryBean.UserService2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com")
public class Spring {

	public static void main(String[] args) {
		/*
		 * BeanFactory 顾名思义是一个bean工厂，它本身不是个bean。它能够产生对象，并且管理对象。由UML类图可以看出它是ioc容器顶级接口。
		 *	BeanFactory beanFactory = new AnnotationConfigApplicationContext(Spring.class);
		 */
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring.class);
//		BeanFactory beanFactory = new AnnotationConfigApplicationContext(Spring.class);
		/*
		 * FactoryBean
		 *
		 * UserService userService = (UserService) beanFactory.getBean("userService");       ----->  byName
		 * UserService userService = (UserService) beanFactory.getBean(UserService.class);   ----->  byType
		 * 异常栈：com.zsinda.spring.FactoryBean.UserService2 cannot be cast to com.zsinda.spring.FactoryBean.UserService
		 * 此处如果byType的话，是没有这个问题的，因为是byName，并且UserService实现了FactoryBean，如果是byName的话，是getObject()里返回的对象：UserService2
		 * 如果要在byName中返回UserService 本身 则需要加上 & 原因：
		 * >--org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean
		 *   >--  final String beanName = transformedBeanName(name); 此处做了检验
		 *     >--org.springframework.beans.factory.support.FactoryBeanRegistrySupport.doGetObjectFromFactoryBean 此处拿到FactoryBean ->getObject()
		 *
		 * FactoryBean 常常应用在一个bean对象，里面依赖了很多其他对象。经典例子SqlSessionFactoryBean
		 *
		 **/
//		UserService userService = (UserService) annotationConfigApplicationContext.getBean("&userService");
//		System.out.println(userService.getMsg());

		UserService2 userService2 = (UserService2) annotationConfigApplicationContext.getBean("UserService");
		userService2.query();
	}
}
