package com.superman.ex.command.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.superman.ex.command.Command;
import com.superman.ex.dao.MemberDAO;
import com.superman.ex.dto.MemberDTO;

public class MemberModifyOKCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getMemberDAO();
		MemberDTO dto = new MemberDTO();
		HttpSession session = request.getSession();
		
		dto.setName(request.getParameter("name"));
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setEmail(request.getParameter("email"));
		dto.setBirthYear( Integer.parseInt(request.getParameter("birthYear")) );
		dto.setBirthMonth( Integer.parseInt(request.getParameter("birthMonth")) );
		dto.setBirthDate( Integer.parseInt(request.getParameter("birthDate")) );
		dto.setCellphone(request.getParameter("cellphone"));
		dao.memberModifyDAO(dto);
		
		session.setAttribute("userInfo", dto);
	}
}