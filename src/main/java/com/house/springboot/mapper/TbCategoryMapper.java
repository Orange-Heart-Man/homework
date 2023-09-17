package com.house.springboot.mapper;

import com.house.springboot.bean.TbCategory;

import java.util.List;

/**
 * 分类管理Mapper接口
 * 
 * @date 2023-03-20
 */
public interface TbCategoryMapper 
{
    /**
     * 查询分类管理
     * 
     * @param id 分类管理主键
     * @return 分类管理
     */
    public TbCategory selectTbCategoryById(Long id);

    /**
     * 查询分类管理列表
     * 
     * @param tbCategory 分类管理
     * @return 分类管理集合
     */
    public List<TbCategory> selectTbCategoryList(TbCategory tbCategory);

    /**
     * 新增分类管理
     * 
     * @param tbCategory 分类管理
     * @return 结果
     */
    public int insertTbCategory(TbCategory tbCategory);

    /**
     * 修改分类管理
     * 
     * @param tbCategory 分类管理
     * @return 结果
     */
    public int updateTbCategory(TbCategory tbCategory);

    /**
     * 删除分类管理
     * 
     * @param id 分类管理主键
     * @return 结果
     */
    public int deleteTbCategoryById(Long id);

    /**
     * 批量删除分类管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbCategoryByIds(String[] ids);
}
