package com.sctbc.Controller.outline;

import com.sctbc.Service.TokenServer;
import com.sctbc.Service.outline.GetStudyAttributeOtlServer;
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
@Api(tags = "学习态度接口")
@RestController
@RequestMapping("/outline/getAttribute")
public class GetStudyAttributeOtlController {
    @Autowired
    private GetStudyAttributeOtlServer getStudyAttributeOtlServer;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "根据学生ID，课程ID，获取单个学生的学习态度")
    @ApiImplicitParams({
            @ApiImplicitParam(name="stuId",value="学生id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name = "token", value = "接口验证的token", required = true, dataType = "String", dataTypeClass = String.class)
    }
    )
    @GetMapping("/queryStudyAttribute")
    public ReturnValue queryStudyAttribute(@RequestParam("stuId") String stuId,
                                        @RequestParam("curriId") String curriId,
                                        @RequestParam("token") String token) {
        if (tokenServer.selectToken(token)==null||token.isEmpty()) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("stuId",stuId);
        map.put("curriId",curriId);
        return new ReturnValue(200, "查询成功", getStudyAttributeOtlServer.queryStudyAttribute(map));
    }


}
