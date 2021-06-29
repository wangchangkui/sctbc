package com.sctbc.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Example {
    private String id;
    private String studentID;
    private String StudentName;
    private String specialID;
    private String ClassID;
    private String CurrID;
    private String ExampleName;
    private String Stats;
    private String Grende;
    private Date UpdateTime;
}
