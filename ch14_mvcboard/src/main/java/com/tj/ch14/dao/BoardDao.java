package com.tj.ch14.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ch14.dto.Board;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static BoardDao instance = new BoardDao();
	private BoardDao() {
		
	}
	public static BoardDao getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g"); 
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	// 글 목록
	public ArrayList<Board> list(int startRow, int endRow){
		ArrayList<Board> dtos = new ArrayList<Board>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY bGROUP DESC, bSTEP)A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int bId = rs.getInt("bId");
			String bName = rs.getString("bName");
			String bTitle = rs.getString("bTitle");
			String bContent = rs.getString("bContent");
			Date bDate = rs.getDate("bDate");
			int bHit = rs.getInt("bHit");
			int bGroup = rs.getInt("bGroup");
			int bStep = rs.getInt("bStep");
			int bIndent = rs.getInt("bIndent");
			String bIp = rs.getString("bIp");
			dtos.add(new Board(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, bIp));
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return dtos;
	}
	// 글 개수 가져오기
	public int getBoardTotCnt() {
		int totCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT COUNT(*) TOTCNT FROM MVC_BOARD";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			totCnt = rs.getInt("TOTCNT");
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return totCnt;
	}
	// 원글쓰기
	public int write(Board dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="INSERT INTO MVC_BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getbName());
		pstmt.setString(2, dto.getbTitle());
		pstmt.setString(3, dto.getbContent());
		pstmt.setString(4, dto.getbIp());
		result = pstmt.executeUpdate();
		System.out.println(result==SUCCESS?"글쓰기성공":"글쓰기실패");
		}catch(SQLException e) {
			System.out.println("글쓰기실패"+e.getMessage()+dto.toString());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}				
		return result;
	}
	// 글 조회수 올리기
	private void hitUp(int bId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="UPDATE MVC_BOARD SET bHIT = bHIT+1 WHERE bID=?";		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bId);
		pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}				
	}
	// 글 상세보기
	public Board contentView(int bId) {
		hitUp(bId);
		
		Board dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM MVC_BOARD WHERE BID=?";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bId);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String bName = rs.getString("bName");
			String bTitle = rs.getString("bTitle");
			String bContent = rs.getString("bContent");
			Date bDate = rs.getDate("bDate");
			int bHit = rs.getInt("bHit");
			int bGroup = rs.getInt("bGroup");
			int bStep = rs.getInt("bStep");
			int bIndent = rs.getInt("bIndent");
			String bIp = rs.getString("bIp");
			dto = new Board(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, bIp);
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// bId로 dto 가져오기
	public Board modifyView_replyView(int bId) {
		Board dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM MVC_BOARD WHERE BID=?";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bId);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String bName = rs.getString("bName");
			String bTitle = rs.getString("bTitle");
			String bContent = rs.getString("bContent");
			Date bDate = rs.getDate("bDate");
			int bHit = rs.getInt("bHit");
			int bGroup = rs.getInt("bGroup");
			int bStep = rs.getInt("bStep");
			int bIndent = rs.getInt("bIndent");
			String bIp = rs.getString("bIp");
			dto = new Board(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, bIp);
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return dto;
	}
	// 글 수정하기
	public int modify(Board dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="UPDATE MVC_BOARD" + 
				"    SET bNAME = ?," + 
				"        bTITLE = ?," + 
				"        bCONTENT = ?," + 
				"        bIP = ?," + 
				"        bDATE = SYSDATE" + 
				"        WHERE bID = ?";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getbName());
		pstmt.setString(2, dto.getbTitle());
		pstmt.setString(3, dto.getbContent());
		pstmt.setString(4, dto.getbIp());
		pstmt.setInt(5, dto.getbId());
		result = pstmt.executeUpdate();
		System.out.println(result==SUCCESS?"글수정성공":"글수정실패");
		}catch(SQLException e) {
			System.out.println("글수정실패"+e.getMessage()+dto.toString());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}				
		return result;
	}
	// 글 삭제
	public int delete(int bId) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="DELETE FROM MVC_BOARD WHERE bID=?";		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bId);
		result = pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}						
		return result;
	}
	// 답변 달기 stepA
	private void replyStepA(int bGroup, int bStep) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="UPDATE MVC_BOARD SET bSTEP = bSTEP+1 WHERE bGROUP = ? AND bSTEP>?";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bGroup);
		pstmt.setInt(2, bStep);
		pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("stepA실패"+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}			
	}
	// 답변 달기
	public int reply(Board dto) {
		replyStepA(dto.getbGroup(), dto.getbStep());
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="INSERT INTO MVC_BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)\r\n" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getbName());
		pstmt.setString(2, dto.getbTitle());
		pstmt.setString(3, dto.getbContent());
		pstmt.setInt(4, dto.getbGroup());
		pstmt.setInt(5, dto.getbStep()+1);
		pstmt.setInt(6, dto.getbIndent()+1);
		pstmt.setString(7, dto.getbIp());
		result = pstmt.executeUpdate();
		System.out.println(result==SUCCESS?"답변글쓰기성공":"답변글쓰기실패");
		}catch(SQLException e) {
			System.out.println("답변글쓰기실패"+e.getMessage()+dto.toString());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}				
		return result;
	}
}
