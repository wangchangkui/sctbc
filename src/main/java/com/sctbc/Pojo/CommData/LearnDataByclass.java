package com.sctbc.Pojo.CommData;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//某一个班级的 任务完成数据
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LearnDataByclass {
    private String task_number;//班级任务点对应的平均完成量
    private String task_point;//班级任务完成平均百分比
    private String class_id;//班级的id
    private String name;//班级的名称
}
