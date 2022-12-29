package repository;

import java.util.List;

import domain.CommentVO;

public interface CommentDAO {

	int insert(CommentVO cvo);

	List<CommentVO> selecList(int bno);

	int delete(int cno);

	int update(CommentVO cvo);

	int deleteAll(int bno);

}
