package com.sctbc.Controller;


import com.sctbc.Service.*;
import com.sctbc.Until.RandomId;
import com.sctbc.Until.ReturnValue;
import com.sctbc.Until.UpfileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Api(tags = "文件上传接口（部分弃用）")
@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    private FileServer fileServer;

    @Autowired
    private WorkCountServer workCountServer;

    @Autowired
    private ExampleServe exampleServe;

    @Autowired
    private SignServe signServe;
    @Autowired
    private TokenServer tokenServer;

    @ApiOperation(value = "文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "上传文件", required = true, dataType = "MultipartFile", dataTypeClass = MultipartFile.class),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class),
    })
    @PostMapping("/upfile")
    public ReturnValue upfile(@RequestParam("file") MultipartFile file, @RequestParam("token") String token) throws FileNotFoundException {
        if (token == null || tokenServer.selectToken(token) == null) {
            return new ReturnValue(400, "请先登录");
        }
        if (file.isEmpty()) {
            return new ReturnValue(400, "请上传文件");
        }
        //获取文件的名称
        String upfile = UpfileUtil.upfile(file);
        com.sctbc.Pojo.File file1 = new com.sctbc.Pojo.File();
        file1.setId(RandomId.RuandomID());
        file1.setFilename(file.getOriginalFilename());
        file1.setFilelink("file/common/" + upfile);
        file1.setUploadTime(new Date());
        file1.setUploadName("王长奎");   //此处需要修改
        System.out.println(file1.toString());
        fileServer.InsertFile(file1);
        return new ReturnValue(200, "上传文件成功");
    }

    @ApiOperation(value = "学生表excel导入数据库")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "上传文件", required = true, dataType = "MultipartFile", dataTypeClass = MultipartFile.class),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class)})
    @PostMapping("/TransDBStudent")
    public ReturnValue TransDBStudent(@RequestParam("file") MultipartFile file, @RequestParam("token") String token) throws IOException, ParseException {
        if (token == null || tokenServer.selectToken(token) == null) {
            return new ReturnValue(400, "请先登录");
        }
        if (file.isEmpty()) {
            return new ReturnValue(201, "未选择上传的excel");
        }
        return new ReturnValue(200, UpfileUtil.TransDB(file));
    }

    @ApiOperation(value = "教师表excel导入数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "从前端发送过来的数据"),})
    @PostMapping("/TransDBTeacher")
    public ReturnValue TransDBTeacher(@RequestParam("file") MultipartFile file, @RequestParam("token") String token) throws IOException, ParseException {
        if (token == null || tokenServer.selectToken(token) == null) {
            return new ReturnValue(400, "请先登录");
        }
        if (file.isEmpty()) {
            return new ReturnValue(201, "未选择上传的excel");
        }
        return new ReturnValue(200, UpfileUtil.TransDBTeacher(file));
    }

    @ApiOperation(value = "导入学生学习数据 （以弃用）")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "从前端发送过来的文件"),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class)})
    @PostMapping("/TransDBLearn")
    public ReturnValue TransDBLearnData(@RequestParam("file") MultipartFile file, @RequestParam("token") String token) throws IOException, ParseException {
        if (token == null || tokenServer.selectToken(token) == null) {
            return new ReturnValue(400, "请先登录");
        }
        if (file.isEmpty()) {
            return new ReturnValue(201, "未选择上传的excel");
        }


        return new ReturnValue(200, UpfileUtil.TransDBLearn(file));
    }


    //获取所有的文件
    @ApiOperation(value = "获取所有的文件")
    @GetMapping("/GetFillList")
    public ReturnValue GETFilesList() {
        return new ReturnValue(200, "获取文件成功", fileServer.getallFiles());
    }


    @ApiOperation(value = "文件下载接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "filename", value = "文件名称", required = true, dataType = "String", dataTypeClass = String.class), @ApiImplicitParam(name = "fileLink", value = "文件地址", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class)})
    @GetMapping("/dowload")
    public String dowloadFile(@RequestParam("filename") String filename, @RequestParam("fileLink") String fileLink, HttpServletResponse response, @RequestParam("token") String token) {
        if (token == null || tokenServer.selectToken(token) == null) {
            return "请先登录";
        }
        if (filename.isEmpty() || fileLink.isEmpty()) {
            return "404";
        }
        try {
            //获取项目的路径
            String classpath = "/www/wwwroot/iwck.top/springboot/";
            fileLink = classpath + fileLink;
            System.out.println(fileLink);
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));

            //设置文件大小
            byte[] buffer = new byte[1024];
            FileInputStream fin = null;
            BufferedInputStream bin = null;
            File file = new File(fileLink);
            if (!file.exists()) {
                return "没有这个文件";
            }
            fin = new FileInputStream(file);
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fin);
          
            //bin = new BufferedInputStream(fin);
            OutputStream os = response.getOutputStream();
            xssfWorkbook.write(os);
            //int i = bin.read(buffer);
            //while (i != -1) {
            //    os.write(buffer, 0, i);
            //    i = bin.read(buffer);
            //}

            //bin.close();
            //fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "发起下载请求成功";
    }


    @ApiOperation(value = "导入学生作业完成数据接口 （以弃用）")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "MultipartFile", dataTypeClass = MultipartFile.class),
            @ApiImplicitParam(name = "classID", value = "班级ID", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "CurrID", value = "课程ID", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class)
    })
    @PostMapping("/StudentWork")
    public ReturnValue StudentWork(@RequestParam("file") MultipartFile file, @RequestParam("classID") String classID, @RequestParam("CurrID") String CurrID, @RequestParam("token") String token) throws IOException, ParseException {
        if (token == null || tokenServer.selectToken(token) == null) {
            return new ReturnValue(400, "请先登录");
        }
        if (file.isEmpty()) {
            return new ReturnValue(400, "你没有传入文件");
        }
        if (classID.isEmpty() || CurrID.isEmpty()) {
            return new ReturnValue(400, "数据不全");
        }

        Map<String, String> map = new HashMap<>();
        map.put("classID", classID);
        map.put("CurrID", CurrID);
        workCountServer.DeleteData(map);
        return new ReturnValue(200, UpfileUtil.TransDBStudentWork(file));
    }

    @ApiOperation(value = "导入学生考试成绩接口 （以弃用）")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "MultipartFile", dataTypeClass = MultipartFile.class),
            @ApiImplicitParam(name = "classID", value = "班级ID", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "CurrID", value = "课程ID", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class)
    })
    @PostMapping("/Example")
    public ReturnValue StudentExample(@RequestParam("file") MultipartFile file, @RequestParam("classID") String classID, @RequestParam("CurrID") String CurrID, @RequestParam("token") String token) throws IOException, ParseException {
        if (token == null || tokenServer.selectToken(token) == null) {
            return new ReturnValue(400, "请先登录");
        }
        if (file.isEmpty()) {
            return new ReturnValue(400, "你没有传入文件");
        }
        if (classID.isEmpty() || CurrID.isEmpty()) {
            return new ReturnValue(400, "数据不全");
        }
        Map<String, String> map = new HashMap<>();
        map.put("classID", classID);
        map.put("CurrID", CurrID);
        exampleServe.DeleteExampleData(map);
        return new ReturnValue(200, UpfileUtil.TransDBStudentExample(file));
    }


    @ApiOperation(value = "导入学生签到数据 （以弃用）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "String", dataTypeClass = MultipartFile.class),
            @ApiImplicitParam(name = "classID", value = "班级ID", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "CurrID", value = "课程ID", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "token", value = "验证token", required = true, dataType = "String", dataTypeClass = String.class)
    })
    @PostMapping("/Sign")
    public ReturnValue StudentSign(@RequestParam("file") MultipartFile file, @RequestParam("classID") String classID,@RequestParam("CurrID") String CurrID, @RequestParam("token") String token) throws IOException, ParseException {
        if (token == null || tokenServer.selectToken(token) == null) {
            return new ReturnValue(400, "请先登录");
        }
        if (file.isEmpty()) {
            return new ReturnValue(400, "你没有传入文件");
        }
        if (classID.isEmpty()||CurrID.isEmpty()) {
            return new ReturnValue(400, "数据不全");
        }

        signServe.DeleteSignData(classID,CurrID);
        return new ReturnValue(200, UpfileUtil.TransDBStudentSign(file));
    }

}
