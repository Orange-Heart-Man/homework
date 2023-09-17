package com.house.springboot.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.house.springboot.bean.Admin;
import com.house.springboot.bean.TbCategory;
import com.house.springboot.bean.TbHouse;
import com.house.springboot.bean.TbOrder;
import com.house.springboot.component.SysResult;
import com.house.springboot.service.TbHouseServiceImpl;
import com.house.springboot.service.TbOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 订单信息Controller
 * 
 * @date 2023-03-20
 */
@Controller
@RequestMapping("/order")
public class TbOrderController
{

    @Autowired
    private TbOrderServiceImpl tbOrderService;

    @Autowired
    private TbHouseServiceImpl houseService;

    /**
     * 查询订单信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public JSONObject list(TbOrder tbOrder, int page, int limit)
    {
        List<TbOrder> list = tbOrderService.selectTbOrderList(tbOrder);

        JSONObject json = new JSONObject();

        List<TbOrder> result = list.subList((page-1)*limit,page*limit>list.size() ? list.size() : page * limit);

        json.put("total",list.size());
        json.put("result",result);

        return json;
    }


    /**
     * 查询订单信息列表
     */
    @PostMapping("/mylist")
    @ResponseBody
    public JSONObject mylist(TbOrder tbOrder, int page, int limit, HttpSession session)
    {
        Admin admin = (Admin)session.getAttribute("loginUser");
        tbOrder.setUserId(admin.getId());
        List<TbOrder> list = tbOrderService.selectTbOrderList(tbOrder);

        JSONObject json = new JSONObject();

        List<TbOrder> result = list.subList((page-1)*limit,page*limit>list.size() ? list.size() : page * limit);

        for(TbOrder order : result){
            TbHouse house = houseService.selectTbHouseById(order.getHouseId());

            if(house != null){
                order.setHouseName(house.getHouseDesc());
            }
        }

        json.put("total",list.size());
        json.put("result",result);

        return json;
    }

    /**
     * 新增保存订单信息
     */
    @PostMapping("/add")
    @ResponseBody
    public SysResult addSave(TbOrder tbOrder)
    {
        tbOrderService.insertTbOrder(tbOrder);

        return SysResult.build(200, "信息已经添加", null);
    }

    /**
     * 修改房屋信息
     */
    @GetMapping("/edit/{id}")
    @ResponseBody
    public SysResult edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbOrder tbOrder = tbOrderService.selectTbOrderById(id);

        return SysResult.build(200, "获取成功", tbOrder);
    }

    /**
     * 修改保存订单信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public SysResult editSave(TbOrder tbOrder)
    {
        tbOrderService.updateTbOrder(tbOrder);

        return SysResult.build(200, "信息已经修改", null);
    }

    /**
     * 删除订单信息
     */
    @PostMapping( "/remove/{id}")
    @ResponseBody
    public SysResult remove(@PathVariable("id") Long ids)
    {
        tbOrderService.deleteTbOrderById(ids);

        return SysResult.build(200, "删除成功", null);
    }
}
