package org.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.ejb.calculator.CalculatorRemote;
import org.demo.ejb.calculator.CalculatorRemoteProvider;

/**
 * Servlet
 */
@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		CalculatorRemote calculator;
		try {
			calculator = CalculatorRemoteProvider.lookup();
		} catch (Exception e) {
			out.append("ERROR : Exception :  " + e);
			return;
		}
		
		long r = calculator.add(1, 2);
		out.append("add servlet --> remote calculator call : r = " + r);
	}

}
