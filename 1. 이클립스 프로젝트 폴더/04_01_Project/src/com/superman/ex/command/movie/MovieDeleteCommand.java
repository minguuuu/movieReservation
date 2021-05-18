package com.superman.ex.command.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.dao.MemberDAO;
import com.superman.ex.dao.MovieDAO;

public class MovieDeleteCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO dao = MovieDAO.getMovieDAO();
		dao.deleteDAO(request.getParameter("title"));
	}

}
