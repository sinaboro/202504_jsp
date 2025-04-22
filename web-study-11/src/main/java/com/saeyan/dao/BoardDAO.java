package com.saeyan.dao;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {
	}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	//전체 데이타 가져오기
	//단건 데이타 가져오기
	//데이타 수정하기
	//데이타 추가하기
	//데이타 삭제하기
}
