package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	private static MemberDAO instance  = new MemberDAO();
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	//1. DB 연결
	public Connection getConnection() throws Exception{	
		
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String uid = "system";
		String pass = "oracle";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB연결	    
		
		return DriverManager.getConnection(url,uid,pass);
	}

	//userid, pwd 전달받아서, DB랑 연동해서 데이타가 있는지 조회
	public void userCheck(String userid, String pwd) {
		
		/*
		 * 1  : userid, pwd 일치
		 * 0  : userid 일치, pwd 불일치
		 * -1 : userid 불일치 
		 */
		
		int result = -1;
		
		String sql = "select pwd from member where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if ( rs != null) rs.close();
				if ( pstmt != null) pstmt.close();
				if ( conn != null) conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
