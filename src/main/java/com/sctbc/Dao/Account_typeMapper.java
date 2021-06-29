package com.sctbc.Dao;


import com.sctbc.Pojo.Account_type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 账号类型
 */
@Mapper
public interface Account_typeMapper {
    //测试
    List<Account_type> findAccType();
}
