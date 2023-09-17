package com.house.springboot.service;

import java.util.List;

import com.house.springboot.bean.TbLiuyan;
import com.house.springboot.mapper.TbLiuyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 建议信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-20
 */
@Service
public class TbLiuyanServiceImpl
{
    @Autowired
    private TbLiuyanMapper tbLiuyanMapper;

    /**
     * 查询建议信息
     * 
     * @param id 建议信息主键
     * @return 建议信息
     */
    public TbLiuyan selectTbLiuyanById(Long id)
    {
        return tbLiuyanMapper.selectTbLiuyanById(id);
    }

    /**
     * 查询建议信息列表
     * 
     * @param tbLiuyan 建议信息
     * @return 建议信息
     */
    public List<TbLiuyan> selectTbLiuyanList(TbLiuyan tbLiuyan)
    {
        return tbLiuyanMapper.selectTbLiuyanList(tbLiuyan);
    }

    /**
     * 新增建议信息
     * 
     * @param tbLiuyan 建议信息
     * @return 结果
     */
    public int insertTbLiuyan(TbLiuyan tbLiuyan)
    {
        return tbLiuyanMapper.insertTbLiuyan(tbLiuyan);
    }

    /**
     * 修改建议信息
     * 
     * @param tbLiuyan 建议信息
     * @return 结果
     */
    public int updateTbLiuyan(TbLiuyan tbLiuyan)
    {
        return tbLiuyanMapper.updateTbLiuyan(tbLiuyan);
    }

    /**
     * 删除建议信息信息
     * 
     * @param id 建议信息主键
     * @return 结果
     */
    public int deleteTbLiuyanById(Long id)
    {
        return tbLiuyanMapper.deleteTbLiuyanById(id);
    }
}
