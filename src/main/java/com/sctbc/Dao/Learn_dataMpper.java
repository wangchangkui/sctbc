package com.sctbc.Dao;


import com.sctbc.Pojo.Learn_date;
import com.sctbc.Pojo.outline.Learn_date1Otl;
import com.sctbc.Pojo.outline.Learn_date2Otl;
import com.sctbc.Pojo.outline.Learn_date3Otl;
import com.sctbc.Pojo.outline.Learn_date4Otl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 学习情况数据
 */
@Mapper
public interface Learn_dataMpper {

    //添加数据
    int InsertData(Learn_date learn_date);

    //签到情况
    List<Learn_date1Otl> getSignCount(Map<String,String> map);
    //学生总体成绩
    List<Learn_date2Otl> getStudentLearnDataByInfo(Map<String,String> map);
    //学生作业成绩
    List<Learn_date3Otl> getWorkGrades(Map<String,String> map);
    //学生考试成绩
    List<Learn_date4Otl> getExampleGrades(Map<String,String> map);

    //获取所有的数据
    List<Learn_date> learnDateList();
}
