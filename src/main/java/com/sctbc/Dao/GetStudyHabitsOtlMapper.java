package com.sctbc.Dao;

import com.sctbc.Pojo.outline.GetGradeOtl;
import com.sctbc.Pojo.outline.GetStudyHabitsOtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GetStudyHabitsOtlMapper {

    List<GetStudyHabitsOtl> queryStudyHabits(Map<String,String> map);
    GetStudyHabitsOtl queryEarlyStudyHabits(Map<String,String> map);
    GetStudyHabitsOtl queryLateStudyHabits(Map<String,String> map);

    List<GetStudyHabitsOtl> getStudentWorkStat(Map<String,String> map);
    GetStudyHabitsOtl getEarlyStudentWorkStat(Map<String,String> map);
    GetStudyHabitsOtl getLateStudentWorkStat(Map<String,String> map);

}
