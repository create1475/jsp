package com.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	
	String x_ = request.getParameter("x");//요청받은 값 name에 있는 값 x 를 스트링 x_에 넣어
	String y_ = request.getParameter("y");
	
	int x = 0;//초기화를 해주고
	int y = 0;
	
	if(!x_.equals("")) x = Integer.parseInt(x_);//만약에 x_가 빈공간이 아니니? 그럼 입력된 문자를 숫자로 바꿔
	if(!y_.equals("")) y = Integer.parseInt(y_);
	
	int result = x * y;
	
	response.getWriter().printf("result is %d\n", result);
	
		
		
		
		
	}


}
