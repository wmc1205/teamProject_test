package com.wmc.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO {
	//동적 쿼리 실행을 위해 xml에서 작성
	//@Select("select * from board5 where deleted = 'n' order by idx desc")
	List<BoardDTO> selectList(HashMap<String,Object> param);

	@Update("update board5 set viewCount = viewCount + 1 where idx=#{idx}")
	void addViewCount(int idx);
	
	@Select("select * from board5 where idx=#{idx}")
	BoardDTO selectOne(int idx);
	
	@Insert("insert into board5(category,title,writer,content,uploadFile,ipaddr) "
			+ "values (#{category},#{title},#{writer},#{content},#{uploadFile,jdbcType=VARCHAR},#{ipaddr})")
	int write(BoardDTO dto);
	
	int update(BoardDTO dto);
	
	int delete(BoardDTO dto);
	
	int selectBoardCount(HashMap<String, Object> param);

}
