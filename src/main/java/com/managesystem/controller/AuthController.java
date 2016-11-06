package com.managesystem.controller;

import com.managesystem.model.User;
import com.managesystem.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

/**
 * Created by cristph on 2016/11/6.
 */

@Controller
public class AuthController {

    @Resource
    AuthService authService;

    @RequestMapping("/login")
    public String loginView(){
        return "auth/login";
    }

    @ResponseBody
    @RequestMapping(value = "/login/post",method = RequestMethod.POST)
    public String loginPost(@RequestParam("email")String email,
                            @RequestParam("identity")String identity,
                            @RequestParam("password")String password,
                            HttpServletRequest request){
        User u=new User();
        u.setName(email);
        u.setIdentity(identity);
        u.setPswd(password);
        String str=authService.isExist(u);
        System.out.println("login result:"+str);

        HttpSession session=request.getSession();
        session.setAttribute("identity",u.getIdentity());
        session.setAttribute("username",u.getName());
        return str;
    }

    @ResponseBody
    @RequestMapping(value = "/register/post",method = RequestMethod.POST)
    public String registerPost(HttpServletRequest request,
                               @RequestParam("identity")String identity,
                               @RequestParam("email")String email,
                               @RequestParam("password")String password){

        User u=new User();
        u.setName(email);
        u.setIdentity(identity);
        u.setPswd(password);

        authService.save(u);
        return "success";
    }

    @RequestMapping("/register")
    public String registerView(){
        return "auth/register";
    }


    @RequestMapping("/login/route")
    public String loginRoute(RedirectAttributes redirectAttributes,
                             HttpServletRequest request,
                             Model model){
        HttpSession session=request.getSession();
        if(session.getAttribute("identity")!=null){
            String identity=(String)session.getAttribute("identity");
            if(identity.equals("poster")){
                return "redirect:/poster";
            }else if(identity.equals("tracer")){
                return "redirect:/tracer";
            }
        }
        return "redirect:/register";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        return "redirect:/login";
    }
}

