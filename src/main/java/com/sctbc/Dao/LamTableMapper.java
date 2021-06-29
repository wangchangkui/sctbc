package com.sctbc.Dao;

import com.sctbc.Pojo.LamTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 留言表
 */
@Mapper
public interface LamTableMapper {

    List<LamTable> findLam(Map<String,String> map);

    List<LamTable> findGetLam(String id);

    int sendLam(Map<String,String> map);

    List<LamTable> getLamTableList();
}
