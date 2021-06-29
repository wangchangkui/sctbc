package com.sctbc.Controller;


import com.sctbc.Pojo.Curriculum;
import com.sctbc.Pojo.Stu_class;
import com.sctbc.Pojo.Student;
import com.sctbc.Pojo.Teacher;
import com.sctbc.Service.CurriculumServer;
import com.sctbc.Service.StudentServer;
import com.sctbc.Service.TokenServer;
import com.sctbc.Until.RandomId;
import com.sctbc.Until.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Api(tags = "课程接口")
@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumServer curriculumServer;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "根据老师id上传新的课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="教师id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriName",value="课程名称",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @PostMapping("/addCurri")
    public ReturnValue addCurri(@RequestParam("id") String id,@RequestParam("curriName") String curriName,@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }
        String curriId = RandomId.RuandomID();
        Curriculum curri = new Curriculum();
        curri.setId(curriId);
        curri.setName(curriName);
        int cur = curriculumServer.addCurri(curri);
        String msg = "数据插入失败";
        if(cur == 1){
            msg = "数据插入成功";
        }
        return new ReturnValue(200,"请求成功",msg);
    }

    @ApiOperation(value = "根据教师id和课程id查询教导班级")
    @ApiImplicitParams({
            @ApiImplicitParam(name="teaid",value="教师id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @GetMapping("/findClass")
    public ReturnValue findClass(@RequestParam("teaid") String teaid,@RequestParam("curriId") String curriId,@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }
        Map<String,String> map = new HashMap<>();
        map.put("teaid",teaid);
        map.put("curriId",curriId);
        return new ReturnValue(200,"请求成功",curriculumServer.findClass(map));
    }

    @ApiOperation(value = "根据教师id班级id查询所教导的课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name="teaId",value="教师id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="classId",value="班级id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @GetMapping("/findCurri")
    public ReturnValue findCurri(@RequestParam("teaId") String teaId,@RequestParam("classId") String classId,@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }
        Map<String,String> map = new HashMap<>();
        map.put("teaId",teaId);
        map.put("classId",classId);
        return new ReturnValue(200,"请求成功",curriculumServer.findCurri(map));
    }

    @ApiOperation(value = "根据教师id，token，班级id，课程id查询课程的学习情况信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="teaId",value="教师id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="classId",value="班级id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @GetMapping("/findCurriOutline")
    public ReturnValue findCurriOutline(@RequestParam("teaId") String teaId,@RequestParam("classId") String classId,@RequestParam("curriId") String curriId,@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }
        Map<String,String> map = new HashMap<>();
        map.put("teaId",teaId);
        map.put("classId",classId);
        map.put("curriId",curriId);
        return new ReturnValue(200,"请求成功",curriculumServer.findCurriOutline(map));
    }

    @ApiOperation(value = "根据教师id，token，班级id，课程id查询上课全体学生")
    @ApiImplicitParams({
            @ApiImplicitParam(name="teaId",value="教师id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="classId",value="班级id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @GetMapping("/findCurriAllStu")
    public ReturnValue findCurriAllStu(@RequestParam("teaId") String teaId,@RequestParam("classId") String classId,@RequestParam("curriId") String curriId,@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }
        Map<String,String> map = new HashMap<>();
        map.put("teaId",teaId);
        map.put("classId",classId);
        map.put("curriId",curriId);
        return new ReturnValue(200,"请求成功",curriculumServer.findCurriAllStu(map));
    }

}
