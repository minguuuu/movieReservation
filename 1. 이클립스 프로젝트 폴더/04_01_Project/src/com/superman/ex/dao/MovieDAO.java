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

import com.superman.ex.dto.MovieListDTO;

public class MovieDAO {
	private static MovieDAO movieDAO = new MovieDAO();
	private int sizeOfPage = 5;
	private String CONNECTION_POOL_RESOURCE_NAME = "jdbc/testdb";
	private DataSource dataSource;
	String sql=null;
	
	private MovieDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + CONNECTION_POOL_RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static MovieDAO getMovieDAO() {
		return movieDAO;
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
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn){
		
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(PreparedStatement ps, Connection conn){
		
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MovieListDTO> allListDAO(){
		ArrayList<MovieListDTO> list = new ArrayList<MovieListDTO>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sql = "select * from movie order by movie_id desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieListDTO dto = new MovieListDTO();
				dto.setMovie_id(rs.getLong("movie_id"));
				dto.setTitle(rs.getString("title"));
				dto.setDirector(rs.getString("director"));
				dto.setRun_time(rs.getInt("run_time"));
				dto.setContents(rs.getString("contents"));
				dto.setPoster(rs.getString("poster"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<MovieListDTO> listDAO(int curPage){
		ArrayList<MovieListDTO> list = new ArrayList<MovieListDTO>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sql = "select * from movie order by movie_id desc limit ?, ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, curPage*sizeOfPage);
			ps.setInt(2, sizeOfPage);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieListDTO dto = new MovieListDTO();
				dto.setMovie_id(rs.getLong("movie_id"));
				dto.setTitle(rs.getString("title"));
				dto.setDirector(rs.getString("director"));
				dto.setRun_time(rs.getInt("run_time"));
				dto.setContents(rs.getString("contents"));
				dto.setPoster(rs.getString("poster"));
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
			sql = "select count(*) from movie";
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
	
	public void writeOKDAO(MovieListDTO dto) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			sql = "insert into movie(title, director, run_time, contents, poster) values(?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getDirector());
			ps.setInt(3, dto.getRun_time());
			ps.setString(4, dto.getContents());
			ps.setString(5, dto.getPoster());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
	}
	
	public void movieModifyDAO(MovieListDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			sql = "update movie set title=?, director=?, run_time=?, contents=? where title=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getDirector());
			pstmt.setInt(3, dto.getRun_time());
			pstmt.setString(4, dto.getContents());
			pstmt.setString(5, dto.getTitle());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}	
	}
	
	public void deleteDAO(String title) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		conn = getConnection();
		try {
			sql = "delete from movie WHERE title=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}		
	}
	
	public int calTotalPage() {
		int numberOfArticles = cntOfList();
		int totalPage = numberOfArticles / sizeOfPage;
		if(numberOfArticles != 0)
			totalPage = numberOfArticles % sizeOfPage == 0 ? totalPage-1 : totalPage;
		
		return totalPage;
	}
}
