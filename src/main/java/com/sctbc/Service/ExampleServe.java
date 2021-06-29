package com.sctbc.Service;


import com.sctbc.Dao.ExampleMapper;
import com.sctbc.Pojo.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExampleServe {


    @Autowired
    private ExampleMapper exampleMapper;

    public int InserExampleleData(Example example){
        return exampleMapper.InsertGrendeData(example);
    }

    public int DeleteExampleData(Map<String, String> map){
        return exampleMapper.DeleteGrendeData(map);
    }
}
