package com.sctbc.Service;


import com.sctbc.Dao.Learn_dataMpper;
import com.sctbc.Pojo.CommData.LearnDataByclass;
import com.sctbc.Pojo.Learn_date;
import com.sctbc.Pojo.outline.Learn_date1Otl;
import com.sctbc.Pojo.outline.Learn_date2Otl;
import com.sctbc.Pojo.outline.Learn_date3Otl;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Learn_dateServer {
    @Autowired
    private Learn_dataMpper learn_dataMpper;

    //从excel中导入数据
    public int AddDate(Learn_date date){
        return learn_dataMpper.InsertData(date);
    }

    //根据给定信息查询所有学习数据
    public Map<String,List<?>> getStudentLearnDataByInfo(Map<String,String> map){
        //签到情况
        List<?> signCount = learn_dataMpper.getSignCount(map);
        //学生总体成绩
        List<?> studentLearnDataByInfo = learn_dataMpper.getStudentLearnDataByInfo(map);
        //学生作业成绩
        List<?> workGrades = learn_dataMpper.getWorkGrades(map);
        //学生考试成绩
        List<?> exampleGrades = learn_dataMpper.getExampleGrades(map);

        Map<String,List<?>> studentData = new HashMap<>();
        studentData.put("signCount",signCount);
        studentData.put("studentLearnDataByInfo",studentLearnDataByInfo);
        studentData.put("workGrades",workGrades);
        studentData.put("exampleGrades",exampleGrades);

        return studentData;
    }


}
