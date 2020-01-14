package org.demo.ejb.calculator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CalculatorRemoteProvider {
	
	// OK (works fine)
	public static final String NAME = 
		"java:global/calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/calculator!org.demo.ejb.calculator.CalculatorRemote";
	
	private CalculatorRemoteProvider() {		
	}
	
	public static CalculatorRemote lookup() throws Exception {
		try {
			Context initialContext = new InitialContext();
			Object o = initialContext.lookup(NAME);
			if (o instanceof CalculatorRemote) {
				return (CalculatorRemote) o;
			}
			else {
				throw new Exception("Object provided is not a 'CalculatorRemote' interface");
			}
		} catch (NamingException e) {
			throw new Exception("NamingException", e);
		}		
	}

}
