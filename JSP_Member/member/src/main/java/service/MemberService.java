package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	int register(MemberVO memberVO);

	MemberVO login(MemberVO memberVO);

	List<MemberVO> getList();

	int modify(MemberVO memberVO);

	int remove(String id);

}
