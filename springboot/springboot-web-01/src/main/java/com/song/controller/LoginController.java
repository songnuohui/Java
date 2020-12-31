package com.song.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    /**登录**/
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session)
    {
        if(!StringUtils.isEmpty(username)&&"123".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/index";//重定向到index中
        }
        else {
            model.addAttribute("msg","用户名或者密码错误！");
            return "login";
        }
    }
    /**注销**/
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
