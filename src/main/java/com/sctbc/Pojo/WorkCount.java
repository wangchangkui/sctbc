package com.sctbc.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkCount {
    private String id; //表ID
    private String StudentID; //学生ID
    private String studentName; //学生名称
    private String SpecialID;//专业ID
    private String classID;//班级ID
    private String CurrID; //课程ID
    private String WorkName;//作业名称

    private Integer Done;//是否完成
    private String Grende; //作业成绩
    private Date DoneTime;//截至日期
}
