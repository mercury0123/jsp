package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	private String destPage; 
	private RequestDispatcher rdp;
	private int isOk;
	
	private BoardService bsv;
	
    public BoardController() {
    	bsv =new BoardServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");
		
		String uri = req.getRequestURI();
		log.info("uri>>>"+uri);		
		String path = uri.substring(uri.lastIndexOf('/')+1);
		log.info("path>>>"+path);	
		
		switch (path) {
		
		case "register":
			destPage="/board/register.jsp";
			log.info("path >>>"+path);
			break;
			
		case "insert":
			try {
				//등록한 후 -> list.jsp로 이동
				String title = req.getParameter("title");
				String writer = req.getParameter("writer");
				String content = req.getParameter("content");
				log.info("insert check 1");	
				
				isOk = bsv.register(new BoardVO(title, writer, content));	
				log.info(isOk >0 ? "성공" : "실패");
				
				destPage ="/brd/list";	
			} catch (Exception e) {
				log.info("insert error");
				e.printStackTrace();
			}
			break;
		
		case "list":
			try {
				log.info("list check 1");
				List<BoardVO> list = bsv.getList();	//List import, getList는 보드서비스에 메소드 생성
				log.info("list check 4");
				req.setAttribute("list", list);
				destPage="/board/list.jsp";				
				
			} catch (Exception e) {
				log.info("list error");
				e.printStackTrace();
			}
			break;
			
		case "detail":
			try {
				int bno = Integer.parseInt(req.getParameter("bno"));
				log.info("detail check 1");
				BoardVO bvo =bsv.getDetail(bno); //getDetail생성 BoardService 메소드 ㅐㅇ성
				log.info("detail check 4");
				req.setAttribute("bvo", bvo);
				destPage="/board/detail.jsp";
			} catch (Exception e) {
				log.info("detail error");
				e.printStackTrace();
			}
			break;
			
		case "modify":	
			try {				
				int bno = Integer.parseInt(req.getParameter("bno"));
				log.info("modify check 1");
				BoardVO bvo = bsv.getDetail(bno);	
				log.info("modify check 4");
				req.setAttribute("bvo", bvo);
				destPage="/board/modify.jsp";		//바로 수정이 아니고 update로 보내는 역할	
			} catch (Exception e) {
				log.info("modify error");
				e.printStackTrace();
			}
			break;
			
		case "update":	
			try {
				BoardVO bvo = new BoardVO(
						Integer.parseInt(req.getParameter("bno")),
						req.getParameter("title"),
						req.getParameter("content"));
				log.info("update check 1");
				
				int isOk = bsv.getUpdate(bvo);	//getUpdate BoardService에 메소드 생성		
				log.info("update check 4");
				destPage="/brd/list";
				
			} catch (Exception e) {
				log.info("update error");
				e.printStackTrace();
			}
			break;
			
		case "remove":
			try {
				int bno = Integer.parseInt(req.getParameter("bno"));
				log.info("delete check 1");
				
				int isOk = bsv.getDelete(bno);	//delete 빨간줄 BoardService에 메소드 생성
				log.info("delete check 4");
				destPage="list";				
			} catch (Exception e) {
				log.info("delete error");
				e.printStackTrace();
			}
			break;
		}
		//목적지 경로로 응답함 (전달)
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req, res);
	}

}
