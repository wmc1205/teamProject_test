package com.wmc.member;

import java.sql.Date;

/*
 * create table member5(
    idx number  default member5_seq.nextval primary key,
    userid varchar(100) unique not null,
    userpw varchar(200) not null,
    username varchar(200) not null,
    email   varchar(255) not null,
    birth   date  not null,
    deleted char(1)  default 'n' check(deleted in(0,1))
);
 */
public class MemberDTO {
	private int idx;
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private Date birth;
	private String deleted;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
}
