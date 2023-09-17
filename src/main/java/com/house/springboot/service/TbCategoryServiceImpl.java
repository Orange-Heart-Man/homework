package com.house.springboot.service;

import java.util.List;

import com.house.springboot.bean.TbCategory;
import com.house.springboot.mapper.TbCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 分类管理Service业务层处理
 * 
 * @date 2023-03-20
 */
@Service
public class TbCategoryServiceImpl
{
    @Autowired
    private TbCategoryMapper tbCategoryMapper;

    /**
     * 查询分类管理
     * 
     * @param id 分类管理主键
     * @return 分类管理
     */
    public TbCategory selectTbCategoryById(Long id)
    {
        return tbCategoryMapper.selectTbCategoryById(id);
    }

    /**
     * 查询分类管理列表
     * 
     * @param tbCategory 分类管理
     * @return 分类管理
     */
    public List<TbCategory> selectTbCategoryList(TbCategory tbCategory)
    {
        return tbCategoryMapper.selectTbCategoryList(tbCategory);
    }

    /**
     * 新增分类管理
     * 
     * @param tbCategory 分类管理
     * @return 结果
     */
    public int insertTbCategory(TbCategory tbCategory)
    {
        return tbCategoryMapper.insertTbCategory(tbCategory);
    }

    /**
     * 修改分类管理
     * 
     * @param tbCategory 分类管理
     * @return 结果
     */
    public int updateTbCategory(TbCategory tbCategory)
    {
        return tbCategoryMapper.updateTbCategory(tbCategory);
    }

    /**
     * 删除分类管理信息
     * 
     * @param id 分类管理主键
     * @return 结果
     */
    public int deleteTbCategoryById(Long id)
    {
        return tbCategoryMapper.deleteTbCategoryById(id);
    }
}
