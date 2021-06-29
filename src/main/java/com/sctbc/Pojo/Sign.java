package com.sctbc.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sign {
    private String id;
    private String studentid;
    private String studentName;
    private String ClassID;
    private String SignName;
    private String SignType;
    private String Signflag;
    private Date SignTime;
    private String curriculumID;
}
