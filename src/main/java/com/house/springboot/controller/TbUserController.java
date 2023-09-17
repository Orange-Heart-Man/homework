package com.house.springboot.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.house.springboot.bean.Admin;
import com.house.springboot.bean.TbHouse;
import com.house.springboot.bean.TbOrder;
import com.house.springboot.bean.TbUser;
import com.house.springboot.component.SysResult;
import com.house.springboot.service.TbUserServiceImpl;
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
 * 用户信息Controller
 * 
 * @date 2023-03-20
 */
@Controller
@RequestMapping("/user")
public class TbUserController
{

    @Autowired
    private TbUserServiceImpl tbUserService;

    /**
     * 查询用户信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public JSONObject list(TbUser tbUser, int page, int limit)
    {
        List<TbUser> list = tbUserService.selectTbUserList(tbUser);

        JSONObject json = new JSONObject();

        List<TbUser> result = list.subList((page-1)*limit,page*limit>list.size() ? list.size() : page * limit);

        json.put("total",list.size());
        json.put("result",result);

        return json;
    }

    /**
     * 新增保存用户信息
     */
    @PostMapping("/add")
    @ResponseBody
    public SysResult addSave(TbUser tbUser)
    {
        tbUserService.insertTbUser(tbUser);
        return SysResult.build(200, "信息已经添加", null);
    }

    /**
     * 修改用户信息
     */
    @GetMapping("/edit/{id}")
    @ResponseBody
    public SysResult edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbUser tbUser = tbUserService.selectTbUserById(id);

        return SysResult.build(200, "获取成功", tbUser);
    }

    /**
     * 修改保存用户信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public SysResult editSave(TbUser tbUser, HttpSession session)
    {
        tbUserService.updateTbUser(tbUser);

        return SysResult.build(200, "信息已经修改", null);
    }


    @PostMapping("/resetPwd")
    @ResponseBody
    public SysResult resetPwd(TbUser tbUser, HttpSession session)
    {
        // 获取当前用户信息
        Admin currentAdmin = (Admin)session.getAttribute("loginUser");

        if(!tbUser.getOldpassword().equals(currentAdmin.getPassword())){
            return SysResult.build(400, "原始密码错误", null);
        }

        TbUser admin = tbUserService.selectTbUserById(currentAdmin.getId());
        admin.setPassword(tbUser.getNewpassword());

        tbUserService.updateTbUser(admin);

        return SysResult.build(200, "信息已经修改", null);
    }

    /**
     * 删除用户信息
     */
    @PostMapping( "/remove/{id}")
    @ResponseBody
    public SysResult remove(@PathVariable("id") Long ids)
    {
        tbUserService.deleteTbUserById(ids);
        return SysResult.build(200, "删除成功", null);
    }
}
