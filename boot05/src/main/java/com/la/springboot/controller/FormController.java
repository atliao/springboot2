package com.la.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author LA
 * @date 2022-09-21-9:37
 * 文件上传
 */
@Slf4j
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestPart("userImg") MultipartFile userImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息: username={},email={},userImg={},photos={}",
                email,username,userImg.getSize(),photos.length);

        if(!userImg.isEmpty()){
            String filename = null;

            //方式一：原文件名，但若文件名重复，则会覆盖
            //filename= userImg.getOriginalFilename();

            //方式二：随机码作为文件名
            //获取文件后缀名
            filename= userImg.getOriginalFilename();
            String suffixName = filename.substring(filename.lastIndexOf("."));
            //将 UUID + 后缀 作为文件名(生成随机文件名)----->防止上传文件重名而造成覆盖
            String uuid = UUID.randomUUID().toString();
            String uuidNew = uuid.replaceAll("-",""); //将 "-" 替换为空字符串
            filename = uuidNew + suffixName;
            userImg.transferTo(new File("D:\\JavaFileTest\\" + filename));
        }

        if(photos.length > 0){
            for(MultipartFile photo : photos){
                if(!photo.isEmpty()){

                    String filename = null;

                    //方式一：原文件名，但若文件名重复，则会覆盖
                    //filename= userImg.getOriginalFilename();

                    //方式二：随机码作为文件名
                    //获取文件后缀名
                    filename= photo.getOriginalFilename();
                    String suffixName = filename.substring(filename.lastIndexOf("."));
                    //将 UUID + 后缀 作为文件名(生成随机文件名)----->防止上传文件重名而造成覆盖
                    String uuid = UUID.randomUUID().toString();
                    String uuidNew = uuid.replaceAll("-",""); //将 "-" 替换为空字符串
                    filename = uuidNew + suffixName;
                    photo.transferTo(new File("D:\\JavaFileTest\\" + filename));
                }
            }
        }
        return "main";
    }
}
