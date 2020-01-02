package org.demo.ejb.hello.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.demo.ejb.hello.HelloLocal;

@Singleton // EJB 3.1
@Startup // EJB 3.1
public class HelloImpl implements HelloLocal {

	private long callCounter = 0;
	
	/**
	 * Constructor.
	 * The class must have a default public constructor.
	 */
	public HelloImpl() {
		super();
	}

	@PostConstruct
	void init() {
		callCounter = 0;
	}

	@Override
	public long getCallCounter() {
		return callCounter;
	}
	
	@Override
	public String hello(String name) {
		callCounter++;
		return ("Hello " + name);
	}

}
