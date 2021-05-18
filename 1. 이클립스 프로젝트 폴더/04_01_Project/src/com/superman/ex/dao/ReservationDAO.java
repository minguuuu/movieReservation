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

import com.superman.ex.dto.ReservationDataDTO;
import com.superman.ex.dto.RoomDTO;
import com.superman.ex.dto.SeatDTO;
import com.superman.ex.dto.TimeDTO;

public class ReservationDAO {
	private static ReservationDAO reservationDAO = new ReservationDAO();
	private String CONNECTION_POOL_RESOURCE_NAME = "jdbc/testdb";
	private DataSource dataSource;
	String sql=null;
	
	private ReservationDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + CONNECTION_POOL_RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static ReservationDAO getReservationDAO() {
		return reservationDAO;
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

	public void reservationOKDAO(SeatDTO dto) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			sql = "insert into seat (time_id, seat.row, seat.column, member_id) values(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, dto.getTime_id());
			ps.setInt(2, dto.getRow());
			ps.setInt(3, dto.getColumn());
			ps.setString(4, dto.getMember_id());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
	}

	public ArrayList<RoomDTO> roomListDAO(long movie_id) {
		ArrayList<RoomDTO> list = new ArrayList<RoomDTO>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sql = "select * from room where movie_id="+movie_id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				RoomDTO dto = new RoomDTO();
				dto.setRoom_id(rs.getLong("room_id"));
				dto.setNumber(rs.getInt("number"));
				dto.setMovie_id(rs.getLong("movie_id"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	public ArrayList<TimeDTO> timeListDAO(long room_id) {
		ArrayList<TimeDTO> list = new ArrayList<TimeDTO>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sql = "select * from time where room_id="+room_id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				TimeDTO dto = new TimeDTO();
				dto.setRoom_id(rs.getLong("room_id"));
				dto.setStart_time(rs.getString("start_time"));
				dto.setTime_id(rs.getLong("time_id"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	public ArrayList<SeatDTO> seatListDAO(long time_id) {
		ArrayList<SeatDTO> list = new ArrayList<SeatDTO>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sql = "select * from seat where time_id="+time_id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				SeatDTO dto = new SeatDTO();
				dto.setSeat_id(rs.getLong("seat_id"));
				dto.setTime_id(rs.getLong("time_id"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setColumn(rs.getInt("column"));
				dto.setRow(rs.getInt("row"));
				dto.setArea(rs.getInt("area"));
				dto.setType(rs.getInt("type"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	public ArrayList<ReservationDataDTO> reservationCheck(String member_id) {
		ArrayList<ReservationDataDTO> list = new ArrayList<ReservationDataDTO>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sql = "select * from seat left join time on time.time_id = seat.time_id left join room on room.room_id = time.room_id left join movie on movie.movie_id = room.movie_id where seat.member_id='"+member_id+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ReservationDataDTO dto = new ReservationDataDTO();
				dto.setId(rs.getString("member_id"));
				dto.setTitle(rs.getString("title"));
				dto.setRoom(rs.getInt("number"));
				dto.setTime(rs.getString("start_time"));
				dto.setRow(rs.getInt("row"));
				dto.setColumn(rs.getInt("column"));
				dto.setSeat_id(rs.getLong("seat_id"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<ReservationDataDTO> reservationCheckAll(String member_id) {
		ArrayList<ReservationDataDTO> list = new ArrayList<ReservationDataDTO>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sql = "select * from seat left join time on time.time_id = seat.time_id left join room on room.room_id = time.room_id left join movie on movie.movie_id = room.movie_id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ReservationDataDTO dto = new ReservationDataDTO();
				dto.setId(rs.getString("member_id"));
				dto.setTitle(rs.getString("title"));
				dto.setRoom(rs.getInt("number"));
				dto.setTime(rs.getString("start_time"));
				dto.setRow(rs.getInt("row"));
				dto.setColumn(rs.getInt("column"));
				dto.setSeat_id(rs.getLong("seat_id"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	public void deleteReservationDAO(long seat_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		conn = getConnection();
		try {
			sql = "delete from seat where seat_id="+seat_id;
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}		
	}
}
