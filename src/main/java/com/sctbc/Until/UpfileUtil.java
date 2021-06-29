package com.sctbc.Until;


import com.github.xiaoymin.swaggerbootstrapui.io.ResourceUtil;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.util.UUID;

//文件上传工具类
public class UpfileUtil {

    //文件根目录
    private static String classpath="";
    private static ExcelUtil excelUtil;

    //静态代码块 初始值获取文件路径
    static {
        classpath="/www/wwwroot/iwck.top/springboot/";
        excelUtil=new ExcelUtil();
    }


    //单文件上传
    public static String upfile(MultipartFile file){
        //获取文件的名称
        String filename=file.getOriginalFilename();
        String fileext=filename.substring(filename.lastIndexOf("."));
        filename=UUID.randomUUID().toString().replace("-","").toLowerCase(); //随机生成文件名
        //文件的地址
        String filePath=classpath+"file"+File.separator+"common";
        String res=filename+fileext;
        File Upfile=new File(filePath+File.separator+res);
        try {
            file.transferTo(Upfile);
        } catch (IOException e) {
            res="文件上传失败"+classpath+"||";
            e.printStackTrace();
        }
        return res;
    }

    //excel导入数据库
    public static String TransDB(MultipartFile file) throws IOException, ParseException {
        //获取文件名
        String filename=file.getOriginalFilename();

        //获取后缀
        String ext=filename.substring(filename.lastIndexOf("."));
        System.out.println(ext);
        //判断文件类型
        if(!ext.equals(".xlsx")){
            return "非excel文件不能解析";
        }
        //首先上传到服务器
        String res = upfile(file);
        //拿到这个文件
        String filePath=classpath+"file"+File.separator+"common";

        File excelfile = new File(filePath+File.separator+res);
        if(!excelfile.exists()){
            return "内部程序出现问题";
        }
        InputStream inputStream = new FileInputStream(excelfile);

        excelUtil.ExcelToDBByStudent(inputStream);
        //删除文件
        excelfile.delete();
        return "数据导入成功";
    }

    //教师表Excel导入
    public static String TransDBTeacher(MultipartFile file) throws IOException, ParseException {
        //获取文件名
        String filename=file.getOriginalFilename();
        //获取后缀
        String ext=filename.substring(filename.lastIndexOf("."));
        System.out.println(ext);
        //判断文件类型
        if(!ext.equals(".xlsx")){
            return "非excel文件不能解析";
        }
        //首先上传到服务器
        String res = upfile(file);
        //拿到这个文件
        String filePath=classpath+"file"+File.separator+"common";

        File excelfile = new File(filePath+File.separator+res);
        if(!excelfile.exists()){
            return "内部程序出现问题";
        }
        InputStream inputStream = new FileInputStream(excelfile);

        excelUtil.ExcelToDBByTeacher(inputStream);
        //删除文件
        excelfile.delete();
        return "ok";
    }


    //导入学习数据
    public static String TransDBLearn(MultipartFile file) throws IOException, ParseException {
        //获取文件名
        String filename=file.getOriginalFilename();
        //获取后缀
        String ext=filename.substring(filename.lastIndexOf("."));
        System.out.println(ext);
        //判断文件类型
        if(!ext.equals(".xlsx")){
            return "非excel文件不能解析";
        }
        //首先上传到服务器
        String res = upfile(file);
        //拿到这个文件
        String filePath=classpath+"file"+File.separator+"common";

        File excelfile = new File(filePath+File.separator+res);
        if(!excelfile.exists()){
            return "内部程序出现问题";
        }
        InputStream inputStream = new FileInputStream(excelfile);
        //调用方法
        excelUtil.ExcelToDBByLearn(inputStream);
        //删除文件
        excelfile.delete();
        return "ok";
    }

    //导入学生的作业数据
    public static String TransDBStudentWork(MultipartFile file) throws IOException, ParseException {
        //获取文件名
        String filename=file.getOriginalFilename();
        //获取文件的后缀
        String ext=filename.substring(filename.lastIndexOf("."));
        //判断文件
        if(!ext.equals(".xlsx")){
            return "非excel文件禁止上传";
        }
        //先上传到服务器
        String res = upfile(file);

        //filename=res;
        //将文件转入
        String filePath=classpath+"file"+File.separator+"common";

        File excelfile = new File(filePath+File.separator+res);
        if(!excelfile.exists()){
            return "内部程序出现问题";
        }
        InputStream inputStream = new FileInputStream(excelfile);

        excelUtil.ExcelToStudentWork(inputStream);
        excelfile.delete();
        return "执行成功";
    }

    //导入学生的成绩数据
    public static String TransDBStudentExample(MultipartFile file) throws IOException, ParseException {
        //获取文件名
        String filename=file.getOriginalFilename();
        //获取文件的后缀
        String ext=filename.substring(filename.lastIndexOf("."));
        //判断文件
        if(!ext.equals(".xlsx")){
            return "非excel文件禁止上传";
        }
        //先上传到服务器
        String res = upfile(file);

        //filename=res;
        //将文件转入
        String filePath=classpath+"file"+File.separator+"common";

        File excelfile = new File(filePath+File.separator+res);
        if(!excelfile.exists()){
            return "内部程序出现问题";
        }
        InputStream inputStream = new FileInputStream(excelfile);
        excelUtil.ExcelToExample(inputStream);
        excelfile.delete();
        return "执行成功";
    }


    //导入学生的签到数据
    public static String TransDBStudentSign(MultipartFile file) throws IOException, ParseException {
        //获取文件名
        String filename=file.getOriginalFilename();
        //获取文件的后缀
        String ext=filename.substring(filename.lastIndexOf("."));
        //判断文件
        if(!ext.equals(".xlsx")){
            return "非excel文件禁止上传";
        }
        //先上传到服务器
        String res = upfile(file);

        //将文件转入
        String filePath=classpath+"file"+File.separator+"common";

        File excelfile = new File(filePath+File.separator+res);
        if(!excelfile.exists()){
            return "内部程序出现问题";
        }
        InputStream inputStream = new FileInputStream(excelfile);
        //上传签到数据
        excelUtil.ExcelToSign(inputStream);
        excelfile.delete();
        return "执行成功";
    }


    //全新文件上传 导入学生数据
    public static String NewTransDbtoLearnData(MultipartFile file,String CurID) throws IOException {
        String fileName=file.getOriginalFilename();
        System.out.println(fileName);
        String ext=fileName.substring(fileName.lastIndexOf("."));
        if(!ext.equals(".xlsx")){
            return "非Excel不能解析";
        }
        InputStream inputStream=null;
        File file1=File.createTempFile("temp",null);
        file.transferTo(file1);
        inputStream=new FileInputStream(file1);
        excelUtil.NewTransDBtoLearnData(inputStream,CurID);
        file1.delete();
        return "执行成功";
    }

    //全新导入学生作业数据
    public static String NewTransDBtoWork(MultipartFile file,String classID,String CurID) throws IOException, ParseException {
        String fileName=file.getOriginalFilename();
        System.out.println(fileName);
        String ext=fileName.substring(fileName.lastIndexOf("."));
        if(!ext.equals(".xlsx")){
            return "非Excel不能解析";
        }
        InputStream inputStream=null;
        File file1=File.createTempFile("temp",null);
        file.transferTo(file1);
        inputStream=new FileInputStream(file1);

        excelUtil.NewTransDBtoWork(inputStream,classID,CurID);
        file1.delete();
        return "执行成功";
    }

    public static String NewTransDBtoExample(MultipartFile file,String classID,String CurID) throws IOException, ParseException {
        String fileName=file.getOriginalFilename();
        System.out.println(fileName);
        String ext=fileName.substring(fileName.lastIndexOf("."));
        if(!ext.equals(".xlsx")){
            return "非Excel不能解析";
        }
        InputStream inputStream=null;
        File file1=File.createTempFile("temp",null);
        file.transferTo(file1);
        inputStream=new FileInputStream(file1);

        excelUtil.NewTransDBtoExample(inputStream,classID,CurID);
        file1.delete();
        return "执行成功";
    }

    public static String NewTransDBToSign(MultipartFile file,String classID,String CurID) throws IOException, ParseException {
        String fileName=file.getOriginalFilename();
        System.out.println(fileName);
        String ext=fileName.substring(fileName.lastIndexOf("."));
        if(!ext.equals(".xlsx")){
            return "非Excel不能解析";
        }
        InputStream inputStream=null;
        File file1=File.createTempFile("temp",null);
        file.transferTo(file1);
        inputStream=new FileInputStream(file1);

        excelUtil.NewTransDBtoSign(inputStream,classID,CurID);
        file1.delete();
        return "执行成功";
    }
}
