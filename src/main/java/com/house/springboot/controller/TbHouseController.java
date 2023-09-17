package com.house.springboot.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.house.springboot.bean.Admin;
import com.house.springboot.bean.TbCategory;
import com.house.springboot.bean.TbHouse;
import com.house.springboot.bean.TbOrder;
import com.house.springboot.component.SysResult;
import com.house.springboot.service.TbCategoryServiceImpl;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 * 房屋信息Controller
 * 
 * @date 2023-03-20
 */
@Controller
@RequestMapping("/house")
public class TbHouseController
{

    @Autowired
    private TbHouseServiceImpl tbHouseService;

    @Autowired
    private TbCategoryServiceImpl categoryService;

    @Autowired
    private TbOrderServiceImpl orderService;

    /**
     * 上传封面图片
     * @param file
     * @return
     */
    @ResponseBody
    @PostMapping("/upload")
    public SysResult uploadfile(MultipartHttpServletRequest file) {
        String path = tbHouseService.sevefile(file);
        if (path.equals("no")) {
            return SysResult.build(400, "图片不合法", null);
        }
        return SysResult.build(0, "返回图片路径", path);
    }

    /**
     * 查询房屋信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public JSONObject list(TbHouse tbHouse, int page, int limit, HttpSession session)
    {
        // 获取当前用户信息
        Admin admin = (Admin)session.getAttribute("loginUser");
        if(admin.getRole().equals("3")){
            tbHouse.setPublisherId(admin.getId());
        }

        List<TbHouse> list = tbHouseService.selectTbHouseList(tbHouse);

        JSONObject json = new JSONObject();

        List<TbHouse> result = list.subList((page-1)*limit,page*limit>list.size() ? list.size() : page * limit);

        for(TbHouse house : result){
            TbCategory tbCategory = categoryService.selectTbCategoryById(house.getCategoryId());
            house.setCategoryName(tbCategory.getName());
        }

        json.put("total",list.size());
        json.put("result",result);

        return json;
    }

    /**
     * 获取所有房屋记录信息
     * @param tbHouse
     * @return
     */
    @PostMapping("/list_lease")
    @ResponseBody
    public JSONObject list_lease(TbHouse tbHouse, HttpSession session){
        // 获取当前用户信息
        Admin admin = (Admin)session.getAttribute("loginUser");

        // 按照房屋面积条件筛选
        if(tbHouse.getHouseArea() == 1){
            tbHouse.setHouseAreaStart(0);
            tbHouse.setHouseAreaEnd(50);
        }else if(tbHouse.getHouseArea() == 2){
            tbHouse.setHouseAreaStart(50);
            tbHouse.setHouseAreaEnd(70);
        }else if(tbHouse.getHouseArea() == 3){
            tbHouse.setHouseAreaStart(70);
            tbHouse.setHouseAreaEnd(110);
        }else if(tbHouse.getHouseArea() == 4){
            tbHouse.setHouseAreaStart(110);
            tbHouse.setHouseAreaEnd(150);
        }else if(tbHouse.getHouseArea() == 5){
            tbHouse.setHouseAreaStart(150);
            tbHouse.setHouseAreaEnd(200);
        }else if(tbHouse.getHouseArea() == 6){
            tbHouse.setHouseAreaStart(200);
            tbHouse.setHouseAreaEnd(10000);
        }

        // 按照房屋价格条件筛选
        if(tbHouse.getHousePrice() == 1){
            tbHouse.setHousePriceStart(0);
            tbHouse.setHousePriceEnd(300);
        }else if(tbHouse.getHousePrice() == 2){
            tbHouse.setHousePriceStart(300);
            tbHouse.setHousePriceEnd(400);
        }else if(tbHouse.getHousePrice() == 3){
            tbHouse.setHousePriceStart(400);
            tbHouse.setHousePriceEnd(600);
        }else if(tbHouse.getHousePrice() == 4){
            tbHouse.setHousePriceStart(600);
            tbHouse.setHousePriceEnd(800);
        }else if(tbHouse.getHousePrice() == 5){
            tbHouse.setHousePriceStart(800);
            tbHouse.setHousePriceEnd(1000);
        }else if(tbHouse.getHousePrice() == 6){
            tbHouse.setHousePriceStart(1000);
            tbHouse.setHousePriceEnd(10000);
        }

        List<TbHouse> list = tbHouseService.selectTbHouseList(tbHouse);

        JSONObject json = new JSONObject();

        for(TbHouse house : list){
            TbCategory tbCategory = categoryService.selectTbCategoryById(house.getCategoryId());
            house.setCategoryName(tbCategory.getName());

            TbOrder order = new TbOrder();
            order.setHouseId(house.getId());
            order.setUserId(admin.getId());
            List<TbOrder> tbOrders = orderService.selectTbOrderList(order);

            if(tbOrders.size() > 0){
                house.setIsBook(1);
            }else{
                house.setIsBook(0);
            }
        }

        json.put("result",list);

        return json;
    }

    /**
     * 新增保存房屋信息
     */
    @PostMapping("/add")
    @ResponseBody
    public SysResult addSave(TbHouse tbHouse, HttpSession session)
    {
        Admin admin = (Admin)session.getAttribute("loginUser");

        if(admin.getRole().equals("2")){
            tbHouse.setPublisherId(admin.getId());
        }

        tbHouseService.insertTbHouse(tbHouse);
        return SysResult.build(200, "信息已经添加", null);
    }

    /**
     * 修改房屋信息
     */
    @GetMapping("/edit/{id}")
    @ResponseBody
    public SysResult edit(@PathVariable("id") Long id, ModelMap mmap, HttpSession session)
    {
        // 获取当前用户信息
        Admin admin = (Admin)session.getAttribute("loginUser");
        TbHouse tbHouse = tbHouseService.selectTbHouseById(id);

        TbOrder order = new TbOrder();
        order.setHouseId(id);
        order.setUserId(admin.getId());
        List<TbOrder> tbOrders = orderService.selectTbOrderList(order);

        if(tbOrders.size() > 0){
            tbHouse.setIsBook(1);
        }else{
            tbHouse.setIsBook(0);
        }

        return SysResult.build(200, "获取成功", tbHouse);
    }

    /**
     * 修改保存房屋信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public SysResult editSave(TbHouse tbHouse)
    {
        tbHouseService.updateTbHouse(tbHouse);
        return SysResult.build(200, "信息已经修改", null);
    }

    /**
     * 删除房屋信息
     */
    @PostMapping( "/remove/{id}")
    @ResponseBody
    public SysResult remove(@PathVariable("id") Long  ids)
    {
        tbHouseService.deleteTbHouseById(ids);
        return SysResult.build(200, "删除成功", null);
    }

    /**
     * 预定房屋信息
     * @param ids
     * @return
     */
    @PostMapping( "/book/{id}")
    @ResponseBody
    public SysResult book(@PathVariable("id") Long  ids, HttpSession session)
    {
        Admin admin = (Admin)session.getAttribute("loginUser");

        TbOrder order = new TbOrder();
        order.setHouseId(ids);
        order.setUserId(admin.getId());
        order.setUsername(admin.getAccount());

        orderService.insertTbOrder(order);
        return SysResult.build(200, "预定成功", null);
    }
}
