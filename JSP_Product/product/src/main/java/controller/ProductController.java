package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
import service.ProductService;
import service.Service;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 상품등록, 상품리스트, 상품상세, 상품수정, 상품삭제
	// 데이터베이스 연동 후 컨트롤러에서 메뉴를 분기처리 (요청에 따라 처리)
	// 컨트롤러 -> 서비스 -> DAO 순으로 전달
	private Service svc;  // 인터페이스 생성

    public ProductController() {
    	svc = new ProductService();  // 구현 클래스 생성
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 모든 처리는 service에서 처리
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();  // 전체 요청경로를 uri에 저장
		System.out.println(">>>uri"+uri);  // product/register.pd
//		String context = req.getContextPath();  // 프로젝트명을 context에 저장
//		System.out.println(">>>context "+context);
		
		// uri에서 요청하는 구문만 잘라내기 register, list
		String path = uri.substring(uri.lastIndexOf('/')+1, uri.lastIndexOf('.'));
		System.out.println(path);
		
		String destPage = "";  // 요청에 대한 응답을 싣고 가야하는 경로
		
		switch(path) {
		case "register": destPage = "/product/register.jsp"; break;
		
		// insert 작업을 하기 위한 case
		// service에서 필요한 pvo로 만들어서 service에게 전달 (호출)
		case "insert":
			// 혹시 모를 오류 발생에 대비
			try {
				ProductVO pvo = new ProductVO();
				pvo.setPname(req.getParameter("pname"));
				pvo.setPrice(Integer.parseInt(req.getParameter("price")));  // getParameter의 리턴값은 String
				pvo.setMadeby(req.getParameter("madeby"));
				System.out.println(pvo.getPname());
				// service 호출 및 처리 확인
				int isOk = svc.register(pvo);
				System.out.println("등록"+(isOk>0?"성공":"실패"));
				
				destPage = "/index.jsp";
			} catch (Exception e) {
				System.out.println("요청이 올바르지 않습니다.");
				e.printStackTrace();
			}
			break;
			
		case "list": 
			try {
				List<ProductVO> list = svc.list();
				req.setAttribute("list", list);
				
				destPage = "/product/list.jsp";
			} catch (Exception e) {
				System.out.println("요청이 올바르지 않습니다.");
				e.printStackTrace();
			}
			break;
			
		case "detail":
			try {
				int pno = Integer.parseInt(req.getParameter("pno"));				
				// 내용을 받을 객체
				ProductVO pvo = svc.detail(pno);
				req.setAttribute("pvo", pvo);		//리퀘스트 에 담아서 "pvo" 이름으로 pvo 객체를 보냄		
				destPage = "/product/detail.jsp";
			} catch (Exception e) {
				System.out.println("요청이 올바르지 않습니다.");
				e.printStackTrace();
			}
			break;
			
		case "edit":	
			try {				
				int pno = Integer.parseInt(req.getParameter("pno"));
				ProductVO pvo = svc.detail(pno);
				req.setAttribute("pvo", pvo);
				destPage="/product/edit.jsp";
				
			} catch (Exception e) {
				System.out.println("요청이 올바르지 않습니다.");
				e.printStackTrace();
			}
			break;
		
		case "modify":	
			try {
				ProductVO pvo = new ProductVO();
				pvo.setPno(Integer.parseInt(req.getParameter("pno")));
				pvo.setPname(req.getParameter("pname"));
				pvo.setPrice(Integer.parseInt(req.getParameter("price"))); 				
				pvo.setMadeby(req.getParameter("madeby"));
				int isOk = svc.edit(pvo);	//edit 빨간줄 service에 메소드 생성
				System.out.println("수정"+(isOk>0?"성공":"실패"));
				destPage="list.pd";
				
			} catch (Exception e) {
				System.out.println("요청이 올바르지 않습니다.");
				e.printStackTrace();
			}
			break;
			
		case "remove":
			try {				
				int pno = Integer.parseInt(req.getParameter("pno"));				
				int isOk = svc.remove(pno);	//delete 빨간줄 service에 메소드 생성
				System.out.println("삭제"+(isOk >0?"성공":"실패"));
				destPage="list.pd";				
			} catch (Exception e) {
				System.out.println("요청이 올바르지 않습니다.");
				e.printStackTrace();
			}
		}
		
		// destPage로 가도록 작성
		RequestDispatcher rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req,res);
	}

}
