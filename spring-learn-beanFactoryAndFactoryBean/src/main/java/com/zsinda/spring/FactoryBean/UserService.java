package com.zsinda.spring.FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UserService implements FactoryBean {

	String msg="test";


	@Override
	public Object getObject() throws Exception {
		return new UserService2();
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public String getMsg() {
		return msg;
	}
}
