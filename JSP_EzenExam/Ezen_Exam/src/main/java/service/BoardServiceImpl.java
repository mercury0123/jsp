package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	private BoardDAO bdao;			//레포지터리에 인터페이스 생성
	public BoardServiceImpl () {
		bdao = new BoardDAOImpl();	//레포지터리에 클래스 생성
	}
	@Override
	public int register(BoardVO bvo) {
		log.info("insert check2");
		return bdao.insert(bvo);	//보드다오에서 구현
	}
	@Override
	public List<BoardVO> getList() {
		log.info("list check 2");
		return bdao.selectList();
	}
	@Override
	public BoardVO getDetail(int bno) {
		log.info("detail check 2");
		return bdao.selectOne(bno);
	}
	@Override
	public int getUpdate(BoardVO bvo) {
		log.info("update check 2");
		return bdao.update(bvo);
	}
	@Override
	public int getDelete(int bno) {
		log.info("delete check 2");
		return bdao.delete(bno);	
	}

}
