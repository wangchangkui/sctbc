package com.sctbc.Service.student;


import com.sctbc.Dao.CurriculumMapper;
import com.sctbc.Dao.StudentCurriculumMapper;
import com.sctbc.Pojo.Curriculum;
import com.sctbc.Pojo.Stu_class;
import com.sctbc.Pojo.outline.CurriculumOtl;
import com.sctbc.Pojo.outline.Learn_dateOtl;
import com.sctbc.Pojo.student.StudentCurriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentCurriculumServer {
    @Autowired
    private StudentCurriculumMapper studentCurriculumMapper;

    public List<StudentCurriculum> findCurri(String id){
        return studentCurriculumMapper.findCurri(id);
    }
}
