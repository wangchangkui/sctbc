package com.sctbc.Pojo.student;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentCurriculum {
    private String id;//课程id
    private String currName;//课程名称
    private String teacherName;//授课教师名
}

