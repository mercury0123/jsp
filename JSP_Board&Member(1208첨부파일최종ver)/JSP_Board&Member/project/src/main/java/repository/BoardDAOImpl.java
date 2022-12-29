package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	//DB와 연결
	private SqlSession sql;	//import!!
	private final String NS = "BoardMapper."; //namespace 설정!! 뒤에 . 잊지말것!! 매번 맵퍼. 찍기 번거로우므로 만들어서 변수에 넣어준것
	
	public BoardDAOImpl() {
		new DatabaseBuilder(); //orm -> db 연결 클래스 객체 생성
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	// 각 연결요청 오버라이딩
	@Override
	public int insert(BoardVO bvo) {
		log.info("insert check 3");		
		int isOk = sql.insert(NS+"add",bvo); //보드 맵퍼에게 add라는 값을 가지는 것을 실행해서 bvo에 줌
		if(isOk>0) sql.commit();	
		return isOk;
	}

	@Override
	public List<BoardVO> selectList() {
		log.info("list check 3");	
		return sql.selectList(NS+"list");
	}

	@Override
	public BoardVO selectOne(int bno) {
		log.info("detail check 3");
		return sql.selectOne(NS+"detail",bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("update check 3");
		int isOk = sql.update(NS+"update",bvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int delete(int bno) {
		log.info("delete check 3");
		int isOk = sql.delete(NS+"delete",bno);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int updateCount(int bno) {
		int isOk = sql.update(NS+"count",bno);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int selectCount() {		
		return sql.selectOne(NS+"cnt");
	}

	@Override
	public List<BoardVO> selectList(PagingVO pgvo) {		
		return sql.selectList(NS+"pagingList", pgvo);
	}
	
	@Override
	public List<BoardVO> selectList(String email) {		
		return sql.selectList(NS+"MyList", email);
	}

	@Override
	public String selectImageFile(int bno) {		
		return sql.selectOne(NS+"imgFile",bno);
	}
}