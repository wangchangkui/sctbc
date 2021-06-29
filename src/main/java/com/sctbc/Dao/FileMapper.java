package com.sctbc.Dao;


import com.sctbc.Pojo.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 文件
 */
@Mapper
public interface FileMapper {
    List<File> FileList();

    int InsertFile(File file);
}
