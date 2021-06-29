package com.sctbc.Controller.outline;

import com.sctbc.Service.TokenServer;
import com.sctbc.Service.outline.GetGradeOtlServer;
import com.sctbc.Service.outline.GetStudyHabitsOtlServer;
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
@Api(tags = "学习习惯接口")
@RestController
@RequestMapping("/outline/getHabits")
public class GetStudyHabitsOtlController {
    @Autowired
    private GetStudyHabitsOtlServer getStudyHabitsOtlServer;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "已更名：获取学生的签到情况接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="stuId",value="学生id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryStudyHabits")
    public ReturnValue queryStudyHabits(@RequestParam("stuId") String stuId,
                                        @RequestParam("curriId") String curriId,
                                        @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("stuId",stuId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getStudyHabitsOtlServer.queryStudyHabits(map));
    }

    @ApiOperation(value = "获取学生作业情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name="stuId",value="学生id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/getStudentWorkStat")
    public ReturnValue getStudentWorkStat(@RequestParam("stuId") String stuId,
                                        @RequestParam("curriId") String curriId,
                                        @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("stuId",stuId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getStudyHabitsOtlServer.getStudentWorkStat(map));
    }

}
