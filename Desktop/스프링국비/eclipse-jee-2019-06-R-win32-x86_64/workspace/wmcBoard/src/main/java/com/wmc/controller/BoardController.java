package com.wmc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wmc.board.BoardDTO;
import com.wmc.board.Paging;
import com.wmc.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired BoardService boardService;

//게시글 리스트
@GetMapping("")
public ModelAndView board(@RequestParam HashMap<String, Object> param,
						@RequestParam(defaultValue="1")Integer page) {
	System.out.println(param);//param -> key : 검색(String) value: 검색 대상(Object) 
	ModelAndView mav = new ModelAndView("/board/list");
	//페이지를 위한 게시글 개수를 조회하는 메서드 호출
	int boardCount = boardService.selectBoardCount(param);
	
	page = page == null ? 1: page; // 페이지 지정되어있지 않다면 1이 기본값
	Paging paging = new Paging(page, boardCount);	//페이지 객체 생성
	param.put("paging",paging);		//페이지 리스트를 불러오기 위해 param(boardList)을 포함시킨다.
	
	List<BoardDTO> list = boardService.selectList(param);
	mav.addObject("list",list);
	mav.addObject("paging",paging);
	return mav;
}
//게시글 조회
@GetMapping("/view/{idx}")
public ModelAndView view(@PathVariable int idx, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView("board/view");
	
	//새로고침 시, 조회 수 증가 x 로직
	String referer = request.getHeader("referer");
	String requestURL = request.getRequestURL().toString();
	System.out.println("referer: " + referer); //이전 주소
	System.out.println("requestURL" + requestURL); //현재 주소
	System.out.println();
	
	if(requestURL.equals(referer.split("\\?")[0]) == false) { //쿼리스트링을 자르기 위해서 split사용 "?"는 특수문자이기 때문에 \\을 앞에 붙여준다.
		boardService.addViewCount(idx);		
		mav.addObject("url","board/view/" + idx);
		mav.setViewName("rd");
		return mav;
	}
	BoardDTO dto = boardService.viewBoard(idx);
	mav.addObject("dto",dto);
	return mav;
}
@GetMapping("/write")
public void write() {}


@PostMapping("/write")
public String write(BoardDTO dto) throws IllegalStateException, IOException {
	int row = boardService.write(dto);
	System.out.println(row != 0? "작성 성공" : "작성 실패");
	return "redirect:/board/";
}
@GetMapping("/update/{idx}")
public ModelAndView update(@PathVariable int idx) {
	ModelAndView mav = new ModelAndView("board/update");
	BoardDTO dto= boardService.viewBoard(idx);
	mav.addObject("dto",dto);
	return mav;
}
@PostMapping("/update/{idx}")
public String update(BoardDTO dto) {
	int row = boardService.update(dto);
	System.out.println(row != 0? "업뎃 성공" : "업뎃 실패");
	return "redirect:/board/view/" + dto.getIdx();

	
}
@GetMapping("/delete/{idx}")
public String delete(BoardDTO dto) {
	int row = boardService.delete(dto);
	System.out.println(row !=0? "삭제 성공" : "삭제 실패");
	return "redirect:/board";
}
}
