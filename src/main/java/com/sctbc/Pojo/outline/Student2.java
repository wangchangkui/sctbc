package com.sctbc.Pojo.outline;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    private String name;
    private Integer sex;
    private String class_name;
    private String idcard;
    private String Phone;
    private String address;
    private String EducationSchool;
    private String home_phone;
}
