package com.superman.ex.command.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.superman.ex.command.Command;
import com.superman.ex.dao.MemberDAO;
import com.superman.ex.dto.MemberDTO;

public class MemberModifyCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getMemberDAO();
		MemberDTO dto = new MemberDTO();
		HttpSession session = request.getSession();
		
//		dto.setId( ((MemberDTO)session.getAttribute("userInfo") );
	}
}
