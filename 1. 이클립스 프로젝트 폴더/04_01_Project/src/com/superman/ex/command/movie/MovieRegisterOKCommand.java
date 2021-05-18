package com.superman.ex.command.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.superman.ex.command.Command;
import com.superman.ex.dao.MovieDAO;
import com.superman.ex.dto.MovieListDTO;

public class MovieRegisterOKCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String savePath = request.getServletContext().getRealPath("poster");
		String savePath = "D:/JavaStudy/JSP/04_01_Project/WebContent/poster";
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		MovieDAO dao = MovieDAO.getMovieDAO();
		MovieListDTO dto = new MovieListDTO();
		dto.setTitle(multi.getParameter("title"));
		dto.setDirector(multi.getParameter("director"));
		dto.setRun_time(Integer.parseInt(multi.getParameter("runtime")));
		dto.setContents(multi.getParameter("contents"));
		
		String fileName = multi.getFilesystemName("poster");
		//String m_fileFullPath = savePath + "/" + fileName;
		dto.setPoster(fileName);
		
		dao.writeOKDAO(dto);	
	}
}
