package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;
import service.CommentServiceImpl;

public class CommentDAOImpl implements CommentDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	private SqlSession sql;
	private final String NS = "CommentMapper.";
	private int isOk;
	
	public CommentDAOImpl() {
		new DatabaseBuilder ();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommentVO cvo) {
		log.info("comment >> post >> check 3");
		isOk = sql.insert(NS +"add", cvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public List<CommentVO> selecList(int bno) {
		log.info("comment >> list >> check 3");
		return sql.selectList(NS+"list", bno);
	}

	@Override
	public int delete(int cno) {
		log.info("comment >> remove >> check 3");
		isOk = sql.delete(NS +"del", cno);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int update(CommentVO cvo) {
		log.info("comment >> modify >> check 3");
		isOk = sql.update(NS +"update", cvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int deleteAll(int bno) {
		log.info("comment >> remove >> check 3");
		isOk = sql.delete(NS +"delAll", bno);
		if(isOk>0) sql.commit();
		return isOk;
	}
}
