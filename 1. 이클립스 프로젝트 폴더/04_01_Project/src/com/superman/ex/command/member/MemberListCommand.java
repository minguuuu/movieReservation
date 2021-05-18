package com.superman.ex.command.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superman.ex.command.Command;
import com.superman.ex.dao.MemberDAO;
import com.superman.ex.dto.MemberDTO;

public class MemberListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getMemberDAO();
		int curPage = 0;
		if(request.getParameter("curPage") != null)
			curPage = Integer.parseInt(request.getParameter("curPage"));
		ArrayList<MemberDTO> list = dao.listDAO(curPage);
		int totalPage = dao.calTotalPage();
		//System.out.println("totalPage " + totalPage);
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
	}
}
