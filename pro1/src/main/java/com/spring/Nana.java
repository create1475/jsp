package com.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

@WebServlet("/hi")
public class Nana extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	
		
		String cnt_ = request.getParameter("cnt");
		int cnt = 100;
		
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
		
		for(int i=0; i<cnt; i++) {
			out.println((i+1) + ": 안녕 HELLO SERVLET!!!<br>");
		}
		

		
		
	}
}
