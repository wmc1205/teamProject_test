package com.wmc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wmc.member.MemberDTO;
import com.wmc.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;
	
	//회원가입
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = memberService.join(dto);
		System.out.println(row != 0 ? "가입 성공" : "가입 실패");
		return "redirect:/member/login";
	}
	//로그인
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(String url, HttpSession session, MemberDTO dto) {
		MemberDTO login = memberService.login(dto);
		session.setAttribute("login", login);
		return "redirect:" +(url == null? "/":url);
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/login";
	}
}
