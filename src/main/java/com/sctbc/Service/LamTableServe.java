package com.sctbc.Service;


import com.sctbc.Dao.LamTableMapper;
import com.sctbc.Pojo.LamTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LamTableServe {
    @Autowired
    private LamTableMapper lamTableMapper;

    //查询所有的留言
    public List<LamTable> getLamTableList(){
        return lamTableMapper.getLamTableList();
    }
//
//    //根据id查询留言
//    public LamTable getLamTableById(String id){
//        return lamTableMapper.getLamTableById(id);
//    }
//
//
//    //根据教师id查询留言
//    public LamTable getLamTableByTid(String tid){
//        return lamTableMapper.getLamTableByTid(tid);
//    }
//
//    //根据学生
//    public LamTable getLamTableBySid(String sid){
//        return lamTableMapper.getLamTableBySid(sid);
//    }
//
//    //查询还没有回复的信息
//    public List<LamTable> getLamTableListByNorecive(int recive){
//        return lamTableMapper.getLamTableListByNorecive(recive);
//    }
//
//    //新增一条留言
//    public int InsertLamTable(LamTable lamTable){
//        return lamTableMapper.InsertLamTable(lamTable);
//    }
//
//    //删除一条留言
//    public int DeleteLamTable(String id){
//        return lamTableMapper.DeleteLamTable(id);
//    }
//
//    //回复留言
//    public int UpdateLamTable(Map<String, String> map){
//        return lamTableMapper.UpdateLamTable(map);
//    }

}
