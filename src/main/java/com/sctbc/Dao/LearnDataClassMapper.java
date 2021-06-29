package com.sctbc.Dao;


import com.sctbc.Pojo.CommData.LearnDataByclass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LearnDataClassMapper {

    //查询数据
    LearnDataByclass getLearnDate(int stu_classID);
}
