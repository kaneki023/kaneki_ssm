package com.kaneki.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.kaneki.ssm.dao.IOrdersDao;
import com.kaneki.ssm.domain.Orders;
import com.kaneki.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {

        //参数pageNum是页码值，参数pageSize代表是每页显示条数
        PageHelper.startPage(1,5);
        return ordersDao.findAll();
    }

    @Override
    public List<Orders> findAll(int page, int size)throws Exception {
        //参数pageNum是页码值，参数pageSize代表是每页显示条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(int ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
