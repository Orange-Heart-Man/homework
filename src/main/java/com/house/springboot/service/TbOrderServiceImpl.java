package com.house.springboot.service;

import java.util.List;

import com.house.springboot.bean.TbOrder;
import com.house.springboot.mapper.TbOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单信息Service业务层处理
 * 
 * @date 2023-03-20
 */
@Service
public class TbOrderServiceImpl
{
    @Autowired
    private TbOrderMapper tbOrderMapper;

    /**
     * 查询订单信息
     * 
     * @param id 订单信息主键
     * @return 订单信息
     */
    public TbOrder selectTbOrderById(Long id)
    {
        return tbOrderMapper.selectTbOrderById(id);
    }

    /**
     * 查询订单信息列表
     * 
     * @param tbOrder 订单信息
     * @return 订单信息
     */
    public List<TbOrder> selectTbOrderList(TbOrder tbOrder)
    {
        return tbOrderMapper.selectTbOrderList(tbOrder);
    }

    /**
     * 新增订单信息
     * 
     * @param tbOrder 订单信息
     * @return 结果
     */
    public int insertTbOrder(TbOrder tbOrder)
    {
        return tbOrderMapper.insertTbOrder(tbOrder);
    }

    /**
     * 修改订单信息
     * 
     * @param tbOrder 订单信息
     * @return 结果
     */
    public int updateTbOrder(TbOrder tbOrder)
    {
        return tbOrderMapper.updateTbOrder(tbOrder);
    }

    /**
     * 删除订单信息信息
     * 
     * @param id 订单信息主键
     * @return 结果
     */
    public int deleteTbOrderById(Long id)
    {
        return tbOrderMapper.deleteTbOrderById(id);
    }
}
