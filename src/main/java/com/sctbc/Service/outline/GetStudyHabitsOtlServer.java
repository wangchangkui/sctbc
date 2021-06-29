package com.sctbc.Service.outline;

import com.sctbc.Dao.GetGradeOtlMapper;
import com.sctbc.Dao.GetStudyHabitsOtlMapper;
import com.sctbc.Pojo.outline.GetGradeOtl;
import com.sctbc.Pojo.outline.GetStudyHabitsOtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetStudyHabitsOtlServer {
    @Autowired
    private GetStudyHabitsOtlMapper getStudyHabitsOtlMapper;

    public List<Map<String,String>> queryStudyHabits(Map<String,String> map){
        //将map存放在list中,作为返回值
        List<Map<String,String>> habitsList = new ArrayList<>();
        //获取当前学生的签到数据
        List<GetStudyHabitsOtl> signStudent = getStudyHabitsOtlMapper.queryStudyHabits(map);

        //遍历学生的作业完成情况
        for(int i=0;i<signStudent.size();i++){
            //提取集合中的作业名，到数据库中查询最早和最晚提交作业的数据
            if(signStudent.get(i) != null){
                String signName = signStudent.get(i).getName();
                //构建一个临时map
                Map<String,String> tempMap = map;
                tempMap.put("signName",signName);
                //查最早签到的时间
                GetStudyHabitsOtl early = getStudyHabitsOtlMapper.queryEarlyStudyHabits(tempMap);
                String earlyTime = early.getTime();
                //查最晚签到的时间
                GetStudyHabitsOtl late = getStudyHabitsOtlMapper.queryLateStudyHabits(tempMap);
                String lateTime = late.getTime();

                //封装数据
                Map<String,String> habitsMap = new HashMap<>();
                habitsMap.put("name",signStudent.get(i).getName());
                habitsMap.put("flag",signStudent.get(i).getFlag());
                habitsMap.put("time",signStudent.get(i).getTime());
                habitsMap.put("earlyTime",earlyTime);
                habitsMap.put("lateTime",lateTime);
                habitsList.add(habitsMap);
            }
        }


        return habitsList;
    }

    public List<Map<String,String>> getStudentWorkStat(Map<String,String> map){
        //将map存放在list中,作为返回值
        List<Map<String,String>> habitsList = new ArrayList<>();

        //获取当前学生的作业数据
        List<GetStudyHabitsOtl> workStudent = getStudyHabitsOtlMapper.getStudentWorkStat(map);

        //遍历学生的作业完成情况
        for(int i=0;i<workStudent.size();i++){
            //提取集合中的作业名，到数据库中查询最早和最晚提交作业的数据
            if(workStudent.get(i) != null){
                String workName = workStudent.get(i).getName();
                //构建一个临时map
                Map<String,String> tempMap = map;
                tempMap.put("workName",workName);
                //查最早提交的时间
                GetStudyHabitsOtl early = getStudyHabitsOtlMapper.getEarlyStudentWorkStat(tempMap);
                String earlyTime = early.getTime();
                //查最晚提交的时间
                GetStudyHabitsOtl late = getStudyHabitsOtlMapper.getLateStudentWorkStat(tempMap);
                String lateTime = late.getTime();

                //封装数据
                Map<String,String> habitsMap = new HashMap<>();
                habitsMap.put("name",workStudent.get(i).getName());
                habitsMap.put("flag",workStudent.get(i).getFlag());
                habitsMap.put("time",workStudent.get(i).getTime());
                habitsMap.put("earlyTime",earlyTime);
                habitsMap.put("lateTime",lateTime);
                habitsList.add(habitsMap);
            }
        }

        return habitsList;
    }
}
