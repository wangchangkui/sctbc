package com.sctbc.Pojo.outline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStudyHabitsOtl {

    private String name;//签到名称或作业名称
    private String flag;//签到情况或作业情况
    private String time;//签到时间或作业时间

}
