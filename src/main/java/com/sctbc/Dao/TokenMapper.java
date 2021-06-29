package com.sctbc.Dao;

import com.sctbc.Pojo.Token;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 *
 */
@Mapper
public interface TokenMapper {
   //往数据库加入Token
    int AddToken(Map map);

    //查询token
    String SelectToken(String token);

    //删除token
    int DeleteToken(String token);

    //查询用户token有没有删除
    Token selectTokenByuserid(String userid);

    //替换token
    int UpdateToken(String token,String userid);
}
