package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);	//로거 slf4j로 임포트
	
	private BoardDAO bdao; //레포지터리에 인터페이스 생성		
	public BoardServiceImpl () {
		bdao = new BoardDAOImpl();	//레포지터리에 클래스 생성
	}

	@Override
	public int register(BoardVO bvo) {
		log.info("insert check2");
		return bdao.insert(bvo);	//빨간줄 메소드 생성
	}

	@Override
	public List<BoardVO> getList() {
		log.info("list check 2");
		return bdao.selectList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		//read_count update 요청 후 detail값 요청
		int isOk = bdao.updateCount(bno);
		log.info("detail check 2");
		return (isOk>0 ? bdao.selectOne(bno):null);
	}

	@Override
	public int getUpdate(BoardVO bvo) {
		log.info("update check 2");
		return bdao.update(bvo);	//보드다오에서 구현
	}

	@Override
	public int getDelete(int bno) {
		log.info("delete check 2");
		CommentServiceImpl csv = new CommentServiceImpl();
		int isOk = csv.deleteAll(bno);
		
		return bdao.delete(bno);
	}

	@Override
	public int getPageCnt() {		
		return bdao.selectCount();
	}

	@Override
	public List<BoardVO> getListPage(PagingVO pgvo) {		
		return bdao.selectList(pgvo);
	}

	@Override
	public List<BoardVO> getMyList(String email) {
		// TODO Auto-generated method stub
		return bdao.selectList(email);
	}

	@Override
	public String getFileName(int bno) {
		return bdao.selectImageFile(bno);
	}

	
}