package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ProductVO;
import orm.DatabaseConnector;

public class ProductDAO implements DAO {
	
	private Connection conn;
	private PreparedStatement pst;
	private String query="";
	
	public ProductDAO() {
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		conn = dbc.getConnection();
	}
	
	// sql 구문 오버라이딩
	
	@Override
	public int insert(ProductVO pvo) {
		System.out.println("dao 진입성공");
		query = "insert into product(pname, price, madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			System.out.println("111");
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeby());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ProductVO> selectList() {
		query = "select * from product order by pno desc";
		
		// 객체를 저장할 리스트
		List<ProductVO> list = new ArrayList<>(); 
		
		try {
			pst = conn.prepareStatement(query);
			
			// ResultSet에 개체 저장
			ResultSet rs = pst.executeQuery();
			
			// 각 개체를 하나씩 분리하여 리스트에 저장
			while(rs.next()) {
				list.add(
						new ProductVO(
								rs.getInt("pno"),
								rs.getString("pname"),
								rs.getString("regdate")
								)
						);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO selectOne(int pno) {
		query = "select * from product where pno=?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new ProductVO(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public int update(ProductVO pvo) {
		query = "update product set pname=?, price=?, madeby=? where pno="+pvo.getPno();
		try {
			pst = conn.prepareStatement(query);			
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeby());
			
			return pst.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int remove(int pno) {
		query = "delete from product where pno="+pno;	//삭제에 pno값만 있으면  
		try {
			pst = conn.prepareStatement(query);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
