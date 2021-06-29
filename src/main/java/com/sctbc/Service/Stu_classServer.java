package com.sctbc.Service;

import com.sctbc.Dao.Stu_classMapper;
import com.sctbc.Dao.StudentMapper;
import com.sctbc.Pojo.Stu_class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Stu_classServer {
    @Autowired
    private Stu_classMapper stu_classMapper;

    /**
     * 根据教师id，课程id，token新增班级的同时创建班级课表
     * @param map
     * @return
     */
    public int addClassAndTimetable(Map<String,String> map){
        return stu_classMapper.addClass(map) + stu_classMapper.addTimetable(map) - 1;
    }

    public List<Stu_class> queryClassIdAndName(Map<String,String> map){
        return stu_classMapper.queryClassIdAndName(map);
    }
}
