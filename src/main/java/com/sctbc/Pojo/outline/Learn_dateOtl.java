package com.sctbc.Pojo.outline;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Learn_dateOtl {
    private String stu_id;//学生id
    private String stu_name;//学生姓名
    private Integer task_num;//任务完成数量
    private Integer chapter_num;//章节测试完成数量
    private float chapter_point;//章节测试完成进度
    private Integer chapter_mark;//章节测试平均分
    private Integer homework_num;//作业完成数量
    private float hoemwork_point;//作业完成进度
}
