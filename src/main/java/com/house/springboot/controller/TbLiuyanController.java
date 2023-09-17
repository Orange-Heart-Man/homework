package com.house.springboot.controller;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.house.springboot.bean.Admin;
import com.house.springboot.bean.TbHouse;
import com.house.springboot.bean.TbLiuyan;
import com.house.springboot.component.SysResult;
import com.house.springboot.service.TbLiuyanServiceImpl;
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
 * 建议信息Controller
 * 
 * @author ruoyi
 * @date 2023-03-20
 */
@Controller
@RequestMapping("/liuyan")
public class TbLiuyanController
{
    private String prefix = "system/liuyan";

    @Autowired
    private TbLiuyanServiceImpl tbLiuyanService;

    /**
     * 查询建议信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public JSONObject list(TbLiuyan tbLiuyan, int page, int limit, HttpSession session)
    {
        List<TbLiuyan> list = tbLiuyanService.selectTbLiuyanList(tbLiuyan);
        JSONObject json = new JSONObject();

        List<TbLiuyan> result = list.subList((page-1)*limit,page*limit>list.size() ? list.size() : page * limit);

        json.put("total",list.size());
        json.put("result",result);

        return json;
    }

    /**
     * 新增保存建议信息
     */
    @PostMapping("/add")
    @ResponseBody
    public SysResult addSave(TbLiuyan tbLiuyan, HttpSession session)
    {
        // 获取当前用户信息
        Admin admin = (Admin)session.getAttribute("loginUser");

        tbLiuyan.setUserid(admin.getId());
        tbLiuyan.setSubmitdate(new Date());
        tbLiuyanService.insertTbLiuyan(tbLiuyan);

        return SysResult.build(200, "信息已经添加", null);
    }

    /**
     * 修改建议信息
     */
    @GetMapping("/edit/{id}")
    @ResponseBody
    public SysResult edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbLiuyan tbLiuyan = tbLiuyanService.selectTbLiuyanById(id);

        return SysResult.build(200, "获取成功", tbLiuyan);
    }

    /**
     * 修改保存建议信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public SysResult editSave(TbLiuyan tbLiuyan)
    {
        tbLiuyanService.updateTbLiuyan(tbLiuyan);

        return SysResult.build(200, "信息已经修改", null);
    }

    /**
     * 删除建议信息
     */
    @PostMapping( "/remove/{id}")
    @ResponseBody
    public SysResult remove(@PathVariable("id") Long ids)
    {
        tbLiuyanService.deleteTbLiuyanById(ids);

        return SysResult.build(200, "删除成功", null);
    }
}
