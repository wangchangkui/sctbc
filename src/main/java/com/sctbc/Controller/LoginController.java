package com.sctbc.Controller;


import com.sctbc.Dao.TokenMapper;
import com.sctbc.Pojo.Teacher;
import com.sctbc.Service.TeacherServer;
import com.sctbc.Service.TokenServer;
import com.sctbc.Until.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Api(tags = "登录接口")
@RestController
@RequestMapping("/teacherlogin")
public class LoginController {

    @Autowired
    private TeacherServer teacherServer;

    @Autowired
    private TokenServer tokenServer;



    @ApiOperation(value = "登录验证")
    @ApiImplicitParams({@ApiImplicitParam(name = "loginid",value = "登录的账号",required = true,dataType = "String",dataTypeClass = String.class),@ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String",dataTypeClass = String.class)})
    @PostMapping("/logincheck")
    public ReturnValue loginCheck(String loginid,String password){
        if(loginid.isEmpty()||password.isEmpty()){
            return new ReturnValue(400,"请输入账号或密码");
        }
        //查询用户
        Teacher teacher = teacherServer.selectTeacher(loginid, password);
        if(teacher.getFlag_id().equals("")){
            return new ReturnValue(200,"没有该用户");
        }
        String token = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        //优先查询上次token有没有删除 如果没有删除就替换token
        Map<String, String> map=new HashMap<>();
        map.put("userid",teacher.getId());
        map.put("token",token);
        //删除就新增token

        System.out.println(tokenServer.selectTokenByuserid(teacher.getId()));
        if(tokenServer.selectTokenByuserid(teacher.getId())==null){
            tokenServer.addToken(map);
        }
        //存在就替换token
        else {
            tokenServer.UpdateToken(token, teacher.getId());
        }
        return new ReturnValue(200,"请求成功",map);
    }


    @ApiOperation(value = "查询token是否存在")
    @ApiImplicitParams({@ApiImplicitParam(name = "token",value = "获取token",required = true)})
    @GetMapping("/tokenselect")
    public ReturnValue login_token(@RequestParam("token") String token){
        String res=tokenServer.selectToken(token);
        return new ReturnValue(200,"请求成功",res);
    }

    @ApiOperation(value = "退出登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "token",value = "用户的token",required = true)})
    @GetMapping("/ExitToken")
    public ReturnValue logout(@RequestParam("token") String token){
        int res=tokenServer.DeleteToken(token);
        return new ReturnValue(200,"删除token成功,已退出登陆",res);
    }
}
