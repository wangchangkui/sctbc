package com.sctbc.Service.outline;

import com.sctbc.Dao.Stu_classOtlMapper;
import com.sctbc.Pojo.outline.Stu_classOtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Stu_classOtlServer {
    @Autowired
    private Stu_classOtlMapper stu_classMapper;

    /**
     * 根据教师id查询教师所管理的班级信息
     * @param teaid
     * @return
     */
    public List<Stu_classOtl> queryStuOtlClass(String teaid){
        return stu_classMapper.queryStuOtlClass(teaid);
    }
}
