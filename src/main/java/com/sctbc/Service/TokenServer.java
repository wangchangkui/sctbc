package com.sctbc.Service;


import com.sctbc.Dao.TokenMapper;
import com.sctbc.Pojo.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TokenServer {
    @Autowired
    private TokenMapper tokenMapper;

    //往token里面插入一条数据
    public int addToken(Map<String, String> map){
        return tokenMapper.AddToken(map);
    }

    //查询token
    public String selectToken(String token){
        return tokenMapper.SelectToken(token);
    }

    //删除token
    public int DeleteToken(String token){
        return tokenMapper.DeleteToken(token);
    }

    //查询token删除没有
    public Token selectTokenByuserid(String userid){
        return tokenMapper.selectTokenByuserid(userid);
    }

    //更新token
    public int UpdateToken(String token,String userid){
        return tokenMapper.UpdateToken(token,userid);
    }
}
