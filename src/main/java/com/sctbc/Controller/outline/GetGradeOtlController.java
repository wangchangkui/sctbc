package com.sctbc.Controller.outline;

import com.sctbc.Service.TokenServer;
import com.sctbc.Service.outline.GetGradeOtlServer;
import com.sctbc.Service.outline.Stu_classOtlServer;
import com.sctbc.Until.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Api(tags = "成绩接口")
@RestController
@RequestMapping("/outline/getGrade")
public class GetGradeOtlController {
    @Autowired
    private GetGradeOtlServer getGradeOtlServer;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "课程ID，班级ID，查询班级里学生的学习成绩（平时成绩，期末成绩,作业成绩）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="classId",value="班级id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryGradeClassByInfo")
    public ReturnValue queryGradeClassByInfo(@RequestParam("classId") String classId,
                                        @RequestParam("curriId") String curriId,
                                        @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("classId",classId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getGradeOtlServer.queryGradeClassByInfo(map));
    }
    @ApiOperation(value = "课程ID，班级ID，查询班级里学生的学习成绩（平时成绩）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="classId",value="班级id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryUsualGradeClassByInfo")
    public ReturnValue queryUsualGradeClassByInfo(@RequestParam("classId") String classId,
                                             @RequestParam("curriId") String curriId,
                                             @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("classId",classId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getGradeOtlServer.queryUsualGradeClassByInfo(map));
    }
    @ApiOperation(value = "课程ID，班级ID，查询班级里学生的学习成绩（期末成绩）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="classId",value="班级id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryExamGradeClassByInfo")
    public ReturnValue queryExamGradeClassByInfo(@RequestParam("classId") String classId,
                                             @RequestParam("curriId") String curriId,
                                             @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("classId",classId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getGradeOtlServer.queryExamGradeClassByInfo(map));
    }
    @ApiOperation(value = "课程ID，班级ID，查询班级里学生的学习成绩（作业成绩）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="classId",value="班级id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryHomeworkGradeClassByInfo")
    public ReturnValue queryHomeworkGradeClassByInfo(@RequestParam("classId") String classId,
                                             @RequestParam("curriId") String curriId,
                                             @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("classId",classId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getGradeOtlServer.queryHomeworkGradeClassByInfo(map));
    }





    @ApiOperation(value = "根据学生ID，课程ID,查询学生个人的学习成绩（平时成绩，期末成绩,作业成绩）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="stuId",value="学生ID",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryGradeStudentByInfo")
    public ReturnValue queryGradeStudentByInfo(@RequestParam("stuId") String stuId,
                                             @RequestParam("curriId") String curriId,
                                             @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("stuId",stuId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getGradeOtlServer.queryGradeStudentByInfo(map));
    }
    @ApiOperation(value = "根据学生ID，课程ID,查询学生个人的学习成绩（平时成绩）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="stuId",value="学生ID",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryUsualGradeStudentByInfo")
    public ReturnValue queryUsualGradeStudentByInfo(@RequestParam("stuId") String stuId,
                                               @RequestParam("curriId") String curriId,
                                               @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("stuId",stuId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getGradeOtlServer.queryUsualGradeStudentByInfo(map));
    }
    @ApiOperation(value = "根据学生ID，课程ID,查询学生个人的学习成绩（期末成绩）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="stuId",value="学生ID",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryExamGradeStudentByInfo")
    public ReturnValue queryExamGradeStudentByInfo(@RequestParam("stuId") String stuId,
                                               @RequestParam("curriId") String curriId,
                                               @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("stuId",stuId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getGradeOtlServer.queryExamGradeStudentByInfo(map));
    }
    @ApiOperation(value = "根据学生ID，课程ID,查询学生个人的学习成绩（作业成绩）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="stuId",value="学生ID",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryHomeworkGradeStudentByInfo")
    public ReturnValue queryHomeworkGradeStudentByInfo(@RequestParam("stuId") String stuId,
                                               @RequestParam("curriId") String curriId,
                                               @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("stuId",stuId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getGradeOtlServer.queryHomeworkGradeStudentByInfo(map));
    }
}
