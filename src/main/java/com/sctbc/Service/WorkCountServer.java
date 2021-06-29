package com.sctbc.Service;

import com.sctbc.Dao.WorkCountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WorkCountServer {

    @Autowired
    private  WorkCountMapper workCountMapper;

    //添加数据学生的数据
    public int InsertData (com.sctbc.Pojo.WorkCount workCount){
        return workCountMapper.InsertData(workCount);
    }

    //删除学生的数据
    public int DeleteData(Map<String, String> map){
        return workCountMapper.DeleteData(map);
    }
}
