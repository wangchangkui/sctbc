package com.sctbc.Controller;

import com.sctbc.Pojo.Speciality;
import com.sctbc.Service.SpecialityServer;
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
@RequestMapping("/speciality")
public class SpecialityController {
    @Autowired
    private SpecialityServer specialityServer;
    @Autowired
    private TokenServer tokenServer;

    @ApiOperation(value = "根据院系id，查询专业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="院系id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    @GetMapping("/findSpecialitys")
    public ReturnValue findSpecialitys(@RequestParam("id") String id,
                                       @RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        return new ReturnValue(200,"请求成功",specialityServer.findSpecialitys(id));
    }
}
