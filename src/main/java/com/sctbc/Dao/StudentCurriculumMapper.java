package com.sctbc.Dao;

import com.sctbc.Pojo.Curriculum;
import com.sctbc.Pojo.Stu_class;
import com.sctbc.Pojo.outline.CurriculumOtl;
import com.sctbc.Pojo.outline.Learn_dateOtl;
import com.sctbc.Pojo.student.StudentCurriculum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 课程
 */
@Mapper
public interface StudentCurriculumMapper {

    List<StudentCurriculum> findCurri(String id);
}
