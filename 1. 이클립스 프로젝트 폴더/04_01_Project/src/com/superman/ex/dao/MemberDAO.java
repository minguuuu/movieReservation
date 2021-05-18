package com.superman.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.superman.ex.dto.MemberDTO;
import com.superman.ex.dto.MovieListDTO;

public class MemberDAO {
	private static MemberDAO memberDAO = new MemberDAO();
	private String CONNECTION_POOL_RESOURCE_NAME = "jdbc/testdb";
	private final String TABLE_NAME = "member";
	private DataSource dataSource;
	private int sizeOfPage = 20;
	String sql;
	
	private final String INSERT_MEMBER_SQL = 
			"INSERT INTO " + TABLE_NAME + " (name, id, pw, email, birthYear, birthMonth, birthDate, cellphone) values(?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE_MEMBER_SQL = 
			"UPDATE " + TABLE_NAME + " SET pw=?, email=?, birthYear=?, birthMonth=?, birthDate=?, cellphone=? WHERE ID = ?";
	private final String LOGIN_MEMBER_SQL = 
			"SELECT * FROM member WHERE id = ? AND pw = ?";
	private MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + CONNECTION_POOL_RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getMemberDAO() {
		return memberDAO;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void memberRegisterDAO(MemberDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(INSERT_MEMBER_SQL);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getEmail());
			pstmt.setInt(5, dto.getBirthYear());
			pstmt.setInt(6, dto.getBirthMonth());
			pstmt.setInt(7, dto.getBirthDate());
			pstmt.setString(8, dto.getCellphone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}		
	}
	
	public void memberModifyDAO(MemberDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(UPDATE_MEMBER_SQL);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getEmail());
			pstmt.setInt(3, dto.getBirthYear());
			pstmt.setInt(4, dto.getBirthMonth());
			pstmt.setInt(5, dto.getBirthDate());
			pstmt.setString(6, dto.getCellphone());
			pstmt.setString(7, dto.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}	
	}
	
	public MemberDTO memberLoginDAO(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(LOGIN_MEMBER_SQL);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setEmail(rs.getString("email"));
				dto.setBirthYear(rs.getInt("birthYear"));
				dto.setBirthMonth(rs.getInt("birthMonth"));
				dto.setBirthDate(rs.getInt("birthDate"));
				dto.setCellphone(rs.getString("Cellphone"));
				dto.setGrade(rs.getInt("grade"));
			} else {
				dto = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return dto;
	}
	
	public ArrayList<MemberDTO> listDAO(int curPage){
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sql = "select * from member order by grade desc limit ?, ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, curPage*sizeOfPage);
			ps.setInt(2, sizeOfPage);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setEmail(rs.getString("email"));
				dto.setBirthYear(rs.getInt("birthYear"));
				dto.setBirthMonth(rs.getInt("birthMonth"));
				dto.setBirthDate(rs.getInt("birthDate"));
				dto.setCellphone(rs.getString("cellphone"));
				dto.setwTime(rs.getString("wTime"));
				dto.setGrade(rs.getInt("grade"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}
	
	
	public int cntOfList() {
		int cnt = 0;
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			sql = "select count(*) from member";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}		
		return cnt;
	}
	
	public int calTotalPage() {
		int numberOfArticles = cntOfList();
		int totalPage = numberOfArticles / sizeOfPage;
		if(numberOfArticles != 0)
			totalPage = numberOfArticles % sizeOfPage == 0 ? totalPage-1 : totalPage;
		
		return totalPage;
	}
	
	public void deleteDAO(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		conn = getConnection();
		try {
			sql = "delete from member WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}		
	}
	
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
		
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(PreparedStatement pstmt, Connection conn){
		
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}