package com.sctbc.Service;


import com.sctbc.Dao.CurriculumMapper;
import com.sctbc.Pojo.Curriculum;
import com.sctbc.Pojo.Stu_class;
import com.sctbc.Pojo.outline.CurriculumOtl;
import com.sctbc.Pojo.outline.Learn_dateOtl;
import com.sctbc.Until.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CurriculumServer {
    @Autowired
    private CurriculumMapper curriculumMapper;

    /**
     * 根据老师id上传新的课程
     * @param curri
     * @return
     */
    public int addCurri(Curriculum curri){
        return curriculumMapper.addCurri(curri);
    }

    /**
     * 根据教师id和课程id查询教导班级
     * @param map
     * @return
     */
    public List<Stu_class> findClass(Map<String,String> map){
        return curriculumMapper.findClass(map);
    }

    /**
     * 根据教师id班级id查询所教导的课程
     * @param map
     * @return
     */
    public List<Curriculum> findCurri(Map<String,String> map){
        return curriculumMapper.findCurri(map);
    }

    /**
     * 根据教师id，token，班级id，课程id查询课程的学习情况信息
     * @param map
     * @return
     */
    public List<CurriculumOtl> findCurriOutline(Map<String,String> map){
        return curriculumMapper.findCurriOutline(map);
    }

    /**
     * 根据教师id，token，班级id，课程id查询上课全体学生
     * @param map
     * @return
     */
    public List<Learn_dateOtl> findCurriAllStu(Map<String,String> map){
        return curriculumMapper.findCurriAllStu(map);
    }
}
