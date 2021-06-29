package com.sctbc.Until;

import com.sctbc.Pojo.*;
import com.sctbc.Service.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ExcelUtil {


    @Autowired
    private StudentServer studentServer;

    @Autowired
    private TeacherServer teacherServer;

    @Autowired
    private Learn_dateServer learn_dateServer;

    @Autowired
    private WorkCountServer workCountServer;

    @Autowired
    private ExampleServe exampleServe;

    @Autowired
    private SignServe signServe;

//    解析excel 传入数据库
    public static ExcelUtil testUtils;

//    普通的工具类 无法调用serveice层 需要通过加入Component容器 在通过控制反转 才能调用service层数据
    @PostConstruct
    private void init(){
        testUtils=this;
    }

    //(废弃)
    public int ExcelToDBByStudent(InputStream in) throws IOException, ParseException {
        Workbook Wook = new XSSFWorkbook(in);
        Sheet sheetAt = Wook.getSheetAt(0); //设置指定的表
        List<Student> list=new ArrayList<>();
        Row row=null;
        Cell cell=null;
        for(int i=1;i<=sheetAt.getLastRowNum();i++){
            row= sheetAt.getRow(i); //获得每一行
            if(row!=null&&row.getCell(0)!=null){
               Student student=new Student();
               cell=row.getCell(0);
               cell.setCellType(CellType.STRING);
               student.setId(row.getCell(0).getStringCellValue());

               student.setName(row.getCell(1).toString());

               cell=row.getCell(2);
               cell.setCellType(CellType.STRING);
               student.setSex(Integer.valueOf(row.getCell(2).getStringCellValue()));

               cell=row.getCell(3);
               cell.setCellType(CellType.STRING);
               student.setClass_id(Integer.valueOf(row.getCell(3).toString()));

               cell=row.getCell(4);
               cell.setCellType(CellType.STRING);
               student.setIdcard(row.getCell(4).toString());

               cell=row.getCell(5);
               cell.setCellType(CellType.STRING);
               student.setPhone(String.valueOf(row.getCell(5).toString()));

               cell=row.getCell(6);
               cell.setCellType(CellType.STRING);
               student.setAddress(row.getCell(6).toString());

               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                cell=row.getCell(7);
                cell.setCellType(CellType.STRING);
               student.setGredeyear(sdf.parse(String.valueOf(row.getCell(7).toString())));
               student.setPassword(row.getCell(8).toString());

               cell=row.getCell(9);
               cell.setCellType(CellType.STRING);
               student.setFlag_id(Integer.valueOf(row.getCell(9).getStringCellValue()));

               cell=row.getCell(10);
               cell.setCellType(CellType.STRING);
               student.setEducationSchool(row.getCell(10).toString());

                cell=row.getCell(11);
                cell.setCellType(CellType.STRING);
               student.setEducationType_id(Integer.valueOf( row.getCell(11).getStringCellValue()));

               cell=row.getCell(12);
               cell.setCellType(CellType.STRING);
               student.setAgriculture(row.getCell(12).toString());


                cell=row.getCell(13);
                cell.setCellType(CellType.STRING);
               student.setHome_phone(String.valueOf(row.getCell(13).toString()));

                cell=row.getCell(14);
                cell.setCellType(CellType.STRING);
                student.setHome_money_id(Integer.valueOf( row.getCell(14).getStringCellValue()));
                list.add(student);
            }
            else {
                return 0;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            testUtils.studentServer.addStudent(list.get(i));
        }

        return 1;
    }

    //教师表的数据插入(废弃)
    public int ExcelToDBByTeacher(InputStream in) throws IOException, ParseException{
        Workbook Wook = new XSSFWorkbook(in);
        Sheet sheetAt = Wook.getSheetAt(0); //设置指定的列
        List<Teacher> list=new ArrayList<>();
        Row row=null;
        Cell cell=null;
        for(int i=1;i<=sheetAt.getLastRowNum();i++){
            row= sheetAt.getRow(i); //获得每一行

            if(row!=null&&row.getCell(0)!=null){
                Teacher teacher=new Teacher();
                cell=row.getCell(0);
                cell.setCellType(CellType.STRING);
                teacher.setId(row.getCell(0).toString());

                cell=row.getCell(1);
                cell.setCellType(CellType.STRING);
                teacher.setName(row.getCell(1).toString());

                cell=row.getCell(2);
                cell.setCellType(CellType.STRING);
                teacher.setSex(Integer.valueOf((row.getCell(2).getStringCellValue())));

                cell=row.getCell(3);
                cell.setCellType(CellType.STRING);
                teacher.setFac_id(row.getCell(3).toString());

                cell=row.getCell(4);
                cell.setCellType(CellType.STRING);
                teacher.setPhone(row.getCell(4).toString());

                cell=row.getCell(5);
                cell.setCellType(CellType.STRING);
                teacher.setPassword(row.getCell(5).toString());

                cell=row.getCell(6);
                cell.setCellType(CellType.STRING);
                teacher.setFlag_id(Integer.valueOf(row.getCell(6).getStringCellValue()));

                list.add(teacher);
            }
            else {
                return 0;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            testUtils.teacherServer.saveTeacher(list.get(i));
        }
        return 1;
    }


    //转入学习表(废弃)
    public int ExcelToDBByLearn(InputStream in) throws IOException, ParseException{
        Workbook Wook = new XSSFWorkbook(in);
        Sheet sheetAt = Wook.getSheetAt(0); //设置指定的表
        List<Learn_date> list=new ArrayList<>();
        Row row=null;
        Cell cell=null;
        for(int i=1;i<=sheetAt.getLastRowNum();i++){
            row= sheetAt.getRow(i); //获得每一行

            if(row!=null&&row.getCell(0)!=null){
                Learn_date learn_date=new Learn_date();
                cell=row.getCell(0);
                cell.setCellType(CellType.STRING);
                learn_date.setId(row.getCell(0).toString());

                cell=row.getCell(1);
                cell.setCellType(CellType.STRING);
                learn_date.setStu_id(row.getCell(1).toString());

                cell=row.getCell(2);
                cell.setCellType(CellType.STRING);
                learn_date.setCur_id(row.getCell(2).toString());

                cell=row.getCell(3);
                cell.setCellType(CellType.STRING);
                learn_date.setTask_num(Integer.valueOf(row.getCell(3).toString()));

                cell=row.getCell(4);
                cell.setCellType(CellType.STRING);
                learn_date.setTask_point(row.getCell(4).toString());


                cell=row.getCell(8);
                cell.setCellType(CellType.STRING);
                learn_date.setChapter_num(Integer.valueOf(row.getCell(8).toString()));

                cell=row.getCell(9);
                cell.setCellType(CellType.STRING);
                learn_date.setHomework_num(Integer.valueOf(row.getCell(9).toString()));

                cell=row.getCell(10);
                cell.setCellType(CellType.STRING);
                learn_date.setHoemwork_point(row.getCell(10).toString());

                cell=row.getCell(11);
                cell.setCellType(CellType.STRING);
                learn_date.setHomework_averge(Float.parseFloat(row.getCell(11).toString()));


                cell=row.getCell(14);
                cell.setCellType(CellType.STRING);
                learn_date.setGrend(Float.parseFloat(row.getCell(14).toString()));

                list.add(learn_date);
            }
            else {
                return 0;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            testUtils.learn_dateServer.AddDate(list.get(i));
        }
        return 1;
    }

    //学生作业数据导入到excel(废弃)
    public int ExcelToStudentWork(InputStream in) throws IOException, ParseException {
        //初始化工作表
        Workbook workbook=new XSSFWorkbook(in);
        //拿到第一张表
        Sheet sheet=workbook.getSheetAt(0);
        //加载数据
        List<WorkCount> workCounts=new ArrayList<>();
        Row row=null;
        Cell cell=null;

        for(int i=1;i<=sheet.getLastRowNum();i++){
            row= sheet.getRow(i);
            if(row!=null&&row.getCell(0)!=null){
                WorkCount workCount=new WorkCount();
                workCount.setId(RandomId.RuandomID());

                cell=row.getCell(0);
                cell.setCellType(CellType.STRING);
                workCount.setStudentID(row.getCell(0).toString());

                cell=row.getCell(1);
                cell.setCellType(CellType.STRING);
                workCount.setStudentName(row.getCell(1).toString());



                cell=row.getCell(3);
                cell.setCellType(CellType.STRING);
                workCount.setClassID(row.getCell(3).toString());

                cell=row.getCell(4);
                cell.setCellType(CellType.STRING);
                workCount.setCurrID(row.getCell(4).toString());

                cell=row.getCell(5);
                cell.setCellType(CellType.STRING);
                workCount.setWorkName(row.getCell(5).toString());

                cell=row.getCell(6);
                cell.setCellType(CellType.STRING);
                workCount.setDone(row.getCell(6).toString().equals("是")?1:0);

                cell=row.getCell(7);
                cell.setCellType(CellType.STRING);
                workCount.setGrende(row.getCell(7).toString());

                cell=row.getCell(8);
                workCount.setDoneTime(cell.getDateCellValue());

                workCounts.add(workCount);
            }
        }

        for(int i=0;i<workCounts.size();i++){
           testUtils.workCountServer.InsertData(workCounts.get(i));
        }
        return 1;
    }


    //学生的考试数据导入数据库(废弃)
    public void ExcelToExample(InputStream inputStream) throws IOException {
        //初始化工作表
        Workbook workbook=new XSSFWorkbook(inputStream);
        //拿到第一张表
        Sheet sheet=workbook.getSheetAt(0);
        //加载数据
        List<Example> list=new ArrayList<>();

        Row row=null;
        Cell cell=null;

        for(int i=1;i<=sheet.getLastRowNum();i++){
            row= sheet.getRow(i);
            if(row!=null&&row.getCell(0)!=null){
                Example example=new Example();
                example.setId(RandomId.RuandomID());

                cell=row.getCell(0);
                cell.setCellType(CellType.STRING);
                example.setStudentID(row.getCell(0).toString());

                cell=row.getCell(1);
                cell.setCellType(CellType.STRING);
                example.setStudentName(row.getCell(1).toString());

                cell=row.getCell(3);
                cell.setCellType(CellType.STRING);
                example.setClassID(row.getCell(3).toString());

                cell=row.getCell(4);
                cell.setCellType(CellType.STRING);
                example.setCurrID(row.getCell(4).toString());

                cell=row.getCell(5);
                cell.setCellType(CellType.STRING);
                example.setExampleName(row.getCell(5).toString());

                cell=row.getCell(6);
                cell.setCellType(CellType.STRING);
                example.setStats(row.getCell(6).toString());

                cell=row.getCell(7);
                cell.setCellType(CellType.STRING);
                example.setGrende(row.getCell(7).toString());


                cell=row.getCell(8);
                example.setUpdateTime(cell.getDateCellValue());

                list.add(example);
            }
        }

        for(int i=0;i<list.size();i++){
            testUtils.exampleServe.InserExampleleData(list.get(i));
        }
    }


    //学生签到数据导入数据库(废弃)
    public void ExcelToSign(InputStream inputStream) throws IOException {
        //初始化工作表
        Workbook workbook=new XSSFWorkbook(inputStream);
        //拿到第一张表
        Sheet sheet=workbook.getSheetAt(0);
        //加载数据
        List<Sign> list=new ArrayList<>();

        Row row=null;
        Cell cell=null;

        for(int i=1;i<=sheet.getLastRowNum();i++){
            row= sheet.getRow(i);
            if(row!=null&&row.getCell(0)!=null){
               Sign sign=new Sign();
               sign.setId(RandomId.RuandomID());

               cell= row.getCell(0);
               cell.setCellType(CellType.STRING);
               sign.setStudentid(row.getCell(0).toString());

                cell= row.getCell(1);
                cell.setCellType(CellType.STRING);
                sign.setStudentName(row.getCell(1).toString());

                cell= row.getCell(2);
                cell.setCellType(CellType.STRING);
                sign.setClassID(row.getCell(2).toString());

                cell= row.getCell(3);
                cell.setCellType(CellType.STRING);
                sign.setSignType(row.getCell(3).toString());

                cell= row.getCell(4);
                cell.setCellType(CellType.STRING);
                sign.setSignflag(row.getCell(4).toString());

                cell= row.getCell(5);
                sign.setSignTime(cell.getDateCellValue());

                cell=row.getCell(6);
                cell.setCellType(CellType.STRING);
                sign.setCurriculumID(row.getCell(6).toString());
                list.add(sign);
            }
        }

        for(int i=0;i<list.size();i++){
            testUtils.signServe.InsertSignData(list.get(i));
        }
    }

    //全新的文件上传
    public void NewTransDBtoLearnData(InputStream inputStream,String CurID) throws IOException {
        //初始化工作表
        Workbook workbook=new XSSFWorkbook(inputStream);
        //获取要处理的表
        Sheet sheet1=workbook.getSheetAt(0);
        Sheet sheet2=workbook.getSheetAt(5);
        Sheet sheet3=workbook.getSheetAt(7);
        List<Learn_date> list=new ArrayList<>();
        Row row=null;
        Cell cell=null;
        for(int i=3;i<sheet1.getLastRowNum();i++){
            row= sheet1.getRow(i);
            if(row!=null&&row.getCell(0)!=null){
                Learn_date learn_date=new Learn_date();

                learn_date.setId(RandomId.RuandomID());

                cell=row.getCell(2);
                cell.setCellType(CellType.STRING);
                learn_date.setStu_id(cell.getStringCellValue());

                learn_date.setCur_id(CurID);

                cell=row.getCell(8);
                cell.setCellType(CellType.STRING);
                learn_date.setTask_num(Integer.valueOf(cell.getStringCellValue().substring(0, cell.getStringCellValue().lastIndexOf("/"))));

                cell=row.getCell(9);
                cell.setCellType(CellType.STRING);
                learn_date.setTask_point(cell.getStringCellValue().substring(0,cell.getStringCellValue().lastIndexOf("%")));

                cell=row.getCell(12);
                cell.setCellType(CellType.STRING);
                learn_date.setChapter_num(Integer.valueOf(cell.getStringCellValue()));

                Row row1=sheet3.getRow(i+1);
                int homeworkNuber=0;
                float homewordaverage=0;
                int workcount=0;
                for(int j=6;j<row1.getLastCellNum();j+=3){
                    workcount++;
                    if(!row1.getCell(j).getStringCellValue().equals("")){
                        homeworkNuber++;
                        homewordaverage+=Float.parseFloat(row1.getCell(j).getStringCellValue());

                    }


                }
                learn_date.setHomework_num(homeworkNuber); //完成作业数量
                learn_date.setHoemwork_point(String.valueOf((float)homeworkNuber/workcount)); //百分比
                learn_date.setHomework_averge(homewordaverage/workcount); //平均分

                Row row2=sheet2.getRow(i);
                learn_date.setGrend(Float.parseFloat(row2.getCell(10).getStringCellValue()));
                list.add(learn_date);
            }
        }
        list.forEach(learn_date -> {
           testUtils.learn_dateServer.AddDate(learn_date);
        });

    }


    //全新的作业数据上传
    public void NewTransDBtoWork(InputStream inputStream,String classID,String CurID) throws IOException, ParseException {
        Workbook workbook=new XSSFWorkbook(inputStream);
        Sheet sheet=workbook.getSheetAt(7);

        Row row=null;
        Cell cell=null;

        for(int i=4;i<sheet.getLastRowNum();i++){
            row =sheet.getRow(i);
            if(row!=null&&row.getCell(0)!=null){
                WorkCount workCount=new WorkCount();

                cell=row.getCell(0);
                cell.setCellType(CellType.STRING);

                workCount.setStudentName(cell.getStringCellValue());

                cell=row.getCell(1);
                cell.setCellType(CellType.STRING);
                workCount.setStudentID(cell.getStringCellValue());



                workCount.setCurrID(CurID);
                workCount.setClassID(classID);

                Row row1=sheet.getRow(2);

                for(int j=6;j<row1.getLastCellNum();j+=3){
                    workCount.setId(RandomId.RuandomID());
                    Cell cell1=row.getCell(j);
                    cell1.setCellType(CellType.STRING);
                    workCount.setWorkName(row1.getCell(j).getStringCellValue());
                    if(cell1.getStringCellValue().equals("")){
                        //设置成绩为0
                        workCount.setGrende("0");
                        //上传时间为空
                        workCount.setDoneTime(null);
                        //未完成
                        workCount.setDone(0);
                    }
                    else{
                        //设置已完成
                        workCount.setDone(1);
                        //获取成绩
                        workCount.setGrende(row.getCell(j).getStringCellValue());
                        //获取上传时间
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        workCount.setDoneTime( simpleDateFormat.parse(row.getCell(j+1).getStringCellValue()));
                    }

                    testUtils.workCountServer.InsertData(workCount);
                }

            }
        }
    }

    //全新的考试成绩上传
    public void NewTransDBtoExample(InputStream inputStream,String classID,String CurID) throws IOException, ParseException {
        Workbook workbook=new XSSFWorkbook(inputStream);
        Sheet sheet=workbook.getSheetAt(8);
        Row row=null;
        Cell cell=null;
        for(int i=4;i<sheet.getLastRowNum();i++){
            row =sheet.getRow(i);
            if(row!=null&&row.getCell(0)!=null){
                Example example=new Example();


                cell=row.getCell(0);
                cell.setCellType(CellType.STRING);
                example.setStudentName(cell.getStringCellValue());

                cell=row.getCell(1);
                cell.setCellType(CellType.STRING);
                example.setStudentID(cell.getStringCellValue());

                example.setClassID(classID);
                example.setCurrID(CurID);

                Row row1=sheet.getRow(2);
                for(int j=6;i<row1.getLastCellNum()-1;j+=4){

                    //当获取不到考试名称的时候退出循环
                    if(row1.getCell(j)==null){
                        break;
                    }
                    example.setId(RandomId.RuandomID());
                    //获取考试的名字
                    example.setExampleName(row1.getCell(j).getStringCellValue());

                    Cell cell1=row.getCell(j);
                    cell1.setCellType(CellType.STRING);
                    if(row.getCell(j+2).getStringCellValue().equals("")){
                        example.setStats(row.getCell(j+3).getStringCellValue());
                        example.setGrende("0");
                        example.setUpdateTime(null);
                    }else{
                        example.setStats(row.getCell(j+3).getStringCellValue());
                        example.setGrende(row.getCell(j).getStringCellValue());
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        example.setUpdateTime(simpleDateFormat.parse(row.getCell(j+2).getStringCellValue()));

                    }

                   testUtils.exampleServe.InserExampleleData(example);

                }
            }
        }
    }

    public void NewTransDBtoSign(InputStream inputStream,String classID,String CurID) throws IOException, ParseException {
        Workbook workbook=new XSSFWorkbook(inputStream);
        Sheet sheet=workbook.getSheetAt(1);
        Row row=null;
        Cell cell=null;
        for (int i=9;i<sheet.getLastRowNum();i++){
            row =sheet.getRow(i);
            if(row!=null&&row.getCell(0)!=null){
                Sign sign=new Sign();


                cell=row.getCell(1);
                cell.setCellType(CellType.STRING);
                sign.setStudentid(cell.getStringCellValue());

                cell=row.getCell(0);
                cell.setCellType(CellType.STRING);
                sign.setStudentName(cell.getStringCellValue());

                sign.setCurriculumID(CurID);
                sign.setClassID(classID);

                Row row1=sheet.getRow(5);
                for(int j=5;j<row1.getLastCellNum()-1; j+=3){
                    Row row2=sheet.getRow(6);
                    sign.setId(RandomId.RuandomID());
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    if(row1.getCell(j)==null){
                        break;
                    }
                    switch (row1.getCell(j).getStringCellValue()){
                        case "拍照签到":
                            sign.setSignName(row2.getCell(j).getStringCellValue());
                            if(row.getCell(j).getStringCellValue().equals("")){
                                sign.setSignTime(null);
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());
                            }
                            else{
                                sign.setSignTime(simpleDateFormat.parse(row.getCell(j).getStringCellValue()));
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());
                            }
                            break;
                        case "手势签到":
                            sign.setSignName(row2.getCell(j).getStringCellValue());
                            if(row.getCell(j).getStringCellValue().equals("")){
                                sign.setSignTime(null);
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());
                            }
                            else{
                                sign.setSignTime(simpleDateFormat.parse(row.getCell(j).getStringCellValue()));
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());

                            }
                            j--;
                            break;
                        case "二维码签到":
                            sign.setSignName(row2.getCell(j).getStringCellValue());
                            if(row.getCell(j).getStringCellValue().equals("")){
                                sign.setSignTime(null);
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());
                            }
                            else{
                                sign.setSignTime(simpleDateFormat.parse(row.getCell(j).getStringCellValue()));
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());

                            }
                            j--;
                            break;
                        case "普通签到":
                            sign.setSignName(row2.getCell(j).getStringCellValue());
                            if(row.getCell(j).getStringCellValue().equals("")){
                                sign.setSignTime(null);
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());
                            }
                            else{
                                sign.setSignTime(simpleDateFormat.parse(row.getCell(j).getStringCellValue()));
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());

                            }
                            j--;
                            break;
                        default:
                            sign.setSignName(row2.getCell(j).getStringCellValue());
                            if(row.getCell(j).getStringCellValue().equals("")){
                                sign.setSignTime(null);
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());
                            }
                            else{
                                sign.setSignTime(simpleDateFormat.parse(row.getCell(j).getStringCellValue()));
                                sign.setSignType(row1.getCell(j).getStringCellValue());
                                sign.setSignflag(row.getCell(j+1).getStringCellValue());

                            }
                            j--;
                            break;
                    }
                   // System.out.println(sign);
                   testUtils.signServe.InsertSignData(sign);
                }
            }
        }

    }
}
