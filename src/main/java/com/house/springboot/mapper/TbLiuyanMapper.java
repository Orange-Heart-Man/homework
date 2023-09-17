package com.house.springboot.mapper;

import com.house.springboot.bean.TbLiuyan;

import java.util.List;

/**
 * 建议信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-20
 */
public interface TbLiuyanMapper 
{
    /**
     * 查询建议信息
     * 
     * @param id 建议信息主键
     * @return 建议信息
     */
    public TbLiuyan selectTbLiuyanById(Long id);

    /**
     * 查询建议信息列表
     * 
     * @param tbLiuyan 建议信息
     * @return 建议信息集合
     */
    public List<TbLiuyan> selectTbLiuyanList(TbLiuyan tbLiuyan);

    /**
     * 新增建议信息
     * 
     * @param tbLiuyan 建议信息
     * @return 结果
     */
    public int insertTbLiuyan(TbLiuyan tbLiuyan);

    /**
     * 修改建议信息
     * 
     * @param tbLiuyan 建议信息
     * @return 结果
     */
    public int updateTbLiuyan(TbLiuyan tbLiuyan);

    /**
     * 删除建议信息
     * 
     * @param id 建议信息主键
     * @return 结果
     */
    public int deleteTbLiuyanById(Long id);

    /**
     * 批量删除建议信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbLiuyanByIds(String[] ids);
}
