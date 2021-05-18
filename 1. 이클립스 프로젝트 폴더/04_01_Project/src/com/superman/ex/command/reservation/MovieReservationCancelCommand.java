package com.superman.ex.command.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.dao.MovieDAO;
import com.superman.ex.dao.ReservationDAO;
import com.superman.ex.dto.ReservationDataDTO;

public class MovieReservationCancelCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationDAO dao = ReservationDAO.getReservationDAO();
		dao.deleteReservationDAO((long)Integer.parseInt(request.getParameter("seat_id")));
	}
}
