package com.sctbc.Controller;

import com.sctbc.Pojo.Teacher;
import com.sctbc.Service.TeacherServer;
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
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Api(tags = "教师类的接口")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherServer teacherServer;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "查询所有的教师")
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String",
            dataTypeClass = String.class)})
    @GetMapping("/getlistTeacher")
    public ReturnValue queryTeacherList(@RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }
        List<Teacher> queryTeacherlist = teacherServer.queryTeacherList();
        return new ReturnValue(200, "请求成功", queryTeacherlist);
    }


    @ApiOperation(value = "根据ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师ID", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/selectTeacherByid")
    public ReturnValue selectTeacher(@RequestParam("id") String id, @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        return new ReturnValue(200, "查询成功", teacherServer.getTeacherById(id));
    }

    @ApiOperation(value = "根据教师id和token修改教师的个人信息")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id", value = "教师ID", required = true, dataType = "String", dataTypeClass = String.class
            ), @ApiImplicitParam(name = "name", value = "教师名称", required = true, dataType = "String", dataTypeClass = String.class
            ), @ApiImplicitParam(name = "password", value = "教师密码", required = true, dataType = "String", dataTypeClass = String.class
            ), @ApiImplicitParam(name = "sex", value = "性别  1表示男 0表示女", required = true, dataType = "Integer", dataTypeClass = Integer.class
            ), @ApiImplicitParam(name = "fac_id", value = "系部id", required = true, dataType = "Integer", dataTypeClass = Integer.class
            ), @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String", dataTypeClass = String.class
            ), @ApiImplicitParam(name = "flag_id", value = "权限级别", required = true, dataType = "Integer", dataTypeClass = Integer.class
            ), @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
            }
    )
    @PostMapping("/updeteTeacher")
    public ReturnValue UpdateTeacher(String id, String password, String name, int sex, String fac_id, String phone, int flag_id, @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Teacher teacher = new Teacher();
        teacher.setFlag_id(flag_id);
        teacher.setPassword(password);
        teacher.setPhone(phone);
        teacher.setSex(sex);
        teacher.setFac_id(fac_id);
        teacher.setName(name);
        teacher.setId(id);
        teacherServer.updateTeacher(teacher);
        return new ReturnValue(200, "请求成功");
    }

    @ApiOperation(value = "模糊查询用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "查询的内容", required = true, dataType = "String", dataTypeClass = String.class),@ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)})
    @GetMapping("/likename")
    public ReturnValue teacherBySelectlike(String name, @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }
        return new ReturnValue(200, "请求成功", teacherServer.selectTeacherByLike("%" + name + "%"));
    }


    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer", dataTypeClass = Integer.class),@ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)})
    @GetMapping("/page")
    public ReturnValue teacherByPage(Integer page, @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 5 * (page - 1));
        map.put("pageSize", 5);
        return new ReturnValue(200, "请求成功", teacherServer.selectTeacherByLimit(map));
    }
}
