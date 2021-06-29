package com.sctbc.Service.outline;

import com.sctbc.Dao.GetStudyAttributeOtlMapper;
import com.sctbc.Pojo.outline.GetStudyAttributeOtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetStudyAttributeOtlServer {
    @Autowired
    private GetStudyAttributeOtlMapper getStudyAttributeOtlMapper;

    //获取学生的学习态度情况
    public Map<String,String> queryStudyAttribute(Map<String,String> map){

        Map<String,String> resultMap = new HashMap<>();

        //得到学生的已签到次数
        Long t = getStudyAttributeOtlMapper.queryStudentSignTrue(map).get("signCountTrue");
        //得到教师发布的签到次数
        Long a = getStudyAttributeOtlMapper.queryStudentSignAll(map).get("signCountAll");
        //签到比率
        Float sign = 0f;
        if(a != 0){
            sign = Float.valueOf(t)/Float.valueOf(a);
            resultMap.put("sign",sign.toString());
        }

        //获取学生信息
        GetStudyAttributeOtl getStudyAttributeOtl = (GetStudyAttributeOtl) getStudyAttributeOtlMapper.queryStudyAttribute(map);

        if(getStudyAttributeOtl != null){
            resultMap.put("stu_name",getStudyAttributeOtl.getStu_name());
            resultMap.put("task_num",getStudyAttributeOtl.getTask_num());
            resultMap.put("task_point",getStudyAttributeOtl.getTask_point());
            resultMap.put("homework_averge",getStudyAttributeOtl.getHomework_averge());
            resultMap.put("homework_num",getStudyAttributeOtl.getHomework_num());
            resultMap.put("hoemwork_point",getStudyAttributeOtl.getHoemwork_point());
            resultMap.put("Grend",getStudyAttributeOtl.getGrend());
        }

        return resultMap;
    }
}
