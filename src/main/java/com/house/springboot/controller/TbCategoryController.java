package com.house.springboot.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.house.springboot.bean.TbCategory;
import com.house.springboot.component.SysResult;
import com.house.springboot.service.TbCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 分类管理Controller
 * 
 * @date 2023-03-20
 */
@Controller
@RequestMapping("/category")
public class TbCategoryController
{

    @Autowired
    private TbCategoryServiceImpl tbCategoryService;

    /**
     * 查询分类管理列表
     */
    @PostMapping("/list")
    @ResponseBody
    public JSONObject list(TbCategory tbCategory, int page, int limit)
    {
        List<TbCategory> list = tbCategoryService.selectTbCategoryList(tbCategory);

        JSONObject json = new JSONObject();

        List<TbCategory> result = list.subList((page-1)*limit,page*limit>list.size() ? list.size() : page * limit);

        json.put("total",list.size());
        json.put("result",result);

        return json;
    }

    /**
     * 获取所有的分类信息
     * @param tbCategory
     * @return
     */
    @GetMapping("/listAll")
    @ResponseBody
    public List<TbCategory> listAll(TbCategory tbCategory)
    {
        List<TbCategory> list = tbCategoryService.selectTbCategoryList(tbCategory);

        return list;
    }

    /**
     * 新增保存分类管理
     */
    @PostMapping("/add")
    @ResponseBody
    public SysResult addSave(TbCategory tbCategory)
    {
        tbCategoryService.insertTbCategory(tbCategory);

        return SysResult.build(200, "信息已经添加", null);
    }

    /**
     * 修改分类管理
     */
    @GetMapping("/edit/{id}")
    @ResponseBody
    public SysResult edit(@PathVariable("id") Long id)
    {
        TbCategory tbCategory = tbCategoryService.selectTbCategoryById(id);

        return SysResult.build(200, "获取成功", tbCategory);
    }

    /**
     * 修改保存分类管理
     */
    @PostMapping("/edit")
    @ResponseBody
    public SysResult editSave(TbCategory tbCategory)
    {
        tbCategoryService.updateTbCategory(tbCategory);
        return SysResult.build(200, "信息已经修改", null);
    }

    /**
     * 删除分类管理
     */
    @PostMapping( "/remove/{id}")
    @ResponseBody
    public SysResult remove(@PathVariable("id") Long ids)
    {
        tbCategoryService.deleteTbCategoryById(ids);

        return SysResult.build(200, "删除成功", null);
    }
}
