package com.sctbc.Dao;


import com.sctbc.Pojo.WorkCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface WorkCountMapper {

    //添加学生
    int InsertData(WorkCount workCount);

    //删除学生
    int DeleteData(Map<String, String> map);


}
