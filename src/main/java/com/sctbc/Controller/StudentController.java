package com.sctbc.Controller;


import com.sctbc.Pojo.Student;
import com.sctbc.Service.StudentServer;
import com.sctbc.Service.TokenServer;
import com.sctbc.Until.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Api(tags = "学生接口")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServer studentServer;


    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "查询所有的学生")
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String",
            dataTypeClass = String.class)})
    @GetMapping("/studentlist")
    public ReturnValue getStudentList(@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }
        List<Student> list = studentServer.studentList();
        ReturnValue returnValue=new ReturnValue(200,"请求成功",list);
        return returnValue;
    }

    @ApiOperation(value = "根据id查询学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生id", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    })
    @GetMapping("/findStudentById")
    public ReturnValue findStudentById(@RequestParam("id") String id,@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        return new ReturnValue(200,"请求成功",studentServer.findStudentById(id));
    }

    @ApiOperation(value = "验证学生token查询学校的院系专业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    })
    @GetMapping("/searchSchoolInfo")
    public ReturnValue searchSchoolInfo(@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        return new ReturnValue(200,"请求成功",studentServer.searchSchoolInfo());
    }

    @ApiOperation(value = "根据id修改学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生id", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "fac_id(没有字段)", value = "院系id", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "spe_id(没有字段)", value = "专业id", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "class_id", value = "班级id", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "idcard", value = "身份证号", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "sex", value = "性别", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "className(没有字段)", value = "班级的名称", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "address", value = "地址", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "phone", value = "联系电话", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "home_phone", value = "备用电话", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "educationSchool", value = "学校名称", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    })
    @GetMapping("/editStudentById")
    public ReturnValue editStudentById(
            @RequestParam("id") String id,
            @RequestParam("class_id") String class_id,
            @RequestParam("idcard") String idcard,
            @RequestParam("name") String name,
            @RequestParam("sex") String sex,
            @RequestParam("address") String address,
            @RequestParam("phone") String phone,
            @RequestParam("home_phone") String home_phone,
            @RequestParam("educationSchool") String educationSchool,
            @RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("class_id",class_id);
        map.put("idcard",idcard);
        map.put("name",name);
        map.put("sex",sex);
        map.put("address",address);
        map.put("phone",phone);
        map.put("home_phone",home_phone);
        map.put("educationSchool",educationSchool);

        return new ReturnValue(200,"请求成功",studentServer.editStudentById(map));
    }

}
