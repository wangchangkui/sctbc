package com.sctbc.Controller;

import com.sctbc.Service.FacultyServe;
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
@Api(tags = "专业接口")
@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyServe facultyServe;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "验证教师token，查询学校院系信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @GetMapping("/findFacultys")
    public ReturnValue findFacultys(@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        return new ReturnValue(200,"请求成功",facultyServe.findFacultys());
    }
}
