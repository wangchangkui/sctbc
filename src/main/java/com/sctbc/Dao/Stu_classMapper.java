package com.sctbc.Dao;

import com.sctbc.Pojo.Stu_class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 班级
 */
@Mapper
public interface Stu_classMapper {

    /**
     *  根据教师id，课程id，token新增班级
     * @param map
     * @return
     */
    int addClass(Map<String,String> map);

    List<Stu_class> queryClassIdAndName(Map<String,String> map);

    /**
     *  根据教师id，课程id，token创建班级课表
     * @param map
     * @return
     */
    int addTimetable(Map<String,String> map);
}
