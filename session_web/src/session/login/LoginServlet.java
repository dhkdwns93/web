package session.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.LoginFailException;
import vo.Member;
//로그인 처리 서블릿
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 요청파라미터 - id/password 조회
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		
		try {
			Member member = authenticate(id, password);//인증
			//로그인 성공 - session 생성 -> login_success.jsp
			HttpSession session = req.getSession();
			//로그인 여부를 체크할 속성값 session에 추가.
			session.setAttribute("loginInfo", member);//로그아웃 할때까지 관리해야하는 속성값.
			  
			req.getRequestDispatcher("/login/login_success.jsp").forward(req, resp);
			
		} catch (Exception e) {
			//로그인 실패 - login_form.jsp
			req.setAttribute("errorMessage", e.getMessage());//응답하면 관리할 필요없는 속성값
			req.getRequestDispatcher("/login/login_form.jsp").forward(req, resp);
		}
		
		/*//2. 로그인 처리 = Model 호출(Business Service -> Dao)
		//로그인 처리 - 1. 인증작업
		boolean flag = authenticate(id, password);
		//로그인 처리 - 2. HttpSession 생성(요청한 사용자의 정보를 유지할 저장소 생성)
		if(flag){
			HttpSession session = req.getSession();
			session.setAttribute("loginInfo", id);//로그인 상태 여부를 체크할 때 사용할 속성.
			//로그인 성공페이지로 이동 - 응답
			req.getRequestDispatcher("/login/login_success.jsp").forward(req, resp);
		}else{//실패
			req.setAttribute("errorMessage", "ID나 패스워드가 틀렸습니다.");//login_form으로 보낸다. - "errorMessage"
			req.getRequestDispatcher("/login/login_form.jsp").forward(req, resp);
		}*/
	}
	//인증 처리 메소드(Model 대용)
	public Member authenticate(String id, String password) throws LoginFailException {
		//id/password 비교
		String dbId="java", dbPassword="servlet";
		Member member=//null;//ID가 없다.
		 		new Member("java", "servlet", "김회원", "a@a.com,", 30000);//ID가 있다
		
		 	if(member!=null){//맞는 ID

		 		if(password.equals(member.getPassword())){//인증성공
		 			return member;//로그인한 회원의 정보를 리턴.
		 		}else{//ID(O), PWD(X) - 인증실패
		 			throw new LoginFailException("패스워드를 확인하세요.");
		 		}
		 	}else{//ID(X) - 인증실패
		 		throw new LoginFailException("ID를 확인하세요.");
		 	}
		 		
		 /*	if(id.equals(dbId)){//맞는 ID
			if(password.equals(dbPassword)){//인증 성공
				return true;
			}else{//ID(O), PWD(X) - 인증실패
				throw new LoginFailException("패스워드를 확인하세요.");
			}
		}else{//ID(X) - 인증실패
			throw new LoginFailException("ID를 확인하세요.");
		}*/
	}
}
