package com.sctbc.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Timetable {
    private String id; //班级课程ID
    private String cur_id; //课程ID
    private String class_id; //班级ID
    private String tea_id; //教师ID
}
