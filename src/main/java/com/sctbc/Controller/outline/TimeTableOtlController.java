package com.sctbc.Controller.outline;

import com.sctbc.Service.TokenServer;
import com.sctbc.Service.outline.Stu_classOtlServer;
import com.sctbc.Service.outline.TimeTableOtlServer;
import com.sctbc.Until.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Api(tags = "课程接口")
@RestController
@RequestMapping("/outline/timetable")
public class TimeTableOtlController {
    @Autowired
    private TimeTableOtlServer timeTableOtlServer;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "根据教师ID查询课程、班级id及名字")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师ID", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryCurriAndClassInfoByid")
    public ReturnValue queryCurriAndClassInfoOtlClass(@RequestParam("id") String id, @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        return new ReturnValue(200, "查询成功", timeTableOtlServer.queryCurriAndClassInfoOtlClassInfo(id));
    }
}
