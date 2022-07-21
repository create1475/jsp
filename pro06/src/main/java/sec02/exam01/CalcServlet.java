package sec02.exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//서블릿 맵핑
@WebServlet("/Calc")
//웹 동작을 위해 쓴다.
public class CalcServlet extends HttpServlet {
	//환율 초기화 선언	
	private static float USD_RATE = 1124.70f;
	private static float JPY_RATE = 10.113f;
	private static float CNY_RATE = 163.30f;
	private static float GBP_RATE = 1444.35f;
	private static float EUR_RATE = 1295.97f;
	
	
	
	//브라우저 요청과 응답을 매개변수로 한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//리퀘스트를 utf로 형식으로 바꾼다.
	request.setCharacterEncoding("utf-8");
	//보낼때 html로 utf로 보낸다.
	response.setContentType("text/html; charset=utf-8");
	//내장객체 겟 라이터 (라이브러리 메소드)
	PrintWriter pw = response.getWriter();
	//겟 파라미터 매개변수 값 불러온다.
	
	//서브밋이 작동될때 값이 들어간다.
	String command = request.getParameter("command");
	String won = request.getParameter("won");
	String operator = request.getParameter("operator");
	
	//커맨드가 널이 아닐떄 그리고 커맨더에 카큘이 들어갔을때
	if(command != null && command.equals("calculate")) 
	{
		String result = calculate(Float.parseFloat(won), operator);
		pw.print("<html><font size = 10>변환 결과</font><br>");
		pw.print("<html><font size = 10>"+ result + "</font><br>");
		pw.print("<a herf='/pro06/Calc'>환율 계산기</a>");
		return;
	}
	//
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size =5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc' method='get' action='/pro06/Calc'/>");
		pw.print("원화:<input type='text' name='won' size=10 />");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate' />");
		//서브밋 이 되면 커맨더로 간다.
		pw.print("<input type='submit' value='변환'/>");
		pw.print("</form>");
		pw.print("</html>");
		pw.close();
	}
	
	
	
	
	//그냥 환율 계산이야
	
	private static String calculate(float won, String operator) {
		String result = null;
		if(operator.equals("dollar")) {
			result = String.format("%.6f",won / USD_RATE);
			}else if(operator.equals("en")) {
				result = String.format("%.6f",won/JPY_RATE);
			}else if(operator.equals("wian")) {
				result = String.format("%.6f",won/CNY_RATE);
			}else if(operator.equals("pound")) {
				result = String.format("%.6f",won/GBP_RATE);
			}else if(operator.equals("euro")) {
				result = String.format("%.6f",won/EUR_RATE);
			}
		return result;
		}
	}	
		
		
	
	
	
	
	
	

       
   
