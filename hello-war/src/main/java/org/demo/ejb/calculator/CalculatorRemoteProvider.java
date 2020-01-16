package org.demo.ejb.calculator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CalculatorRemoteProvider {
	
//	// EJB URI from JBoss console : NOT OK
//	public static final String NAME1 = 		     
//	"java:global/calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/calculator!org.demo.ejb.calculator.CalculatorRemote";
//	// If no "name" in EJB annotation use implementation class instead
//	//		"java:global/calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";
//	
//	// EJB URI from JBoss console : OK (works fine)
//	public static final String NAME2 = 
//	"java:jboss/exported/calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/calculator!org.demo.ejb.calculator.CalculatorRemote";
		
	public static final String MAPPED_NAME = "calculator"; // ERROR
	// Deployment error : "the required services are not installed" 

public static final String CALCULATOR_NAME1 = // 
            "calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";

public static final String CALCULATOR_NAME2 = //
        "ejb:calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";

public static final String CALCULATOR_NAME3 = // 
// syntax : "ejb:appName/moduleName/distinctName/beanName!viewClassName
        "ejb:calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT//CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";

public static final String CALCULATOR_NAME4 = // NOT OK
"java:jboss/exported/calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote";


	/*
	 * see 
	 * https://blog.akquinet.de/2014/09/26/jboss-eap-wildfly-three-ways-to-invoke-remote-ejbs/
	 * https://docs.jboss.org/author/display/AS71/JNDI+Reference
	 * 
	 * Exemple RGCU
	 * 
public static final String NOM_JNDI_EJB_OTN_31 = 
"java:global/conversion-otn-alimscds-ear-1.0.2/conversion-otn-alimscds-otn31-ejb-1.0.2/AppelOTN31Impl!cnav.rgcu.conversion.otn.alimscds.interfaces.AppelOTN31"; 

	 * 
	 */
	
	private CalculatorRemoteProvider() {		
	}
	
	public static CalculatorRemote lookup() throws Exception {
		try {
			Context initialContext = new InitialContext();
			// Object o = initialContext.lookup(MAPPED_NAME); // ERROR
			Object o = initialContext.lookup(CALCULATOR_NAME1); // 
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
