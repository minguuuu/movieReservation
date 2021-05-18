package com.superman.ex.command.movie;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.dao.MovieDAO;
import com.superman.ex.dto.MovieListDTO;

public class MovieAllListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO dao = MovieDAO.getMovieDAO();
		ArrayList<MovieListDTO> list = dao.allListDAO();
		request.setAttribute("list", list);
	}
}
