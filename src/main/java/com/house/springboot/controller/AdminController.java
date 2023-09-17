package com.house.springboot.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.house.springboot.component.SysResult;
import com.house.springboot.bean.Admin;
import com.house.springboot.service.AdminServiceImpl;
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
@RequestMapping("/admin")
public class AdminController
{
    private String prefix = "system/admin";

    @Autowired
    private AdminServiceImpl adminService;

    /**
     * 查询用户信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public JSONObject list(Admin admin, int page, int limit)
    {
        List<Admin> list = adminService.selectAdminList(admin);
        JSONObject json = new JSONObject();

        List<Admin> result = list.subList((page-1)*limit,page*limit>list.size() ? list.size() : page * limit);

        json.put("total",list.size());
        json.put("result",result);

        return json;
    }

    /**
     * 新增保存用户信息
     */
    @PostMapping("/add")
    @ResponseBody
    public SysResult addSave(Admin admin)
    {
        adminService.insertAdmin(admin);

        return SysResult.build(200, "信息已经添加", null);
    }

    /**
     * 修改用户信息
     */
    @GetMapping("/edit/{id}")
    @ResponseBody
    public SysResult edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Admin admin = adminService.selectAdminById(id);

        return SysResult.build(200, "获取成功", admin);
    }

    /**
     * 修改保存用户信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public SysResult editSave(Admin adminCondition, HttpSession session)
    {
        // 获取当前用户信息
        Admin currentAdmin = (Admin)session.getAttribute("loginUser");

        if(!adminCondition.getOldpassword().equals(currentAdmin.getPassword())){
            return SysResult.build(400, "原始密码错误", null);
        }

        Admin admin = adminService.selectAdminById(currentAdmin.getId());
        admin.setPassword(adminCondition.getNewpassword());
        adminService.updateAdmin(admin);

        return SysResult.build(200, "修改成功", null);
    }

    /**
     * 删除用户信息
     */
    @PostMapping( "/remove/{id}")
    @ResponseBody
    public SysResult remove(@PathVariable("id") Long id)
    {
        adminService.deleteAdminById(id);

        return SysResult.build(200, "删除成功", null);
    }
}
