package com.sctbc.Controller;


import com.sctbc.Dao.Learn_dataMpper;
import com.sctbc.Service.Learn_dateServer;
import com.sctbc.Service.TokenServer;
import com.sctbc.Until.ReturnValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Api(tags = "学习情况接口")
@RestController
@RequestMapping("/learn")
public class Learn_dateController {

    @Autowired
    private Learn_dateServer learn_dateServer;
    @Autowired
    private TokenServer tokenServer;


    @ApiOperation(value = "根据条件查询学生学习数据")
    @GetMapping("/getStudentLearnDataByInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name="注意",value="<font style=\"font-size:20px;font-weight:font;color:purple;\">返回值:</font><br/>" +
                    "<font style=\"font-size:16px;color:orange;\">signCount是签到情况</font><br/>(stu_id 学生id;stu_name 学生姓名;Signflag 签到情况)  <br/><hr/>" +
                    "<font style=\"font-size:16px;color:orange;\">studentLearnDataByInfo是学生总体成绩</font><br/>(stu_id 学生id;stu_name 学生姓名;task_point 任务完成百分比;chapter_num 章节学习次数;hoemwork_point 作业完成百分比;WorkCounts 教师发布作业总数;SignCounts 教师发布签到总数;learn_dateGrade 期末成绩)  <br/><hr/>" +
                    "<font style=\"font-size:16px;color:orange;\">workGrades是学生作业成绩</font><br/>(stu_id 学生id;stu_name 学生姓名;WorkName 作业名;WorkGrade 作业成绩)  <br/><hr/>" +
                    "<font style=\"font-size:16px;color:orange;\">exampleGrades是学生考试成绩</font><br/>(stu_id 学生id;stu_name 学生姓名;ExampleName 考试名;ExampleGrade 考试成绩)",required=false,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="classId",value="班级id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="curriId",value="课程id",required=true,dataType="String",dataTypeClass=String.class),
            @ApiImplicitParam(name="token",value="接口验证的token",required=true,dataType="String",dataTypeClass=String.class)
    })
    public ReturnValue getStudentLearnDataByInfo(@RequestParam("classId") String classId,
                                                 @RequestParam("curriId") String curriId,
                                                 @RequestParam("token") String token){
        if (tokenServer.selectToken(token)==null) {
            return new ReturnValue(400, "你还未登录");
        }

        Map<String,String> map = new HashMap<>();
        map.put("classId",classId);
        map.put("curriId",curriId);
        return new ReturnValue(200,"获取数据成功",learn_dateServer.getStudentLearnDataByInfo(map));
    }
}
