package com.sctbc.Dao;

import com.sctbc.Pojo.Faculty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *院系
 */
@Mapper
public interface FacultyMapper {

    /**
     * 验证教师token，查询学校院系信息
     * @return
     */
    List<Faculty> findFacultys();
}
