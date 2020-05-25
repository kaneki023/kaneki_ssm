package com.kaneki.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.kaneki.ssm.domain.Orders;
import com.kaneki.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;


    //查询全部订单----未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll()throws Exception{
//        ModelAndView mv = new ModelAndView();
//        List<Orders> list = iOrdersService.findAll();
//        mv.addObject("ordersList",list);
//        mv.setViewName("orders-list");
//        return mv;
//    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "4")int size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> list =iOrdersService.findAll(page,size);
        //PageInfo就是一个分页的bean
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) int ordersId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Orders orders =  iOrdersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
