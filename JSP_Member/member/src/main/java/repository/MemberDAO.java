package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO login(MemberVO mvo);

	List<MemberVO> selectList();

	int update(MemberVO mvo);

	int remove(String id);

}
