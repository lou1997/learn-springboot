package lyd.learn.springboot.controller;

import lyd.learn.springboot.entity.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;
import java.io.File;

/**
 * 功能：文件测试
 */
@Controller
@PropertySource({"classpath:application.properties"})
public class FileController {


    @RequestMapping(value = "api/vi/gopage")
    public Object index() {
        return "index";
    }

    @Value("${web.file.path}")   //使用value把 配置文件注入过来
    private  /*static final*/ String filePath;//"E:\\projects\\learn-springboot\\src\\main\\resources\\"; //可能是文件目录有问题

    @RequestMapping(value = "upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

        //file.isEmpty();//判断图片是否为空
        //file.getSize();图片大小进行判断
        System.out.println("配置文件注入打印文件目录为" + filePath);

        String name = request.getParameter("name");
        System.out.println("用户名：" + name);
        //获取文件名
        String filename = file.getOriginalFilename();
        System.out.println("上传的文件名：" + filename);

        //获取文件后缀名 比如图片的后缀jpeg，png
        String suffixName = filename.substring(filename.lastIndexOf("."));
        System.out.println("上传文件的后缀名为:" + suffixName);

        //文件上传后路径
        filename = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称：" + filename);
        File dest = new File(filePath + filename);

        try {                   //上传失败报错
            file.transferTo(dest);
            return new JsonData(0, filename);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonData(-1, "fail to sava", null);

    }
}

