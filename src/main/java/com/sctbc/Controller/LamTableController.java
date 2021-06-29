package com.sctbc.Controller;

import com.sctbc.Service.LamTableServer;
import com.sctbc.Service.TokenServer;
import com.sctbc.Until.RandomId;
import com.sctbc.Until.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"*"}, maxAge = 60*60)
@Api(tags = "留言接口")
@RestController
@RequestMapping("/lamtable")
public class LamTableController {
    @Autowired
    private LamTableServer lamTableServer;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation("查询指定发送者发送的留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="id",value="发送者的id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="keyword",value="查询的关键字(可为空)",required=false,dataType="String",dataTypeClass=String.class)
    })
    @GetMapping("/findLam")
    public ReturnValue findLam(@RequestParam("id")String id,@RequestParam("token")String token,@RequestParam(value = "keyword",required = false)String keyword){
        if(tokenServer.selectToken(token) == null){
            return new ReturnValue(400,"你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("keycode","%"+keyword+"%");
        return new ReturnValue(200,"请求成功",lamTableServer.findLam(map));
    }

    @ApiOperation("接收者查询收到的留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="id",value="接收者的id",required=true,dataType="String",dataTypeClass=String.class)
    })
    @GetMapping("/findGetLam")
    public ReturnValue findGetLam(@RequestParam("id")String id,@RequestParam("token")String token){
        if(tokenServer.selectToken(token) == null){
            return new ReturnValue(400,"你还未登录");
        }

        return new ReturnValue(200,"请求成功",lamTableServer.findGetLam(id));
    }

    @ApiOperation("根据学号，教师id，token发送邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="fromId",value="发送人id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="toId",value="接收人id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="title",value="留言标题",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="content",value="留言内容",required=true,dataType="String",dataTypeClass=String.class)
    })
    @PostMapping("/sendLam")
    public ReturnValue sendLam(@RequestParam("token")String token,
                               @RequestParam("fromId")String fromId,
                               @RequestParam("toId")String toId,
                               @RequestParam("content")String content,
                               @RequestParam("title")String title){
        if(tokenServer.selectToken(token) == null){
            return new ReturnValue(400,"你还未登录");
        }
        String id = RandomId.RuandomID();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lamtime = sdf.format(new Date());
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("fromId",fromId);
        map.put("toId",toId);
        map.put("content",content);
        map.put("title",title);
        map.put("lamtime",lamtime);
        map.put("recive","0");
        int i = lamTableServer.sendLam(map);
        String msg = "发送失败";
        if(i == 1){
            msg = "发送成功";
        }
        return new ReturnValue(200,"请求成功",msg);
    }
}
