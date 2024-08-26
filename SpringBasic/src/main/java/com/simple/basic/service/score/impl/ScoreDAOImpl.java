package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.basic.command.ScoreVO;

@Repository("y") //component-scan에 읽혀야함
public class ScoreDAOImpl implements ScoreDAO{

	//DB
	ArrayList<ScoreVO> list = new ArrayList<>();
	
	@Override
	public void regist(ScoreVO vo) {
		
		//list.add(vo); //insert 완료
		//insert 작업
	}

	@Override
	public ArrayList<ScoreVO> getScore() {
		//select..
		return list;
	}

	@Override
	public void delete(int sno) {
		//list.remove(sno); //인덱스 번호로 삭제
		//remove작업
	}

}
