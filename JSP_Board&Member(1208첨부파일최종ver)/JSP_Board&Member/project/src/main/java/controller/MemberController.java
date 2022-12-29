package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private RequestDispatcher rdp;
    private String destPage;
    private int isOk;
    
    private MemberService msv;
	
	
    public MemberController() {
    	msv = new MemberServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");
		
		String uri = req.getRequestURI(); // /mem/list
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		log.info(">>> URI > "+uri);
		log.info(">>> path > "+path);
		switch(path) {
		case "login": //login page open
			destPage = "/member/login.jsp";
			break;
		case "login_auth": //실제 로그인이 일어나는 케이스
			try {
				MemberVO mvo = msv.login( new MemberVO(
							req.getParameter("email"),
							req.getParameter("pwd")
							));
				log.info("login 객체 input");
				if(mvo != null) {
					//세션 가져오기. 연결된 세션이 없다면 새로 생성
					HttpSession ses = req.getSession();
					//ses로 mvo를 바인딩
					ses.setAttribute("ses", mvo);
					ses.setMaxInactiveInterval(10*60);  //로그인 유지시간(초단위) 10분 설정
				}else {
					req.setAttribute("msg_login", 0);
				}
				destPage="/";
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
			
		case "join": //회원가입 페이지 open
			destPage = "/member/join.jsp";
			break;
		case "register": //회원가입 DB 저장
			isOk = msv.register(new MemberVO(
					req.getParameter("email"),
					req.getParameter("pwd"),
					req.getParameter("nick_name")));
			log.info(">>> join > "+(isOk > 0 ? "ok":"fail"));
			destPage="login";
			break;
			
		case "logout":
			//연결된 세션이 있다면 해당 세션을 가져오기
			try {
				HttpSession ses = req.getSession();
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");
				String email = mvo.getEmail();
				log.info(email);
				ses.invalidate(); //세션 끊기
				//로그인정보 email 을 주고 로그인 시간 update
				//isOk = msv.lastLogin(req.getParameter("email"));
				isOk = msv.lastLogin(email);
				log.info(">>> lastLogin > "+(isOk > 0 ? "ok":"fail"));
				destPage="/";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				List<MemberVO> list = msv.getList();
				req.setAttribute("list", list);
				destPage = "/member/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "modify":
			destPage="/member/modify.jsp";
			break;
		case "update":
			MemberVO mvo = new MemberVO(
					req.getParameter("email"),
					req.getParameter("pwd"),
					req.getParameter("nick_name")); 
			
			isOk = msv.modify(mvo);
			if(isOk>0) {
				req.setAttribute("mvo", mvo);
			}
			destPage="login_auth";
			break;
		case "remove":
			try {
				HttpSession ses = req.getSession();
				MemberVO mvo1 = (MemberVO)ses.getAttribute("ses");
				String email = mvo1.getEmail();
				isOk = msv.remove(email);
				ses.invalidate();
				destPage="/";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		}
		//목적지 주소 값 세팅
		rdp=req.getRequestDispatcher(destPage);
		//정보싣고 보내기.
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
