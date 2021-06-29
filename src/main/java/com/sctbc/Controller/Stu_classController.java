package com.sctbc.Controller;

import com.sctbc.Pojo.Teacher;
import com.sctbc.Service.Stu_classServer;
import com.sctbc.Service.TokenServer;
import com.sctbc.Until.RandomId;
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
@Api(tags = "班级接口")
@RestController
@RequestMapping("/stuclass")
public class Stu_classController {
    @Autowired
    private Stu_classServer stu_classServer;
    @Autowired
    private TokenServer tokenServer;

    @ApiOperation(value = "根据教师id，课程id，token新增班级的同时创建班级课表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="teaId",value="教师id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="className",value="班级名",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="speId",value="专业id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @PostMapping("/addClassAndTimetable")
    public ReturnValue addClassAndTimetable(@RequestParam("teaId") String teaId,
                                       @RequestParam("className") String className,
                                       @RequestParam("curriId") String curriId,
                                            @RequestParam("speId") String speId,
                                       @RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        String classId = RandomId.RuandomID();//生成一个班级id
        String timetableId = RandomId.RuandomID();//生成一个课表id
        Map<String,String> map = new HashMap<>();
        map.put("classId",classId);
        map.put("teaId",teaId);
        map.put("className",className);
        map.put("curriId",curriId);
        map.put("speId",speId);
        map.put("timetableId",timetableId);
        stu_classServer.addClassAndTimetable(map);
        return new ReturnValue(200,"请求成功");
    }

    @ApiOperation(value = "根据专业id和token获取班级id及名字")
    @ApiImplicitParams({
            @ApiImplicitParam(name="speId",value="专业id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @PostMapping("/queryClassIdAndName")
    public ReturnValue queryClassIdAndName(@RequestParam("speId") String speId,
                                            @RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("speId",speId);

        return new ReturnValue(200,"请求成功",stu_classServer.queryClassIdAndName(map));
    }
}
