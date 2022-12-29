package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	private SqlSession sql;	//import!!
	private final String NS = "BoardMapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder(); //orm -> db 연결 클래스 객체 생성
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(BoardVO bvo) {
		log.info("insert check 3");		
		int isOk = sql.insert(NS+"add",bvo); 
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

}
