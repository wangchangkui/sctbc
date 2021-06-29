package com.sctbc.Controller.student;


import com.sctbc.Pojo.Curriculum;
import com.sctbc.Service.CurriculumServer;
import com.sctbc.Service.TokenServer;
import com.sctbc.Service.student.StudentCurriculumServer;
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
@Api(tags = "学生端课程接口")
@RestController
@RequestMapping("/stucurriculum")
public class StudentCurriculumController {

    @Autowired
    private StudentCurriculumServer studentCurriculumServer;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "根据学生id查询课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="学生id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @PostMapping("/findCurri")
    public ReturnValue findCurri(@RequestParam("id") String id,@RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        return new ReturnValue(200,"请求成功",studentCurriculumServer.findCurri(id));
    }

}
