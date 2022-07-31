package com.wmc.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
	
	//회원가입
	@Insert("insert into member5(userid,userpw,username,email,birth) "
			+ "values (#{userid}, #{userpw}, #{username}, #{email}, #{birth})")
	int join(MemberDTO dto);

	@Select("select * from member5 where userid=#{userid} and userpw = #{userpw}")
	MemberDTO login(MemberDTO dto);

}
