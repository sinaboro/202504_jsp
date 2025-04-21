package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO {

	private static ProductDAO instance  = new ProductDAO();
	
	private ProductDAO() {
	}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	// DB에서 전체 목록 가져오기
	public List<ProductVO> selectAllProducts(){
		String sql = "select * from product order by code desc";
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. DB연결
			conn = DBManager.getConnection();
			//2. sql 구문 전송
			pstmt = conn.prepareStatement(sql);
			
			//3. sql 맵핑
			
			//4. sql 실행
			rs = pstmt.executeQuery();
			
			/*
			 * code number(5) primary key,
				name varchar2(100),
				price number(8),
				pictureurl varchar2(50),
				description varchar2(1000)
			 */
			while(rs.next()) {
				ProductVO mVo = new ProductVO();				
			
				mVo.setCode(rs.getInt("code"));
				mVo.setName(rs.getString("name"));
				mVo.setPrice(rs.getInt("price"));
				mVo.setPictureUrl(rs.getString("pictureurl"));
				mVo.setDescription(rs.getString("description"));
				
//				rs.getInt("code");
//				rs.getString("name");
//				rs.getInt("price");
//				rs.getString("pictureurl");
//				rs.getString("description");
				
				list.add(mVo);
			}			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}	
		
		return list;
	}  // end selectAllProducts

	public void insertProduct(ProductVO pVo) {
		String sql = "insert into product values(product_seq.nextval, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1 연결
			conn = DBManager.getConnection();
			//2 sql구문 전송
			pstmt = conn.prepareStatement(sql);
			//3. sql 맵핑
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureUrl());
			pstmt.setString(4, pVo.getDescription());
			
			//4. 실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	} // end insertProduct

	public ProductVO selectProductByCode(String code) {
		
		ProductVO pVo = null;
		
		String sql = "select * from product where code = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1 연결
			conn = DBManager.getConnection();
			//2 sql구문 전송
			pstmt = conn.prepareStatement(sql);
			//3. sql 맵핑
			pstmt.setInt(1,  Integer.parseInt(code));			
			
			//4. 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pVo = new ProductVO();
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureUrl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return pVo;
	}  //end selectOne

	public void updateProduct(ProductVO pVo) {
		
		String sql = "update product set name=?, price=?, pictureurl = ?, description = ? where code = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1 연결
			conn = DBManager.getConnection();
			//2 sql구문 전송
			pstmt = conn.prepareStatement(sql);
			//3. sql 맵핑
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureUrl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.setInt(5, pVo.getCode());
			
			//4. 실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	} // end updateProduct

	public void deleteProductByCode(int code) {
		
		String sql = "delete from product where code = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1 연결
			conn = DBManager.getConnection();
			//2 sql구문 전송
			pstmt = conn.prepareStatement(sql);
			//3. sql 맵핑
			pstmt.setInt(1, code);
			
			//4. 실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		} 
	} // end deleteProductByCode
	
	
}


















