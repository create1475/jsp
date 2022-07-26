package sec04.exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login30")
public class SessionTest4 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response)throws ServletException , IOException{
		doHandle(request, response);
	}
//doHandle 은 자동완성 안됨
	//그리고 포스트나 겟은  핸들로 받고 난뒤에 다시 받아야 하는데 선언을 안해주면 받을수가 없다.
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");//로그인창에서 전송된 아이디랑 비밀번호를 가져옵니다.
		String user_pw = request.getParameter("user_pw");//
		if(session.isNew()) {//최초 요청 시 수행
			if(user_id != null) {//로그인 창에서 서블릿으로 요청했다면 id가 null이 아니므로 세션에 id를 바인딩 합니다.
			session.setAttribute("user_id", user_id);
			out.println("<a href='login30'>로그인 상태 확인</a>");
		}else {
			out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
			session.invalidate();
		}
		
				
	}else {//재요청시 세션에서 id를 가져와 이전에 로그인했는지 여부를 확인합니다.
		user_id = (String) session.getAttribute("user_id");
		if(user_id != null && user_id.length() != 0) {
			out.print("안녕하세요" + user_id + "님!!!!");
		}else {
			out.print("<a href = 'login2.html'>다시 로그인 하세요!!</a>");
			session.invalidate();
			
		}
		

		}
	}
}