package com.zsinda.spring.service;


import org.springframework.stereotype.Service;

@Service
public class Test {

	public Test() {
		System.out.println("Constructor init");
	}

	public void query() {
		System.out.println("query method");
	}
}
