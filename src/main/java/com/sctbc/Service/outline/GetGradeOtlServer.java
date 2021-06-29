package com.sctbc.Service.outline;

import com.sctbc.Dao.GetGradeOtlMapper;
import com.sctbc.Dao.Stu_classOtlMapper;
import com.sctbc.Pojo.outline.GetGradeOtl;
import com.sctbc.Pojo.outline.Stu_classOtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetGradeOtlServer {
    @Autowired
    private GetGradeOtlMapper getGradeOtlMapper;

    public List<GetGradeOtl> queryGradeClassByInfo(Map<String,String> map){
        return getGradeOtlMapper.queryGradeClassByInfo(map);
    }
    public List<GetGradeOtl> queryUsualGradeClassByInfo(Map<String,String> map){
        return getGradeOtlMapper.queryUsualGradeClassByInfo(map);
    }
    public List<GetGradeOtl> queryExamGradeClassByInfo(Map<String,String> map){
        return getGradeOtlMapper.queryExamGradeClassByInfo(map);
    }
    public List<GetGradeOtl> queryHomeworkGradeClassByInfo(Map<String,String> map){
        return getGradeOtlMapper.queryHomeworkGradeClassByInfo(map);
    }

    public Map<String, String> queryGradeStudentByInfo(Map<String,String> map){
        return getGradeOtlMapper.queryGradeStudentByInfo(map);
    }
    public List<GetGradeOtl> queryUsualGradeStudentByInfo(Map<String,String> map){
        return getGradeOtlMapper.queryUsualGradeStudentByInfo(map);
    }
    public List<GetGradeOtl> queryExamGradeStudentByInfo(Map<String,String> map){
        return getGradeOtlMapper.queryExamGradeStudentByInfo(map);
    }
    public List<GetGradeOtl> queryHomeworkGradeStudentByInfo(Map<String,String> map){
        return getGradeOtlMapper.queryHomeworkGradeStudentByInfo(map);
    }
}
