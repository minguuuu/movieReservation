package com.superman.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.command.member.LoginCommand;
import com.superman.ex.command.member.MemberDeleteCommand;
import com.superman.ex.command.member.MemberListCommand;
import com.superman.ex.command.member.MemberModifyOKCommand;
import com.superman.ex.command.member.MemberRegisterOKCommand;
import com.superman.ex.command.movie.MovieAllListCommand;
import com.superman.ex.command.movie.MovieDeleteCommand;
import com.superman.ex.command.movie.MovieListCommand;
import com.superman.ex.command.movie.MovieModifyCommand;
import com.superman.ex.command.movie.MovieModifyOKCommand;
import com.superman.ex.command.movie.MovieRegisterOKCommand;
import com.superman.ex.command.reservation.MovieReservationCancelCommand;
import com.superman.ex.command.reservation.MovieReservationCheckAllCommand;
import com.superman.ex.command.reservation.MovieReservationCheckCommand;
import com.superman.ex.command.reservation.MovieTicketingOKCommand;
import com.superman.ex.command.reservation.MovieTicketingRoomCommand;
import com.superman.ex.command.reservation.MovieTicketingSeatCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		//System.out.println("requestURI " + requestURI);
		String commandName = request.getServletPath();
		//System.out.println("servletPath " +  commandName);

		String viewPage = null;
		Command command = null;
		int flag = 0;
		
		if(commandName.equals("/index.do")) {
			viewPage = "index.jsp";
		} else if(commandName.equals("/login.do")) {
			command = new LoginCommand();
			command.excute(request, response);			
			viewPage = "index.jsp";
		} else if(commandName.equals("/Member/memberRegister.do")) {
			viewPage = "memberRegister.jsp";
		} else if(commandName.equals("/Member/memberRegisterOK.do")) {
			command = new MemberRegisterOKCommand();
			command.excute(request, response);
			viewPage = "../index.jsp";
		} else if(commandName.equals("/Member/memberModify.do")) {
			viewPage = "memberModify.jsp";
		} else if(commandName.equals("/Member/memberModifyOK.do")) {
			command = new MemberModifyOKCommand();
			command.excute(request, response);
			viewPage = "../index.jsp";
		} else if(commandName.equals("/logout.do")) {
			request.getSession().invalidate();
			viewPage = "index.jsp";
		} else if(commandName.equals("/movie/movieMain.do")) {
			viewPage = "movieMain.jsp";
		} else if(commandName.equals("/movie/movieList.do")) {
			command = new MovieListCommand();
			command.excute(request, response);
			viewPage = "movieList.jsp";
			flag = 1;
		} else if(commandName.equals("/movie/managerMain.do")) {
			viewPage = "managerMain.jsp";
		} else if(commandName.equals("/movie/managerMember.do")) {
			command = new MemberListCommand();
			command.excute(request, response);
			viewPage = "managerMember.jsp";
			flag = 1;
		} else if(commandName.equals("/movie/deleteMember.do")) {
			command = new MemberDeleteCommand();
			command.excute(request, response);
			viewPage = "../movie/managerMember.do";
		} else if(commandName.equals("/movie/movieRegister.do")) {
			viewPage = "movieRegister.jsp";
		} else if(commandName.equals("/movie/movieRegisterOK.do")) {
			command = new MovieRegisterOKCommand();
			command.excute(request, response);
			viewPage = "managerMain.jsp";
		} else if(commandName.equals("/movie/movieManage.do")) {
			command = new MovieListCommand();
			command.excute(request, response);
			viewPage = "movieManage.jsp";
			flag = 1;
		} else if(commandName.equals("/movie/movieModify.do")) {
			command = new MovieModifyCommand();
			command.excute(request, response);
			viewPage = "movieModify.jsp";
		} else if(commandName.equals("/movie/movieModifyOK.do")) {
			command = new MovieModifyOKCommand();
			command.excute(request, response);
			viewPage = "../movie/movieManage.do";
		} else if(commandName.equals("/movie/movieDelete.do")) {
			command = new MovieDeleteCommand();
			command.excute(request, response);
			viewPage = "../movie/movieManage.do";
		} else if(commandName.equals("/movie/ticketingMain.do")) {
			command = new MovieAllListCommand();
			command.excute(request, response);
			viewPage = "../movie/ticketingMain.jsp";
			flag = 1;
		} else if(commandName.equals("/movie/theaterManage.do")) {
			viewPage = "../movie/theaterMain.jsp";
		} else if(commandName.equals("/movie/theaterRegister.do")) {
			viewPage = "../movie/theaterRegister.jsp";
		} else if(commandName.equals("/movie/ticketingRoom.do")) {
			command = new MovieTicketingRoomCommand();
			command.excute(request, response);
			viewPage = "../movie/ticketingRoom.jsp";
			flag = 1;
		} else if(commandName.equals("/movie/ticketingSeat.do")) {
			command = new MovieTicketingSeatCommand();
			command.excute(request, response);
			viewPage = "../movie/ticketingSeat.jsp";
			flag =1;
		} else if(commandName.equals("/movie/ticketingOK.do")) {
			command = new MovieTicketingOKCommand();
			command.excute(request, response);
			viewPage = "../movie/reservationCheck.do";
			flag = 1;
		} else if(commandName.equals("/movie/reservationCheck.do")) {
			command = new MovieReservationCheckCommand();
			command.excute(request, response);
			viewPage = "../movie/reservationCheck.jsp";
			flag = 1;
		} else if(commandName.equals("/movie/reservationCheckAll.do")) {
			command = new MovieReservationCheckAllCommand();
			command.excute(request, response);
			viewPage = "../movie/reservationCheckAll.jsp";
			flag = 1;
		} else if(commandName.equals("/movie/deleteReservation.do")) {
			command = new MovieReservationCancelCommand();
			command.excute(request, response);
			viewPage = "../movie/reservationCheck.do";
			flag = 1;
		} else if(commandName.equals("/movie/deleteReservation_manager.do")) {
			command = new MovieReservationCancelCommand();
			command.excute(request, response);
			viewPage = "../movie/reservationCheckAll.do";
			flag = 1;
		}

		//System.out.println(viewPage);
		if(flag==0) {
			response.sendRedirect(viewPage);
		} else if(flag==1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);			
		}		
	}
}