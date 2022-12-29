package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVO;
import domain.PagingVO;
import handler.FileHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BoardController.class); 
	private String destPage; 
	private RequestDispatcher rdp;
	private int isOk;
	private String savePath; 				//파일경로를 저장할 변수
	private final String UTF8 = "utf-8";	//인코딩 설정시 필요함
	
	
	private BoardService bsv;	//service에 interface 생성
    public BoardController() {
    	bsv =new BoardServiceImpl();	//service에 class 생성
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");
		
		String uri = req.getRequestURI();
		log.info("uri>>>"+uri);	
		String path = uri.substring(uri.lastIndexOf('/')+1);
		log.info("path>>>"+path);
		
		switch(path) {
		
		case "register":
			destPage="/board/register.jsp";			
			log.info("path >>>"+path);
			break;			

		case "insert":
			try {
				//파일을 업로드할 물리적인 저장경로 설정
				savePath = getServletContext().getRealPath("/_fileUpload");	//실제 경로를 가져옴
				File fileDir = new File(savePath); 							//import (java io)
				log.info("저장위치"+savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory(); 	//import (common)
				fileItemFactory.setRepository(fileDir);			//저장할 '위치'를 file 객체로 지정
				fileItemFactory.setSizeThreshold(2*1024*1024);	//저장을 위한 '임시 메모리 저장 용량' 설정 : byte단위
				
				BoardVO bvo = new BoardVO();
				// multipart/form-date 형식으로 넘어온 req 객체를 다루기 쉽게 변환
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				
				List<FileItem> itemList = fileUpload.parseRequest(req); //import (common)
				for(FileItem item : itemList) {
					
					switch(item.getFieldName()) {
					
					case "title":
						bvo.setTitle(item.getString(UTF8));	//인코딩 형식을 담아서 변환
						break;
					case "writer":
						bvo.setWriter(item.getString(UTF8));
						break;
					case "content":
						bvo.setContent(item.getString(UTF8));
						break;
					case "image_file":
						//이미지가 있는지 없는지 체크
						if (item.getSize()>0) {	//data의 크기를 byte 단위로 return
							String fileName = item.getName().substring(item.getName().lastIndexOf("/")+1);							
							//D:\JSP_Test\JSP_Board&Member\project\src\main\webapp\_fileUpload 이 경로가 다 들어오게되므로 자름.
							//파일 이름만 분리돼서 fileName에 들어감!!
							fileName = System.currentTimeMillis()+"_"+fileName;	//현재 시스템의 시간_dog.jsp
							File UploadFilePath = new File(fileDir+File.separator+fileName);
							log.info("파일 경로 + 파일명 : "+UploadFilePath);
							
							// 저장
							try {
								item.write(UploadFilePath);	//item에 자바객체 UploadFilePath를 써줌
								bvo.setImage_file(fileName);
								
								//썸네일 작업 : list page 에서 트래픽 과다 사용 방지
								Thumbnails.of(UploadFilePath)
								.size(25, 25)
								.toFile(new File(fileDir+File.separator+"th_"+fileName));								
							} catch (Exception e) {
								log.info("file writer on disk fail");
								e.printStackTrace();
							}							
						}
						break;
					}
				}
				isOk = bsv.register(bvo);
				log.info("insert : " +(isOk>0?"성공":"실패"));
				destPage="pageList";
				
//				String title = req.getParameter("title");
//				String writer = req.getParameter("writer");
//				String content = req.getParameter("content");
//				log.info("insert check 1");	
//				
//				int isOk = bsv.register(new BoardVO(title, writer, content));	//boardsevice 에 메소드 생성
//				log.info(isOk >0 ? "성공" : "실패");				
//				destPage ="pageList";
			} catch (Exception e) {
				log.info("insert error");
				e.printStackTrace();
			}
			break;
			
		case "list":
			try {
				//74~79 라인 : 작성자 글만 보이게 설정
				HttpSession ses = req.getSession();	//import
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");	//import
				String email = mvo.getEmail();				
				//List<BoardVO> list = bsv.getList();	//List import, getList는 보드서비스에 메소드 생성				
				List<BoardVO> list = bsv.getMyList(email);	//List import, getMyList는 보드서비스에 메소드 생성	
				log.info("list"+list.get(0).getTitle());
				req.setAttribute("list", list);
				destPage="/board/list.jsp";	
			} catch (Exception e) {				
				e.printStackTrace();
			}
			break;
			
		case "pageList":
			try {
				PagingVO pgvo = new PagingVO();	
				int totCount = bsv.getPageCnt();	//전체 카운트 호출. 보드서비스에 메소드 생성
				List<BoardVO> list = bsv.getListPage(pgvo); // limit 이용한 한 페이지 라인 호출. 보드서비스에 메소드 생성
				PagingHandler ph = new PagingHandler(pgvo,totCount);
				req.setAttribute("list", list);	//한 페이지에 나와야 하는 리스트 보내기
				req.setAttribute("pgh", ph);	//페이지 정보 보내기
				destPage="/board/list.jsp";
			} catch (Exception e) {
				log.info("paging error");
				e.printStackTrace();
			}			
			break;
			
		//pageList 그대로 복붙하면서 요소 추가
		case "page":
			try {
				int pageNo = Integer.parseInt(req.getParameter("pageNo"));
				int qty = Integer.parseInt(req.getParameter("qty"));
				
				PagingVO pgvo = new PagingVO(pageNo, qty);
				
				int totCount = bsv.getPageCnt();	
				List<BoardVO> list = bsv.getListPage(pgvo); 
				PagingHandler ph = new PagingHandler(pgvo,totCount);
				req.setAttribute("list", list);	
				req.setAttribute("pgh", ph);	
				destPage="/board/list.jsp";
			} catch (Exception e) {
				log.info("subPage error");
				e.printStackTrace();
			}			
			break;
			
		//list 에서 제목을 클릭하여 detail 페이지로 들어갈 때 조회수 카운트가 되어야 한다.
		case "detail":
			try {
				int bno = Integer.parseInt(req.getParameter("bno"));
				log.info("detail check 1");
				//service에게 메소드 호출시 read_count를 +1(update) 해서 detail값을 호출
				//BoardServiceImpl 에서부터 처리 (여기서 해도 되지만, 여기서 하면 수정창에서도 조회수 카운트올라감)
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
			
		case "update":	//insert와 동일구조
			try {
				//파일을 업로드할 물리적인 저장경로 설정
				savePath = getServletContext().getRealPath("/_fileUpload");	//실제 경로를 가져옴
				File fileDir = new File(savePath); 							//import (java io)
				log.info("저장위치"+savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory(); 	//import (common)
				fileItemFactory.setRepository(fileDir);			//저장할 '위치'를 file 객체로 지정
				fileItemFactory.setSizeThreshold(2*1024*1024);	//저장을 위한 '임시 메모리 저장 용량 2mb' 설정 : byte단위
				
				BoardVO bvo = new BoardVO();
				// multipart/form-date 형식으로 넘어온 req 객체를 다루기 쉽게 변환
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				log.info("update 준비!! "+savePath);
				
				List<FileItem> itemList = fileUpload.parseRequest(req); //import (common)				
				String old_file = null;
				
				for(FileItem item : itemList) {
					
					switch(item.getFieldName()) {
					//writer는 수정할게 아니므로 없어도 됨
					case "bno":
						bvo.setBno(Integer.parseInt(item.getString(UTF8)));
						break;
					case "title":						
						bvo.setTitle(item.getString(UTF8));	//인코딩 형식을 담아서 변환
						break;					
					case "content":
						bvo.setContent(item.getString(UTF8));
						break;
					case "image_file":	//old_file
						//old_file 무조건 삭제가 X. 내용만 수정하는 경우있으므로 new_file이 없으면 유지
						old_file = item.getString(UTF8);	
						break;
					case "new_file":
						if (item.getSize()>0) {	//getSize 뭐라도 나오면, 새로운 파일이 등록 됨.
							if (old_file != null) {
								//파일 핸들러 작업 (기존 파일을 삭제)
								FileHandler fileHandler = new FileHandler();
								isOk = fileHandler.deleteFile(old_file, savePath);
								log.info("old_file 삭제!!");
							}
							// 경로가 포함된 전체경로와 파일이름 생성
							String fileName = item.getName().substring(item.getName().lastIndexOf("/")+1);	
							//lastIndexOf("/") => mac 에서는 "/" 대신에(file.separator)+1 로 써준다
							//D:\JSP_Test\JSP_Board&Member\project\src\main\webapp\_fileUpload 이 경로가 다 들어오게되므로 자름.
							//파일 이름만 분리돼서 fileName에 들어감!!
							log.info("newFileName : "+fileName);
							fileName = System.currentTimeMillis()+"_"+fileName;	//현재 시스템의 시간_dog.jsp
							File UploadFilePath = new File(fileDir+File.separator+fileName);
							
							try {
								item.write(UploadFilePath);	//item에 자바객체 UploadFilePath를 디스크에 써줌
								bvo.setImage_file(fileName);
								log.info("Upload img_file"+(bvo.getImage_file()));
								//썸네일 작업 : list page 에서 트래픽 과다 사용 방지
								Thumbnails.of(UploadFilePath)
								.size(25, 25)
								.toFile(new File(fileDir+File.separator+"th_"+fileName));
							} catch (Exception e) {
								log.info("File Write on disk Fail");
								e.printStackTrace();
							}
						} else {	//new_file이 없으면 old_file 유지!!
							bvo.setImage_file(old_file);
						}
						break;
					}
				}
				isOk = bsv.getUpdate(bvo);
				log.info("update :" + (isOk >0 ? "성공":"실패"));
				
//				BoardVO bvo = new BoardVO(
//						Integer.parseInt(req.getParameter("bno")),
//						req.getParameter("title"),
//						req.getParameter("content"));
//				log.info("update check 1");
//				
//				int isOk = bsv.getUpdate(bvo);	//getUpdate BoardService에 메소드 생성
//				log.info("update check 4");

				destPage="pageList";
				
			} catch (Exception e) {
				log.info("update error");
				e.printStackTrace();
			}
			break;
			
		case "remove":
			try {
				int bno = Integer.parseInt(req.getParameter("bno"));
				//imageFileName 불러오기
				String imageFileName = bsv.getFileName(bno);	//삭제할 파일 실제 이름을 bno로 호출
				FileHandler fileHandler = new FileHandler();
				isOk = fileHandler.deleteFile(imageFileName, savePath);
				log.info("fileDelete >> "+(isOk>0 ? "성공":"실패"));
				isOk = bsv.getDelete(bno);	//BoardService에 메소드 생성
				
				destPage="pageList";
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
	//모두 service 값으로 처리
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req,res);
	}	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req,res);
	}
}