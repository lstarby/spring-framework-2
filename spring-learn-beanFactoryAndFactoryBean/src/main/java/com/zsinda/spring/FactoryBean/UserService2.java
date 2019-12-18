package com.zsinda.spring.FactoryBean;


import org.springframework.stereotype.Component;

@Component("userService2")
public class UserService2 {


	public void query(){
		System.out.println("UserService2");
	}

}
