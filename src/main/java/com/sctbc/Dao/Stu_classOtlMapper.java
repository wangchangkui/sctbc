package com.sctbc.Dao;

import com.sctbc.Pojo.outline.Stu_classOtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 班级
 */
@Mapper
public interface Stu_classOtlMapper {
    /**
     * 根据教师id查询教师所管理的班级信息
     * @param teaid
     * @return
     */
    List<Stu_classOtl> queryStuOtlClass(String teaid);

}
