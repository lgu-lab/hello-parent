package org.demo.ejb.hello;

import javax.ejb.Local;

@Local  // EJB 3.0
public interface HelloLocal {
	
	public String hello(String name);
    
    public long getCallCounter();
}
