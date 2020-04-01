package com.tj.ch15.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.tj.ch15.constant.Constant;
import com.tj.ch15.dto.Board;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private JdbcTemplate template;
	
	private static BoardDao instance = new BoardDao();
	private BoardDao() {
		template = Constant.template;
	}
	public static BoardDao getInstance() {
		return instance;
	}
	// 글 목록
	public ArrayList<Board> list(final int startRow, final int endRow){	
		String sql="SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY bGROUP DESC, bSTEP)A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		return (ArrayList<Board>) template.query(sql, new PreparedStatementSetter() {			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, startRow);
				ps.setInt(2, endRow);
			}
		}, new BeanPropertyRowMapper<Board>(Board.class));
	}
	// 글 개수 가져오기
	public int getBoardTotCnt() {
		
		String sql="SELECT COUNT(*) TOTCNT FROM MVC_BOARD";
		return template.queryForInt(sql);
	}
	// 원글쓰기
	public int write(final Board dto) {		
		String sql="INSERT INTO MVC_BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		return template.update(sql, new PreparedStatementSetter() {			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getbName());
				ps.setString(2, dto.getbTitle());
				ps.setString(3, dto.getbContent());
				ps.setString(4, dto.getbIp());				
			}
		});
	}
	// 글 조회수 올리기
	private void hitUp(int bId) {
		String sql="UPDATE MVC_BOARD SET bHIT = bHIT+1 WHERE bID="+bId;		
		template.update(sql);			
	}
	// 글 상세보기
	public Board contentView(int bId) {
		hitUp(bId);	
		String sql="SELECT * FROM MVC_BOARD WHERE BID="+bId;
		return template.queryForObject(sql, new BeanPropertyRowMapper<Board>(Board.class));		
	}
	// bId로 dto 가져오기
	public Board modifyView_replyView(int bId) {		
		String sql="SELECT * FROM MVC_BOARD WHERE BID="+bId;
		return template.queryForObject(sql, new BeanPropertyRowMapper<Board>(Board.class));
	}
	// 글 수정하기
	public int modify(final Board dto) {
		return template.update(new PreparedStatementCreator() {
			String sql="UPDATE MVC_BOARD" + 
					"    SET bNAME = ?," + 
					"        bTITLE = ?," + 
					"        bCONTENT = ?," + 
					"        bIP = ?," + 
					"        bDATE = SYSDATE" + 
					"        WHERE bID = ?";			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getbName());
				ps.setString(2, dto.getbTitle());
				ps.setString(3, dto.getbContent());
				ps.setString(4, dto.getbIp());
				ps.setInt(5, dto.getbId());
				return ps;
			}
		});
	}
	// 글 삭제
	public int delete(int bId) {
		String sql="DELETE FROM MVC_BOARD WHERE bID="+bId;		
		return template.update(sql);
	}
	// 답변 달기 stepA
	private void replyStepA(final int bGroup, final int bStep) {	
		String sql="UPDATE MVC_BOARD SET bSTEP = bSTEP+1 WHERE bGROUP = ? AND bSTEP>?";
		template.update(sql, new PreparedStatementSetter() {		
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, bGroup);
				ps.setInt(2, bStep);
			}
		});
	}
	// 답변 달기
	public int reply(final Board dto) {
		replyStepA(dto.getbGroup(), dto.getbStep());
		String sql="INSERT INTO MVC_BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)\r\n" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		return template.update(sql, new PreparedStatementSetter() {			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getbName());
				ps.setString(2, dto.getbTitle());
				ps.setString(3, dto.getbContent());
				ps.setInt(4, dto.getbGroup());
				ps.setInt(5, dto.getbStep()+1);
				ps.setInt(6, dto.getbIndent()+1);
				ps.setString(7, dto.getbIp());
			}
		});
	}
}
