package controller;

import java.io.IOException;
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
    private MemberService msv; // interface로 생성 - service패키지에
    private String destPage; //목적지 주소 기록 변수
    private int isOk; 
    
    
    public MemberController() {
        msv = new MemberServiceImpl(); //interface 구현 클래스 - service패키지에
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String uri=req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(uri);
		log.info(path);
		
		switch(path) {
		case "join":
			destPage="/member/join.jsp";
			break;
		case "register":
			//회원정보저장
			isOk = msv.register(
					new MemberVO(
							req.getParameter("id"),
							req.getParameter("password"),
							req.getParameter("email"),
							Integer.parseInt(req.getParameter("age"))              
							));
			log.info(">> join > "+ (isOk >0 ? "ok":"fail"));
			destPage="/";
			break;
		case "login":
			//id,password가 일치하는 db의 값이 있다면 객체를 반환
			MemberVO mvo = msv.login(new MemberVO(
					req.getParameter("id"),
					req.getParameter("password")
					));
			log.info(">> login > check ok");
			if(mvo != null) { //일치하는 객체를 찾았음.
				//로그인 정보는 세션에 담아서 보냄
				//현재 연결되어있는 세션이 있다면 해당 세션을 유지, 없다면 새로 생성
				HttpSession ses = req.getSession();
				ses.setAttribute("ses", mvo);
				//로그인유지시간
				ses.setMaxInactiveInterval(10*60); //초단위 (10*60) 10분유지
			}else { //로그인 실패
				req.setAttribute("msg_login", 0);
			}
			destPage="/";
			break;
		case "logout":
			try {
				HttpSession ses = req.getSession(); //현재 연결된 세션(로그인된 정보) 가져오기
				ses.invalidate(); //세션 무효화 (세션종료)
				destPage="/";
				break;
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		case "list":
			List<MemberVO> list = msv.getList();
			req.setAttribute("list", list);
			destPage="/member/list.jsp";
			break;
		case "modify":
			destPage = "/member/modify.jsp";
			break;
		case "update":
			isOk = msv.modify(new MemberVO(
					req.getParameter("id"),
					req.getParameter("password"),
					req.getParameter("email"),
					Integer.parseInt(req.getParameter("age"))
					));
			
			destPage="list";
			break;
		case "remove":
			try {
				HttpSession ses = req.getSession(); //현재 연결된 세션(로그인된 정보) 가져오기
				ses.invalidate(); //세션 무효화 (세션종료)
				isOk = msv.remove(req.getParameter("id"));
				log.info(">> remove > "+ (isOk >0 ? "ok":"fail"));
				destPage="/";
				break;
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
