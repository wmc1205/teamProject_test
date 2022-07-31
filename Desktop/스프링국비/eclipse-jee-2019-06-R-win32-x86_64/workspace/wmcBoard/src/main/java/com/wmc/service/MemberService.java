package com.wmc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmc.component.HashComponent;
import com.wmc.member.MemberDAO;
import com.wmc.member.MemberDTO;

@Service
public class MemberService {
	@Autowired private MemberDAO memberDAO;
	@Autowired private HashComponent hash;
	public int join(MemberDTO dto) {
		String hashpw = hash.getHash(dto.getUserpw());
		dto.setUserpw(hashpw);
		int row = memberDAO.join(dto);
		return row;
	}
	public MemberDTO login(MemberDTO dto) {
		String hashpw = hash.getHash(dto.getUserpw());
		dto.setUserpw(hashpw);
		MemberDTO login = memberDAO.login(dto);
		return login;
	}

}
