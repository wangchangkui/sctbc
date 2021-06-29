package com.sctbc.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speciality {
    private String id;//专业ID
    private String name;//专业名称
    private String fac_id;//系部ID
}
