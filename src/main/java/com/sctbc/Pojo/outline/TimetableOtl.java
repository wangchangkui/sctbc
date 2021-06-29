package com.sctbc.Pojo.outline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableOtl {
    private String id;//课表id
    private String cur_id;//课程id
    private String class_id;//班级id
    private String cur_name;//课程名
    private String class_name;//班级名
}
