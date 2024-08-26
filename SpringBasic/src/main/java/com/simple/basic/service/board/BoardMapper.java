package com.simple.basic.service.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.BoardVO;

@Mapper
public interface BoardMapper {
	
	public void register(BoardVO vo);
	public ArrayList<BoardVO> getBoard();
	public void delete(int num);


}
