package com.sctbc.Pojo.outline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetGradeOtl {

    private String learn_dateGrade;//期末成绩
    private String WorkGrade;//作业成绩
    private String ExampleGrade;//考试成绩
}
