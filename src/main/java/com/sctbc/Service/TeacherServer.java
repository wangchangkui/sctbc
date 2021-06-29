package com.sctbc.Service;


import com.sctbc.Dao.TeacherMapper;
import com.sctbc.Pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServer {
    @Autowired
    private TeacherMapper teacherMapper;

    //获取所有
    public List<Teacher> queryTeacherList(){
        List<Teacher> queryTeacher=teacherMapper.queryTeacherList();
        return queryTeacher;
    }

    //添加
    public void saveTeacher(Teacher teacher) {
        teacherMapper.saveTeacher(teacher);
    }

    //根据ID查询参数
    public Teacher getTeacherById(String id){
        return teacherMapper.getTeacherById(id);
    }

    //更新用户
    public void updateTeacher(Teacher teacher){
        teacherMapper.updateTeacher(teacher);
    }

    //模糊查询
    public List<Teacher> selectTeacherByLike(String name){
        return teacherMapper.getTeacherListLike(name);
    }

    //分页查询
    public List<Teacher> selectTeacherByLimit(Map<String,Integer> map){
        return teacherMapper.getTeacherListByLimit(map);
    }

    //登录查询
    public Teacher selectTeacher(String userid,String password){
        return teacherMapper.selectTeacher(userid,password);
    }
}
