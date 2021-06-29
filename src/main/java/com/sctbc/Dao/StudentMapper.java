package com.sctbc.Dao;

import com.sctbc.Pojo.Student;
import com.sctbc.Pojo.outline.SchoolInfo;
import com.sctbc.Pojo.outline.Student2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 学生信息
 */
@Mapper
public interface StudentMapper {

    int addStudent(Student student);

    List<Student> studentList();

    Student2 findStudentById(String id);

    Student selectStudent(String userid, String password);

    List<SchoolInfo> searchSchoolInfo();

    int editStudentById(Map<String,String> map);

}
