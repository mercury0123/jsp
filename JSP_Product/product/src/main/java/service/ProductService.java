package service;

import java.util.List;

import domain.ProductVO;
import repository.DAO;
import repository.ProductDAO;

public class ProductService implements Service {

	private DAO dao;
	
	public ProductService() {
		dao = new ProductDAO();
	}

	@Override
	public int register(ProductVO pvo) {
		System.out.println("등록 service 진입 성공");
		return dao.insert(pvo);
	}

	@Override
	public List<ProductVO> list() {
		System.out.println("상품목록 service 진입 성공");
		return dao.selectList();
	}

	@Override
	public ProductVO detail(int pno) {
		System.out.println("상품 상세목록 service 진입 성공");
		return dao.selectOne(pno);
	}

	@Override
	public int edit(ProductVO pvo) {
		System.out.println("수정 service 진입 성공");
		return dao.update(pvo);	//메소드 생성 dao
	}

	@Override
	public int remove(int pno) {
		System.out.println("삭제 service 진입 성공");
		return dao.remove(pno);	//메소드 생성 dao
	}
}
