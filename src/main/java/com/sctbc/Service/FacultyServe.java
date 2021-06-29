package com.sctbc.Service;

import com.sctbc.Dao.FacultyMapper;
import com.sctbc.Pojo.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServe {

    @Autowired
    private FacultyMapper facultyMapper;

    /**
     * 验证教师token，查询学校院系信息
     * @return
     */
    public List<Faculty> findFacultys(){
        return facultyMapper.findFacultys();
    }
}
