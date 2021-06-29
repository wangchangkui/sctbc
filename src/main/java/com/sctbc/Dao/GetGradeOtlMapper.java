package com.sctbc.Dao;

import com.sctbc.Pojo.outline.GetGradeOtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GetGradeOtlMapper {

    List<GetGradeOtl> queryGradeClassByInfo(Map<String,String> map);
    List<GetGradeOtl> queryUsualGradeClassByInfo(Map<String,String> map);
    List<GetGradeOtl> queryExamGradeClassByInfo(Map<String,String> map);
    List<GetGradeOtl> queryHomeworkGradeClassByInfo(Map<String,String> map);

    Map<String,String> queryGradeStudentByInfo(Map<String,String> map);
    List<GetGradeOtl> queryUsualGradeStudentByInfo(Map<String,String> map);
    List<GetGradeOtl> queryExamGradeStudentByInfo(Map<String,String> map);
    List<GetGradeOtl> queryHomeworkGradeStudentByInfo(Map<String,String> map);
}
