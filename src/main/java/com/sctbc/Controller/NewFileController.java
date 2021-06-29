package com.sctbc.Controller;


import com.sctbc.Service.*;
import com.sctbc.Until.ReturnValue;
import com.sctbc.Until.UpfileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

@Api(tags = "新版本数据文件接口")
@RestController
@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RequestMapping("/newUpload")
public class NewFileController {

    @Autowired
    private TokenServer tokenServer;

    @Autowired
    private WorkCountServer workCountServer;

    @Autowired
    private ExampleServe exampleServe;

    @Autowired
    private SignServe signServe;

    @ApiOperation(value = "导入学生学习数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "从前端发送过来的文件"),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "CurID",value = "课程ID",required = true,dataType = "String",dataTypeClass = String.class)
    })
    @PostMapping("/TransDBLearn")
    public ReturnValue TransDBLearnData(@RequestParam("file") MultipartFile file, @RequestParam("CurID") String CurID,@RequestParam("token") String token) throws IOException, ParseException {
        if(token.isEmpty()){
            return new ReturnValue(400,"token不能为空");
        }
        if(tokenServer.selectToken(token)==null){
            return new ReturnValue(400,"token错误");
        }

        return new ReturnValue(200,UpfileUtil.NewTransDbtoLearnData(file,CurID));
    }


    @ApiOperation(value = "导入学生作业数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "从前端发送过来的文件"),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "CurID",value = "课程ID",required = true,dataType = "String",dataTypeClass = String.class),
            @ApiImplicitParam(name = "classID",value = "班级ID",required = true,dataType = "String",dataTypeClass = String.class)
    })
    @PostMapping("/TransDBWork")
    public ReturnValue TransDBWork(@RequestParam("file") MultipartFile file, @RequestParam("CurID") String CurID,@RequestParam("classID") String classID,@RequestParam("token") String token) throws IOException, ParseException {
        if(token.isEmpty()){
            return new ReturnValue(400,"token不能为空");
        }
        if(classID.isEmpty()||CurID.isEmpty()){
            return new ReturnValue(400,"缺少参数");
        }
        if(tokenServer.selectToken(token)==null){
            return new ReturnValue(400,"token过期");
        }

        //删除之前的作业
        Map<String, String> map=new HashMap<>();
        map.put("classID",classID);
        map.put("CurrID",CurID);
        workCountServer.DeleteData(map);
        return new ReturnValue(200,UpfileUtil.NewTransDBtoWork(file,classID,CurID));
    }


    @ApiOperation(value = "导入考试数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "从前端发送过来的文件"),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "CurID",value = "课程ID",required = true,dataType = "String",dataTypeClass = String.class),
            @ApiImplicitParam(name = "classID",value = "班级ID",required = true,dataType = "String",dataTypeClass = String.class)
    })
    @PostMapping("/TransDBExample")
    public ReturnValue TransDBExample(@RequestParam("file") MultipartFile file, @RequestParam("CurID") String CurID,@RequestParam("classID") String classID,@RequestParam("token") String token) throws IOException, ParseException {
        if(token.isEmpty()){
            return new ReturnValue(400,"token不能为空");
        }
        if(classID.isEmpty()||CurID.isEmpty()){
            return new ReturnValue(400,"缺少参数");
        }
        if(tokenServer.selectToken(token)==null){
            return new ReturnValue(400,"token过期");
        }

        //删除之前的作业
        Map<String, String> map=new HashMap<>();
        map.put("ClassID",classID);
        map.put("CurrID",CurID);
        exampleServe.DeleteExampleData(map);
        return new ReturnValue(200,UpfileUtil.NewTransDBtoExample(file,classID,CurID));
    }
    @ApiOperation(value = "导入签到数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "从前端发送过来的文件"),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "CurID",value = "课程ID",required = true,dataType = "String",dataTypeClass = String.class),
            @ApiImplicitParam(name = "classID",value = "班级ID",required = true,dataType = "String",dataTypeClass = String.class)
    })
    @PostMapping("/TransDBSign")
    public ReturnValue TransDBSign(@RequestParam("file") MultipartFile file, @RequestParam("CurID") String CurID,@RequestParam("classID") String classID,@RequestParam("token") String token) throws IOException, ParseException {
        if(token.isEmpty()){
            return new ReturnValue(400,"token不能为空");
        }
        if(classID.isEmpty()||CurID.isEmpty()){
            return new ReturnValue(400,"缺少参数");
        }
        if(tokenServer.selectToken(token)==null){
            return new ReturnValue(400,"token过期");
        }
        signServe.DeleteSignData(classID,CurID);

        return new ReturnValue(200,UpfileUtil.NewTransDBToSign(file,classID,CurID));
    }
}
