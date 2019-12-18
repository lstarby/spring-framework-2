package com.zsinda.spring.service;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

@Service
public class Test implements BeanFactoryPostProcessor, BeanPostProcessor {

	public Test() {
		System.out.println("Constructor init");
	}

	public void query() {
		System.out.println("query method");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
