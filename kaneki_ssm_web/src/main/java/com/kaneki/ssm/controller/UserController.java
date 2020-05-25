package com.kaneki.ssm.controller;

import com.kaneki.ssm.domain.Role;
import com.kaneki.ssm.domain.UserInfo;
import com.kaneki.ssm.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String  addRoleToUser(@RequestParam(name = "userId",required = true) int id,@RequestParam(name = "ids",required = true) String[] roleIds) throws Exception {
        userService.addRoleToUser(id,roleIds);
        return "redirect:findAll.do";
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name ="id",required = true) int id) throws Exception {//将请求参数id绑定到你控制器的方法参数上
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(id);
        //2.根据用户id查询可以添加的角色
       List<Role> otherRoles =  userService.findOtherRoles(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    //查询指定id的用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo =   userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //用户添加
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
       List<UserInfo> userInfoList =  userService.findAll();
       mv.addObject("userList",userInfoList);
       mv.setViewName("user-list");
        return mv;
    }


}
