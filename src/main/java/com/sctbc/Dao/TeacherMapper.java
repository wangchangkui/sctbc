package com.sctbc.Dao;

import com.sctbc.Pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 教师信息
 */
@Mapper
public interface TeacherMapper {
    /**
     * 获取全部教师信息
     * @return
     */
    List<Teacher> queryTeacherList();

    /**
     * 添加教师
     * @return
     */
    void saveTeacher(Teacher teacher);

    /**
     * 根据ID查询教师信息
     * @return
     */
    Teacher getTeacherById(String id);

    /**
     * 修改教师信息
     * @return
     */
    void updateTeacher(Teacher teacher);

    /**
     * 模糊查询教师信息
     * @return
     */
    List<Teacher> getTeacherListLike(String name);

    /**
     * 分页查询教师信息
     * @return
     */
    List<Teacher> getTeacherListByLimit(Map<String,Integer> map);

    /**
     * 教师登录查询
     * @return
     */
    Teacher selectTeacher(String userid,String password);
}
