package com.sctbc.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String name;
    private Integer sex;
    private Integer class_id;
    private String idcard;
    private String Phone;
    private String address;
    private Date Gredeyear;
    private String password;
    private Integer flag_id;
    private String EducationSchool;
    private Integer educationType_id;
    private String agriculture;
    private String home_phone;
    private Integer home_money_id;
}
