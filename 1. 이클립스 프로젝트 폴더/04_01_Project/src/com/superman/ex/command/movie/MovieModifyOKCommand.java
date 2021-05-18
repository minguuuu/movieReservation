package com.superman.ex.command.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.superman.ex.command.Command;
import com.superman.ex.dao.MovieDAO;
import com.superman.ex.dto.MovieListDTO;

public class MovieModifyOKCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO dao = MovieDAO.getMovieDAO();
		MovieListDTO dto = new MovieListDTO();
		HttpSession session = request.getSession();
		
		dto.setTitle(request.getParameter("title"));
		dto.setDirector(request.getParameter("director"));
		dto.setRun_time(Integer.parseInt(request.getParameter("runtime")));
		dto.setContents(request.getParameter("contents"));
		dao.movieModifyDAO(dto);
		
		session.setAttribute("movieInfo", dto);
	}

}
