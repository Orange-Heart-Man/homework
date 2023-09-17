package com.house.springboot.mapper;

import com.house.springboot.bean.TbSeek;

import java.util.List;

/**
 * 求租信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
public interface TbSeekMapper 
{
    /**
     * 查询求租信息
     * 
     * @param id 求租信息主键
     * @return 求租信息
     */
    public TbSeek selectTbSeekById(Long id);

    /**
     * 查询求租信息列表
     * 
     * @param tbSeek 求租信息
     * @return 求租信息集合
     */
    public List<TbSeek> selectTbSeekList(TbSeek tbSeek);

    /**
     * 新增求租信息
     * 
     * @param tbSeek 求租信息
     * @return 结果
     */
    public int insertTbSeek(TbSeek tbSeek);

    /**
     * 修改求租信息
     * 
     * @param tbSeek 求租信息
     * @return 结果
     */
    public int updateTbSeek(TbSeek tbSeek);

    /**
     * 删除求租信息
     * 
     * @param id 求租信息主键
     * @return 结果
     */
    public int deleteTbSeekById(Long id);

    /**
     * 批量删除求租信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbSeekByIds(String[] ids);
}
