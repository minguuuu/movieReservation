package com.superman.ex.command.reservation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.dao.ReservationDAO;
import com.superman.ex.dto.ReservationDataDTO;

public class MovieReservationCheckAllCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationDAO dao = ReservationDAO.getReservationDAO();
		
		ArrayList<ReservationDataDTO> list = dao.reservationCheckAll(request.getParameter("member_id"));
		
		request.setAttribute("list", list);
	}

}
