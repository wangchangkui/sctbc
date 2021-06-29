package com.sctbc.Service;


import com.sctbc.Dao.LamTableMapper;
import com.sctbc.Pojo.LamTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class LamTableServer {
    @Autowired
    private LamTableMapper lamTableMapper;

    public List<LamTable> findLam(Map<String,String> map){
        return lamTableMapper.findLam(map);
    }

    public List<LamTable> findGetLam(String id){
        return lamTableMapper.findGetLam(id);
    }

    public int sendLam(Map<String,String> map){
        return lamTableMapper.sendLam(map);
    }
}
