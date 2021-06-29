package com.sctbc.Dao;


import com.sctbc.Pojo.Example;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ExampleMapper {

    //导入考试成绩
    int InsertGrendeData(Example example);
    //删除学生成绩
    int DeleteGrendeData(Map<String, String> map);
}
