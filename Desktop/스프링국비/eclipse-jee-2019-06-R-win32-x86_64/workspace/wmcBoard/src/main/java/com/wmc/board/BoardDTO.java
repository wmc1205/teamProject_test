package com.wmc.board;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

/* 
 * create table board5(
idx number default board_seq.nextval primary key,
category varchar(100) check(category in('전체','공지','일반','등산','게임','여행')),
title varchar(200) not null,
writer varchar(100) ,
content varchar(2000) not null,
writeDate date default sysdate,
viewCount number default 0,
uploadFile varchar(255) ,
ipaddr varchar2(20) not null,
deleted char(1) default'n' check(deleted in('n','y')),
--외래키 설정--
constraint board5_member5_fk
foreign key(writer)
references member5(userid)
on delete set null
);
 */
public class BoardDTO {
	private int idx;
	private String category;
	private String title;
	private String writer;
	private String content;
	private Date writeDate;
	private int viewCount;
	private String uploadFile;
	private MultipartFile upload;//파일 형식 파라미터를 받기 위한 필드
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	private String ipaddr;
	private char deleted;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	
	

}
