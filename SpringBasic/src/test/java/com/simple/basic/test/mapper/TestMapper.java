package com.simple.basic.test.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper //왠만하면 맵퍼 뚜껑 달기 (mapper 라는 뜻)
public interface TestMapper {

	public String getTime();
	
	
	
}
