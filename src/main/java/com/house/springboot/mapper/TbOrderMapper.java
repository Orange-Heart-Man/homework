package com.house.springboot.mapper;

import com.house.springboot.bean.TbOrder;

import java.util.List;

/**
 * 订单信息Mapper接口
 * 
 * @date 2023-03-20
 */
public interface TbOrderMapper 
{
    /**
     * 查询订单信息
     * 
     * @param id 订单信息主键
     * @return 订单信息
     */
    public TbOrder selectTbOrderById(Long id);

    /**
     * 查询订单信息列表
     * 
     * @param tbOrder 订单信息
     * @return 订单信息集合
     */
    public List<TbOrder> selectTbOrderList(TbOrder tbOrder);

    /**
     * 新增订单信息
     * 
     * @param tbOrder 订单信息
     * @return 结果
     */
    public int insertTbOrder(TbOrder tbOrder);

    /**
     * 修改订单信息
     * 
     * @param tbOrder 订单信息
     * @return 结果
     */
    public int updateTbOrder(TbOrder tbOrder);

    /**
     * 删除订单信息
     * 
     * @param id 订单信息主键
     * @return 结果
     */
    public int deleteTbOrderById(Long id);

    /**
     * 批量删除订单信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbOrderByIds(String[] ids);
}
