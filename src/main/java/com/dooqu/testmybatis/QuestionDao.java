package com.dooqu.testmybatis;

import org.apache.ibatis.annotations.Mapper;

@Mapper
interface QuestionDao {
    Question getOneQuestion();
}
