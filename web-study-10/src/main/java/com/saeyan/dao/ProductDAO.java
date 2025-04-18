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
	}
}
