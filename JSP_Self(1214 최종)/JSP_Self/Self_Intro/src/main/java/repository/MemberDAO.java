package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	MemberVO selectOne(MemberVO mvo);

	int insert(MemberVO mvo);

	int update(String email);

	List<MemberVO> selectList();

	int update(MemberVO mvo);

	int delete(String email);

}
