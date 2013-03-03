package com.jbksoft.datastore.model;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DataStoreTestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		EmployeeDAO dao=new EmployeeDAO();
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
