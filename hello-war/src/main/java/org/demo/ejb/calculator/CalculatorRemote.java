package org.demo.ejb.calculator;

import javax.ejb.Remote;

@Remote  // EJB 3.0
public interface CalculatorRemote {
	
	public long add(long i, long j);
    public long subtract(long i, long j);
    public long multiply(long i, long j);
    public double divide(long i, long j);
    
    public long getCallCounter();
}
