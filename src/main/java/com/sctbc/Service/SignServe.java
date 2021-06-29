package com.sctbc.Service;


import com.sctbc.Dao.SignMapper;
import com.sctbc.Pojo.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignServe {

    @Autowired
    private SignMapper signMapper;


    //添加签到数据
    public int InsertSignData(Sign sign){
        return signMapper.InsertSignData(sign);
    }

    //删除学生签到数据
    public int DeleteSignData(String classID,String CurrID){
        return signMapper.DeletSignData(classID,CurrID);
    }
}
