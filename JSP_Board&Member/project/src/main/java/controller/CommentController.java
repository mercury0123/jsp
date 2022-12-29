package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.CommentVO;
import service.CommentService;
import service.CommentServiceImpl;


@WebServlet("/cmt/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CommentController.class);
	private CommentService csv; //interface 생성 service 패키지
	private int isOk;
	
    
    public CommentController() {	//class 생성 service 패키지
    	csv = new CommentServiceImpl();
    }
    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		// /cmt/list/bno/ 게시판 에 몇번 게시글에 해당하는 라인이 필요
		String pathUri = uri.substring("/cmt/".length());
		String path = pathUri;
		String pathVar = "";
		if(pathUri.contains("/")) {
			path = pathUri.substring(0, pathUri.lastIndexOf("/"));	//list
			pathVar = pathUri.substring(pathUri.lastIndexOf("/")+1); //bno	
		}
		log.info("uri>>>"+uri);
		log.info("pathUri>>>"+pathUri);	
		log.info("path>>>"+path);
		log.info("pathVar>>>"+pathVar);	
		
		
		switch(path) {
		
		case "post":
			try {	//json 형태라 req.getParameter 로 못가져옴 StringBuffer 사용
					//js에서 보낸 데이터를 StringBuffer로 읽어들이는 작업
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();	//댓글 읽어옴 req
				while((line = br.readLine())!=null) {	//line 값이 있다면
					sb.append(line);					//댓글 객체를 sb에 추가
				}
				log.info("sb >>>" + sb.toString()); //buffer므로 sb 바로 하면 안되고 toString 해줘야됨. 
				//JSON객체로 생성해주어야
				JSONParser parser = new JSONParser();	//lib 추가한 json-simple1.1.1
				JSONObject jsObj = (JSONObject)parser.parse(sb.toString()); //일반 object므로 JSONObject로 형변환. 각 값을 bno, writer 등으로 분리해줌
				int bno = Integer.parseInt(jsObj.get("bno").toString());	//jsObj는 key value 형식이므로 -> 변환
				String writer = jsObj.get("writer").toString();
				String content = jsObj.get("content").toString();
				isOk = csv.post(new CommentVO(bno, writer, content));	//CommentVO import, CommentService에 post 메소드 생성
				log.info(isOk>0 ? "성공":"실패");
				//화면에 출력
				PrintWriter out = res.getWriter();		//댓글 뿌려줌 res
				out.print(isOk);	//다시 보드 디테일.js const result = await resp.text(); 로 감
						
			} catch (Exception e) {
				log.info("Comment >> post >> error");
				e.printStackTrace();
			}
			break;
		
		case "list":
			try {
				List<CommentVO> list = csv.getList(Integer.parseInt(pathVar)); // List import, getList 메소드 생성 CommentService
				log.info("Comment >> list >> DB성공!!");
				//json 형태로 변환
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();	//JSONArray import
				
				for (int i=0; i<list.size(); i++) {
					
					jsonObjArr[i] = new JSONObject();	//key : value
					jsonObjArr[i].put("cno", list.get(i).getCno());		//cno : 1 이 배열에 들어감
					jsonObjArr[i].put("bno", list.get(i).getBno());		//bno : 176 이 배열에 들어감
					jsonObjArr[i].put("writer", list.get(i).getWriter());
					jsonObjArr[i].put("content", list.get(i).getContent());
					jsonObjArr[i].put("reg_at", list.get(i).getReg_at());
					
					jsonObjList.add(jsonObjArr[i]);
				}
				String jsonData = jsonObjList.toJSONString();	//변환후 jsonData로
				PrintWriter out = res.getWriter();				//jsonData 출력
				out.print(jsonData);
				
			} catch (Exception e) {
				log.info("Comment >> list >> error");
				e.printStackTrace();
			}
			break;

		case "modify":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();	
				while((line = br.readLine())!=null) {	
					sb.append(line);					
				}
				log.info("sb >>>" + sb.toString());
				JSONParser parser = new JSONParser();
				JSONObject jsObj = (JSONObject)parser.parse(sb.toString());
				int cno = Integer.parseInt(jsObj.get("cno").toString());
				String content = jsObj.get("content").toString();
				CommentVO cvo = new CommentVO(cno, content);
				isOk = csv.update(cvo);	//CommentService에 update 메소드 생성
				log.info(isOk>0 ? "성공":"실패");
				
				PrintWriter out = res.getWriter();
				out.print(isOk);
			} catch (Exception e) {
				log.info("Comment >> modify >> error");
				e.printStackTrace();
			}

		case "remove":
			int cno = Integer.parseInt(pathVar);	
			int isOk = csv.remove(cno);			//remove메소드 생성 CommentService
			log.info(isOk>0 ? "성공":"실패");
			PrintWriter out = res.getWriter();
			out.print(isOk);
			break;
			
			default :
				break;
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req,res);
	}

}