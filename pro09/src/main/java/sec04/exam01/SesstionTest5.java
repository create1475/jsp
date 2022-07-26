package sec04.exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login31")
public class SesstionTest5 extends HttpServlet {
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		if(session.isNew()) {
			if(user_id != null) {
				session.setAttribute("user_id", user_id);
				String url = response.encodeURL("login31");//변수 url에서 encodeURl()을 이용해 응답시 미리 jsessionld를 저장한다.
				out.println("<a href="+url+">로그인 상태 확인</a>");//로그인상태 확인 클릭시 jsession를 서블릿으로 다시 전송합니다.
			}else {
				out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
				}//제일 처음 이프문의 엘스 닫는 중괄호 	
			}else {
				user_id = (String) session.getAttribute("user_id");
					if(user_id !=null && user_id.length() !=0) {
					out.print("안녕하세요" + user_id + "님!!!");
						}else {
					out.print("<a href='login2.html'>다시 로그인 하세요!!!</a>");
					session.invalidate();
					
				}
			}
		}
		
	}
	


