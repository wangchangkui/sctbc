package com.sctbc.Service;


import com.sctbc.Dao.StudentMapper;
import com.sctbc.Pojo.Student;
import com.sctbc.Pojo.outline.SchoolInfo;
import com.sctbc.Pojo.outline.Student2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServer {

    @Autowired
    private StudentMapper studentMapper;

    //添加一个学生
    public int addStudent(Student student){
        return studentMapper.addStudent(student);
    }

    public List<Student> studentList(){
        return studentMapper.studentList();
    }

    public Student2 findStudentById(String id){
        return studentMapper.findStudentById(id);
    }

    //登录查询
    public Student selectStudent(String userid, String password){
        return studentMapper.selectStudent(userid,password);
    }

    public List<SchoolInfo> searchSchoolInfo(){
        return studentMapper.searchSchoolInfo();
    }

    public int editStudentById(Map<String,String> map){
        return studentMapper.editStudentById(map);
    }
}
