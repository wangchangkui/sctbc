package com.sctbc.Dao;

import com.sctbc.Pojo.outline.GetStudyAttributeOtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface GetStudyAttributeOtlMapper {


    Map<String,Long> queryStudentSignTrue(Map<String,String> map);
    Map<String,Long> queryStudentSignAll(Map<String,String> map);
    //获取学生的学习态度
    GetStudyAttributeOtl queryStudyAttribute(Map<String,String> map);


}
