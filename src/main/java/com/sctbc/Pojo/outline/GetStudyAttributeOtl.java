package com.sctbc.Pojo.outline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStudyAttributeOtl {

    private String stu_name;//学生姓名
    private String task_num;//任务完成数量
    private String task_point;//任务完成进度
    private String homework_averge;//作业平均分
    private String homework_num;//作业完成数量
    private String hoemwork_point;//作业完成进度
    private String Grend;//整体情况

}
