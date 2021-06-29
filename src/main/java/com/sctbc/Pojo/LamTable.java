package com.sctbc.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LamTable {
    private String id;//留言id
    private String fromid;//发送人id
    private String toid;//接收人id
    private String content;//发送内容
    private Date lamtime;//发送时间
    private int recive;//是否已读
    private String reciveContent;//回复内容
}
