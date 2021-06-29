package com.sctbc.Service;

import com.sctbc.Dao.SpecialityMapper;
import com.sctbc.Pojo.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServer {
    @Autowired
    private SpecialityMapper specialityMapper;

    /**
     * 根据院系id，查询专业信息
     * @param id
     * @return
     */
    public List<Speciality> findSpecialitys(String id){
        return specialityMapper.findSpecialitys(id);
    }
}
