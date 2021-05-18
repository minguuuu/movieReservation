package com.superman.ex.command.reservation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.dao.ReservationDAO;
import com.superman.ex.dto.RoomDTO;
import com.superman.ex.dto.TimeDTO;

public class MovieTicketingRoomCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long movie_id = (long)Integer.parseInt(request.getParameter("title"));
		request.setAttribute("movie_id", movie_id);
		
		ReservationDAO dao = ReservationDAO.getReservationDAO();
	
		ArrayList<RoomDTO> roomList = dao.roomListDAO(movie_id);
		ArrayList<TimeDTO> timeList = dao.timeListDAO(roomList.get(0).getRoom_id());
		
		request.setAttribute("roomList", roomList);
		request.setAttribute("timeList", timeList);
	}
}
