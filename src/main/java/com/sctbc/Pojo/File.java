package com.sctbc.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
    private String id;//文件ID
    private String filename;//文件名称
    private String filelink;//文件地址
    private Date uploadTime;//文件上传的时间
    private String uploadName;//上传用户名称
}
