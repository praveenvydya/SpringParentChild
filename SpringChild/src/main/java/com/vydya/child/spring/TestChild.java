package com.vydya.child.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

//@Configurable

@Component
public class TestChild {

	
	public String testRun() {
		
		return "test Run is successful";
	}
	
	public TestChild() {
		super();
		System.out.println("TestChild created");
		// TODO Auto-generated constructor stub
	}

	static {
		System.out.println("TestChild static");
	}
}
