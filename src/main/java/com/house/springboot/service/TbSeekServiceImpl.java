package com.house.springboot.service;

import java.util.List;

import com.house.springboot.bean.TbSeek;
import com.house.springboot.mapper.TbSeekMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 求租信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
@Service
public class TbSeekServiceImpl
{
    @Autowired
    private TbSeekMapper tbSeekMapper;

    /**
     * 查询求租信息
     * 
     * @param id 求租信息主键
     * @return 求租信息
     */
    public TbSeek selectTbSeekById(Long id)
    {
        return tbSeekMapper.selectTbSeekById(id);
    }

    /**
     * 查询求租信息列表
     * 
     * @param tbSeek 求租信息
     * @return 求租信息
     */
    public List<TbSeek> selectTbSeekList(TbSeek tbSeek)
    {
        return tbSeekMapper.selectTbSeekList(tbSeek);
    }

    /**
     * 新增求租信息
     * 
     * @param tbSeek 求租信息
     * @return 结果
     */
    public int insertTbSeek(TbSeek tbSeek)
    {
        return tbSeekMapper.insertTbSeek(tbSeek);
    }

    /**
     * 修改求租信息
     * 
     * @param tbSeek 求租信息
     * @return 结果
     */
    public int updateTbSeek(TbSeek tbSeek)
    {
        return tbSeekMapper.updateTbSeek(tbSeek);
    }


    /**
     * 删除求租信息信息
     * 
     * @param id 求租信息主键
     * @return 结果
     */
    public int deleteTbSeekById(Long id)
    {
        return tbSeekMapper.deleteTbSeekById(id);
    }
}
