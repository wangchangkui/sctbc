package com.sctbc.Dao;

import com.sctbc.Pojo.outline.TimetableOtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 课程表
 */
@Mapper
public interface TimetableOtlMapper {
    /**
     * 通过教师id查询课程班级id和名字
     * @param id
     * @return
     */
    List<TimetableOtl> queryCurriAndClassInfoOtlClassInfo(String id);
}
