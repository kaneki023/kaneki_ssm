package com.kaneki.ssm.controller;

import com.kaneki.ssm.domain.Product;
import com.kaneki.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    //产品添加
    @RequestMapping("/save.do")
    public String  save(Product product) throws Exception {
        iProductService.save(product);
        return "redirect:findAll.do";
    }

    //查询全部产品
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = iProductService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list1");
        return mv;
    }
}
