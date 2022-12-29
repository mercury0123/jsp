package service;

import java.util.List;

import domain.CommentVO;

public interface CommentService {

	int post(CommentVO cvo);	//cvo 수정

	List<CommentVO> getList(int bno); //bno로 수정

	int remove(int cno);

	int update(CommentVO cvo);

}
