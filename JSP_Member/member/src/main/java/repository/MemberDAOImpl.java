package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {

	private SqlSession sql;
	private final String NS = "MemberMapper."; //mapper의 네임스페이스 
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		int isOk = sql.insert(NS+"add",mvo);
		if(isOk>0)sql.commit();
		return isOk;
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	public List<MemberVO> selectList() {
		return sql.selectList(NS+"list");
	}

	@Override
	public int update(MemberVO mvo) {
		int isOk = sql.update(NS+"up", mvo);
		if(isOk>0)sql.commit();
		return isOk;
	}

	@Override
	public int remove(String id) {
		int isOk = sql.delete(NS+"del", id);
		if(isOk>0)sql.commit();
		return isOk;
	}
	
	
}
