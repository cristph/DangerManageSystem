package com.managesystem.controller;

import com.managesystem.model.Danger;
import com.managesystem.service.AuthService;
import com.managesystem.service.DangerService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cristph on 2016/11/6.
 */

@Controller
public class DangerController {

    @Resource
    DangerService dangerService;

    @RequestMapping("/poster")
    public String poserView(HttpServletRequest request,
                            Model model){
        HttpSession session=request.getSession();
        if(session.getAttribute("username")!=null){
            String username=(String)session.getAttribute("username");
            model.addAttribute("username",username);
        }
        return "manage/poster";
    }

    @ResponseBody
    @RequestMapping(value = "/addDanger",method = RequestMethod.POST)
    public String addDanger(@RequestParam("content")String content,
                            @RequestParam("possiblity")String possiblity,
                            @RequestParam("effect")String effect,
                            @RequestParam("limit")String limit,
                            @RequestParam("poster")String poster,
                            @RequestParam("tracer")String tracer
                            ){
        Danger danger=new Danger();
        danger.setContent(content);
        danger.setPossiblity(possiblity);
        danger.setEffect(effect);
        danger.setThreshold(limit);
        danger.setPoster(poster);
        danger.setTracer(tracer);
        System.out.println(danger.toString());
        dangerService.save(danger);

        return "success";
    }

    @RequestMapping("/postedList")
    public String postedListView(HttpServletRequest request, Model model){
        HttpSession session=request.getSession();
        if(session.getAttribute("username")!=null){
            String username=(String)session.getAttribute("username");
            System.out.println("search for "+username);
            List<Danger> dangerList=dangerService.getPostedDangerList(username);
            model.addAttribute("dangerList",dangerList);
        }
        return "manage/postedList";
    }

    @RequestMapping("/tracer")
    public String tracerView(HttpServletRequest request, Model model){
        HttpSession session=request.getSession();
        if(session.getAttribute("username")!=null){
            String username=(String)session.getAttribute("username");
            System.out.println("search for "+username);
            List<Danger> dangerList=dangerService.getDangerList(username);
            model.addAttribute("dangerList",dangerList);
        }
        return "manage/tracer";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("did")String did,
                       Model model){
        Danger danger=dangerService.get(Integer.parseInt(did));
        model.addAttribute("danger",danger);
        return "manage/tracerUpdate";
    }


    @ResponseBody
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public String update(@RequestParam("did")String did,
                         @RequestParam("conditiondescription")String conditiondescription,
                         @RequestParam("desccription")String desccription,
                         Model model){
        dangerService.update(Integer.parseInt(did),conditiondescription,desccription);
        return "success";
    }
}
