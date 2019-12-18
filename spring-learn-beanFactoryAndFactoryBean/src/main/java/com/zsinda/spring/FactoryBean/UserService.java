package com.zsinda.spring.FactoryBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class UserService implements BeanPostProcessor, BeanFactoryPostProcessor {

//	String msg="test";


//	@Override
//	public Object getObject() throws Exception {
//		return new UserService2();
//	}
//
//	@Override
//	public Class<?> getObjectType() {
//		return null;
//	}
//
//	@Override
//	public boolean isSingleton() {
//		return false;
//	}
//
//	public String getMsg() {
//		return msg;
//	}

	/*
	*
	* BeanFactoryPostProcessor 是从bean工厂角度来对bean对一个自定义
	* 	BeanPostProcessor  bean级别的处理，针对某个具体的bean进行处理
	*
	* 执行顺序是 BeanFactoryPostProcessor.postProcessBeanFactory()
	*          BeanPostProcessor.postProcessBeforeInitialization()
	* 			BeanPostProcessor.postProcessAfterInitialization()
	* */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("userService2")){
			System.out.println("BeanPostProcessor  postProcessBeforeInitialization                     1");

		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("userService2")) {
			System.out.println("BeanPostProcessor  postProcessAfterInitialization                    2");
		}
		return null;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService2");
		if (beanDefinition!=null){
		System.out.println("BeanFactoryPostProcessor  postProcessBeanFactory                   3");
		 }
	}
}
