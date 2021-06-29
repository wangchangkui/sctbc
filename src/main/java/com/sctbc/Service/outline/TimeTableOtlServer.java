package com.sctbc.Service.outline;

import com.sctbc.Dao.TimetableMapper;
import com.sctbc.Dao.TimetableOtlMapper;
import com.sctbc.Pojo.outline.TimetableOtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableOtlServer {
    @Autowired
    private TimetableOtlMapper timetableOtlMapper;

    /**
     * 通过教师id查询课程班级id和名字
     * @param id
     * @return
     */
    public List<TimetableOtl> queryCurriAndClassInfoOtlClassInfo(String id){
        return timetableOtlMapper.queryCurriAndClassInfoOtlClassInfo(id);
    }
}
