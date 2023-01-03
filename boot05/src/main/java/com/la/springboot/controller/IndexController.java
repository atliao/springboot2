package com.la.springboot.controller;

import com.la.springboot.bean.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author LA
 * @date 2022-09-20-10:47
 */
@Slf4j
@Controller
public class IndexController {

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/addCity")
    public String addCityPage() {
        return "addCity";
    }


    @PostMapping("/login")
    public String main(User user,HttpSession session,Model model){

        if(StringUtils.hasLength(user.getUsername()) && "123456".equals(user.getPassword())){
            System.out.println(123);
            //登陆成功保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向
            return "redirect:/mainPage";
        }else{
            model.addAttribute("msg","账号密码错误!");
            //回到登录界面
            return "login";
        }
    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/mainPage")
    public String mainPage(HttpSession session, Model model){

        log.info("当前方式为：{}","mainPage");
        //在拦截器里配置了

        //是否登录
       /* Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return "main";
        }else{
            model.addAttribute("msg","请重新登录");
            return "redirect:/";
        }*/

        return "main";
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        String sql = "select count(*) from t_account";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return "总记录数：" + count.toString();
    }
}
