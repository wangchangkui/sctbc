package com.sctbc.Service;


import com.sctbc.Dao.FileMapper;
import com.sctbc.Pojo.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServer {
    @Autowired
    private FileMapper fileMapper;

    //获取所有的文件
    public List<File> getallFiles(){
        return fileMapper.FileList();
    }

    //上传文件到数据库
    public int InsertFile(File file){
        return fileMapper.InsertFile(file);
    }

}
