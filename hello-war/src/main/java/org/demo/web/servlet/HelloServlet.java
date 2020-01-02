package org.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.ejb.hello.HelloLocal;

/**
 * Servlet
 */
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private HelloLocal helloEJB;

	/**
	 * Default constructor.
	 */
	public HelloServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String r = helloEJB.hello("Bart");
		out.append("Hello result : " + r);
	}

}
