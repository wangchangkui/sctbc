package com.sctbc.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Learn_date {
    private String id;
    private String stu_id;
    private String cur_id;
    private Integer task_num;
    private String task_point;
    private Integer chapter_num;
    private Integer homework_num;
    private String hoemwork_point;
    private float homework_averge;
    private float Grend;
}
