package com.sctbc.Dao;

import com.sctbc.Pojo.Curriculum;
import com.sctbc.Pojo.Stu_class;
import com.sctbc.Pojo.outline.CurriculumOtl;
import com.sctbc.Pojo.outline.Learn_dateOtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 课程
 */
@Mapper
public interface CurriculumMapper {
    /**
     * 根据老师id上传新的课程
     * @param curri
     * @return
     */
    int addCurri(Curriculum curri);

    /**
     * 根据教师id和课程id查询教导班级
     * @param map
     * @return
     */
    List<Stu_class> findClass(Map<String,String> map);

    /**
     * 根据教师id班级id查询所教导的课程
     * @param map
     * @return
     */
    List<Curriculum> findCurri(Map<String,String> map);

    /**
     * 根据教师id，token，班级id，课程id查询课程的学习情况信息
     * @param map
     * @return
     */
    List<CurriculumOtl> findCurriOutline(Map<String,String> map);

    /**
     * 根据教师id，token，班级id，课程id查询上课全体学生
     * @param map
     * @return
     */
    List<Learn_dateOtl> findCurriAllStu(Map<String,String> map);
}
