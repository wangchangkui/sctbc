package com.sctbc.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {
    private String id;
    private String name;
    private Integer sex;
    private String fac_id;
    private String phone;
    private String password;
    private Integer flag_id;
}
