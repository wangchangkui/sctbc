package com.sctbc.Pojo.outline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumOtl {

    private float task_point;//任务完成进度
    private float videos_point;//视频完成进度
    private float hoemwork_point;//作业完成进度
    private float chapter_point;//章节测试完成进度
    private float sign_point;//签到进度
}
