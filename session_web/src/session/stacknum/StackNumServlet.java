package session.stacknum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StackNumServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = (int)(Math.random()*100)+1;
		//세션 받기
		HttpSession session = request.getSession();
		
		//원하는 속성 받기
		//getAttribute - Object타입
		ArrayList list = (ArrayList) session.getAttribute("num");
		//속성 null확인
		
		//null
			//list 객체 생성
		if(list==null){
			list = new ArrayList();
			//세션에 추가
			session.setAttribute("num", list);
			//값추가
		}
		list.add(num);
		//요청 디스패치 -> 리다이렉트
//		request.getRequestDispatcher("/stacknum/show_number.jsp").forward(request, response);
		//요청 디스패치 문제점 : 새로고침을 하게 되면 값이 추가된다.
		response.sendRedirect("/session_web/stacknum/show_number.jsp");//절대경로 / 리다이렉트
	}

}
