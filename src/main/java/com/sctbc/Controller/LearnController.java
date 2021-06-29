package com.sctbc.Controller;


import com.sctbc.Dao.Learn_dataMpper;
import com.sctbc.Until.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Api(tags = "学习情况接口")
@RestController
@RequestMapping("/learn")
public class LearnController {

    @Autowired
    private Learn_dataMpper learn_dataMpper;



    @ApiOperation(value = "获取所有的学习数据")
    @GetMapping("/allDate")
    //请求所有数据
    public ReturnValue geteAlldate(){
        return new ReturnValue(200,"获取数据成功",learn_dataMpper.learnDateList());
    }
}
