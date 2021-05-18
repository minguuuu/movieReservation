package com.superman.ex.command.reservation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.dao.ReservationDAO;
import com.superman.ex.dto.SeatDTO;

public class MovieTicketingSeatCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long time_id = (long)Integer.parseInt(request.getParameter("time"));

		ReservationDAO dao = ReservationDAO.getReservationDAO();
		ArrayList<SeatDTO> dto = dao.seatListDAO(time_id);
		
		request.setAttribute("time_id", time_id);
		request.setAttribute("dto", dto);
	}
}
