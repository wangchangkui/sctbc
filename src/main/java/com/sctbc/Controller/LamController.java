package com.sctbc.Controller;

import com.sctbc.Service.LamTableServe;
import com.sctbc.Service.TokenServer;
import com.sctbc.Until.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@Api(tags = "留言接口")
@RestController
@RequestMapping("/lam")
public class LamController {


    @Autowired
    private TokenServer tokenServer;

    @Autowired
    private LamTableServe lamTableServe;

    @ApiOperation(value = "查询所有的留言")
    @ApiImplicitParams({@ApiImplicitParam(name = "token",value = "用户的token",required = true,dataType = "string",dataTypeClass = String.class)})
    @GetMapping("/listLam")
    public ReturnValue getLamList(@RequestParam("token") String token){
        if(token==null||tokenServer.selectToken(token)==null){
            return new ReturnValue(400,"请携带token或者token过期");
        }
        return new ReturnValue(200,"请求成功",lamTableServe.getLamTableList());
    }
}
