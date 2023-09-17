package com.house.springboot.controller;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.house.springboot.bean.Admin;
import com.house.springboot.bean.TbLiuyan;
import com.house.springboot.bean.TbSeek;
import com.house.springboot.component.SysResult;
import com.house.springboot.service.TbSeekServiceImpl;
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
 * 求租信息Controller
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
@Controller
@RequestMapping("/seek")
public class TbSeekController
{
    private String prefix = "system/seek";

    @Autowired
    private TbSeekServiceImpl tbSeekService;

    /**
     * 查询求租信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public JSONObject list(TbSeek tbSeek, int page, int limit)
    {
        List<TbSeek> list = tbSeekService.selectTbSeekList(tbSeek);
        JSONObject json = new JSONObject();

        List<TbSeek> result = list.subList((page-1)*limit,page*limit>list.size() ? list.size() : page * limit);

        json.put("total",list.size());
        json.put("result",result);

        return json;
    }

    /**
     * 新增保存求租信息
     */
    @PostMapping("/add")
    @ResponseBody
    public SysResult addSave(TbSeek tbSeek, HttpSession session)
    {
        // 获取当前用户信息
        Admin admin = (Admin)session.getAttribute("loginUser");

        tbSeek.setUserId(admin.getId());
        tbSeek.setPhone(admin.getPhone());
        tbSeek.setUserName(admin.getAccount());
        tbSeek.setSubmitdate(new Date());
        tbSeekService.insertTbSeek(tbSeek);

        return SysResult.build(200, "信息已经添加", null);
    }

    /**
     * 修改求租信息
     */
    @GetMapping("/edit/{id}")
    @ResponseBody
    public SysResult edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbSeek tbSeek = tbSeekService.selectTbSeekById(id);

        return SysResult.build(200, "获取成功", tbSeek);
    }

    /**
     * 修改保存求租信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public SysResult editSave(TbSeek tbSeek)
    {
        tbSeekService.updateTbSeek(tbSeek);

        return SysResult.build(200, "信息已经修改", null);
    }

    /**
     * 删除求租信息
     */
    @PostMapping( "/remove/{id}")
    @ResponseBody
    public SysResult remove(@PathVariable("id") Long ids)
    {
        tbSeekService.deleteTbSeekById(ids);

        return SysResult.build(200, "删除成功", null);
    }
}
