package org.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.ejb.calculator.CalculatorRemote;

/**
 * Servlet
 */
@WebServlet(urlPatterns = "/count")
public class CountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

//	@EJB(name="calculator") // The logical name of the ejb reference within the declaring component's (e.g., java:comp/env) environment
	
	//@EJB(lookup = "ejb:earname/modulename/BeanClass!fully.qualified.RemoteInterface")
//	@EJB(lookup="ejb:calculator-ear-0.0.1-SNAPSHOT/calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote")
	
	// ==============================
	// ---- OK -----
	//@EJB(lookup = "ejb:earname/modulename/BeanClass-or-Name!fully.qualified.RemoteInterface")
	//@EJB(lookup="ejb:calculator-ear-0.0.1-SNAPSHOT/calculator-jar-ejb-0.0.1-SNAPSHOT/calculator!org.demo.ejb.calculator.CalculatorRemote")
//	@EJB(lookup="ejb:calculator-ear-0.0.1-SNAPSHOT/calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote")
	
	// URI from JBoss console ( Runtime -> Subsystem -> JNDI View : JNDI Bindings -> "java:global" )
	@EJB(lookup="java:global/calculator-ear/org.demo-calculator-jar-ejb-0.0.1-SNAPSHOT/calculator!org.demo.ejb.calculator.CalculatorRemote")
	
	// With specific EAR name :  "calculator-ear" (set in application.xml)
	//@EJB(lookup="ejb:calculator-ear/calculator-jar-ejb-0.0.1-SNAPSHOT/calculator!org.demo.ejb.calculator.CalculatorRemote")
	
	// @EJB(name="calculator")  // EJB NOT FOUND
	// @EJB(lookup="ejb:calculator") // Can not set org.demo.ejb.calculator.CalculatorRemote field
	// @EJB(lookup="ejb:calculator-jar-ejb-0.0.1-SNAPSHOT/calculator!org.demo.ejb.calculator.CalculatorRemote") // ERR
	// @EJB(lookup="ejb:calculator-ear-0.0.1-SNAPSHOT/calculator-jar-ejb-0.0.1-SNAPSHOT/calculator") // ERR
	// ==============================
	
	//@EJB // @EJB can only inject "EJB" ( @Inject can inject any bean )
	//@EJB(mappedName="ejb:calculator-ear-0.0.1-SNAPSHOT/calculator-jar-ejb-0.0.1-SNAPSHOT/${DEPLOYMENT_DISTINCT_NAME}/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote")
//	@EJB(mappedName="ejb:calculator-ear-0.0.1-SNAPSHOT/calculator-jar-ejb-0.0.1-SNAPSHOT/CalculatorImpl!org.demo.ejb.calculator.CalculatorRemote")
	private CalculatorRemote calculator;
	// Test 1 (Local Interface) :
	// Just add dependency in pom.xml (EJB not embedded in EAR)
	// ==> Deployment ERROR : ClassNotFoundException: org.demo.ejb.calculator.CalculatorLocal
	//
	// Test 2 (Local Interface) : 
	// Add EJB Local interface in EJB-JAR
	// ==> Deployment ERROR : No EJB found for interface "org.demo.ejb.calculator.CalculatorLocal"
	//
	// Test 3 (Remote Interface) : 
	// Add EJB Remote interface in EJB-JAR
	// ==> Deployment ERROR : No EJB found for interface "org.demo.ejb.calculator.CalculatorRemote"
	//
	// Test 4 (Remote Interface) : 
	// Add EJB Remote interface in WAR
	// ==> Deployment ERROR : No EJB found for interface "org.demo.ejb.calculator.CalculatorRemote"

	//-------------------------------------------------------------------------
	// (Remote Interface + dependency to calculator-jar-ejb in pom.xml) 
	// ==> Deployment ERROR : ClassNotFoundException: "CalculatorRemote"
	//-------------------------------------------------------------------------
	// (Remote Interface in current WAR project) 
	// ==> Deployment ERROR : No EJB found for interface "org.demo.ejb.calculator.CalculatorRemote"
	//-------------------------------------------------------------------------
	// (Remote Interface in current WAR project with exactly same package) 
	// ==> Deployment ERROR : No EJB found for interface "org.demo.ejb.calculator.CalculatorRemote"
	
	/**
	 * Default constructor.
	 */
	public CountServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		long r = calculator.getCallCounter();
		out.append("Call counter = " + r);
	}

}
