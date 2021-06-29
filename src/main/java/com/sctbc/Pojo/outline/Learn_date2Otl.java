package com.sctbc.Pojo.outline;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Learn_date2Otl {
    private String stu_id;//学生id
    private String stu_name;//学生姓名

    private String task_point;//任务完成百分比
    private String chapter_num;//章节学习次数
    private String hoemwork_point;//作业完成百分比

    private String WorkCounts;//教师发布作业总数
    private String SignCounts;//教师发布签到总数

    private String learn_dateGrade;//期末成绩
}
