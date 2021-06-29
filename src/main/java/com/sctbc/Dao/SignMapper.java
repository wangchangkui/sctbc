package com.sctbc.Dao;


import com.sctbc.Pojo.Sign;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignMapper {

    //添加学生数据
    int InsertSignData(Sign sign);

    //删除学生数据
    int DeletSignData(String classID,String CurrID);
}
