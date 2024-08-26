package com.simple.basic.service.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.BoardVO;

@Service("a")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public void register(BoardVO vo) {
		boardMapper.register(vo);
	}

	@Override
	public ArrayList<BoardVO> getBoard() {
		return boardMapper.getBoard();
	}

	@Override
	public void delete(int num) {
		boardMapper.delete(num);
	}

}
