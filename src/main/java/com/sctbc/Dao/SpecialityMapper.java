package com.sctbc.Dao;

import com.sctbc.Pojo.Speciality;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 专业
 */
@Mapper
public interface SpecialityMapper {

    /**
     * 根据院系id，查询专业信息
     * @param id
     * @return
     */
    List<Speciality> findSpecialitys(String id);
}
