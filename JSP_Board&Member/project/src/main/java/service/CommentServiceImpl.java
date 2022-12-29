package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;
import repository.CommentDAO;
import repository.CommentDAOImpl;

public class CommentServiceImpl implements CommentService{
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	
private CommentDAO cdao; //레포지터리에 인터페이스 생성
	
	public CommentServiceImpl () {
		cdao = new CommentDAOImpl();	//레포지터리에 클래스 생성
	}

	@Override
	public int post(CommentVO cvo) {
		log.info("comment >> post >> check 2");
		return cdao.insert(cvo);	//CommentDAO 메소드 생성
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info("comment >> list >> check 2");
		return cdao.selecList(bno);	////CommentDAO 메소드 생성
	}

	@Override
	public int remove(int cno) {
		log.info("comment >> remove >> check 2");
		return cdao.delete(cno);	// CommentDAO 메소드 생성
	}

	@Override
	public int update(CommentVO cvo) {
		log.info("comment >> modify >> check 2");
		return cdao.update(cvo);
	}

	public int deleteAll(int bno) {
		// TODO Auto-generated method stub
		return cdao.deleteAll(bno);	
	}
	
	
}
