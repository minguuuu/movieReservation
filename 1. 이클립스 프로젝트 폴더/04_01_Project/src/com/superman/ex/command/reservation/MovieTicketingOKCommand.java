package com.superman.ex.command.reservation;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.dao.ReservationDAO;
import com.superman.ex.dto.SeatDTO;

public class MovieTicketingOKCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationDAO dao = ReservationDAO.getReservationDAO();
		SeatDTO dto = new SeatDTO();
		
		String seatTemp[] = request.getParameterValues("seat");
		String row = null;
		String column = null;
		
		for(int i=0 ; i<seatTemp.length ; i++) {
			StringTokenizer st = new StringTokenizer(seatTemp[i],",");
			row = st.nextToken();
			column = st.nextToken();

			dto.setMember_id(request.getParameter("member_id"));
			long time_id = (long)Integer.parseInt(request.getParameter("time_id"));
			dto.setTime_id(time_id);
			dto.setRow(Integer.parseInt(row));
			dto.setColumn(Integer.parseInt(column));
			dao.reservationOKDAO(dto);
		}
	}

}
