package session.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
 @Override
 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 /*
	   * 로그아웃
	   * 		로그아웃을 요청한 사용자의 상태값을 더이상 유지 하지 않겠다.
	   * 													=>  HttpSession을 제거(무효화)
	   * 													-> session.invalidate();
	   */
	  //로그아웃 처리
	 HttpSession session = req.getSession();
	 session.invalidate();
	 
	 //응답 - index.jsp로 이동
	 req.getRequestDispatcher("/index.jsp").forward(req, resp);
	 
 	}	
}
