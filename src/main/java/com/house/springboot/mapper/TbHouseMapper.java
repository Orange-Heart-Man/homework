package com.house.springboot.mapper;

import com.house.springboot.bean.TbHouse;

import java.util.List;

/**
 * 房屋信息Mapper接口
 * 
 * @date 2023-03-20
 */
public interface TbHouseMapper 
{
    /**
     * 查询房屋信息
     * 
     * @param id 房屋信息主键
     * @return 房屋信息
     */
    public TbHouse selectTbHouseById(Long id);

    /**
     * 查询房屋信息列表
     * 
     * @param tbHouse 房屋信息
     * @return 房屋信息集合
     */
    public List<TbHouse> selectTbHouseList(TbHouse tbHouse);

    /**
     * 新增房屋信息
     * 
     * @param tbHouse 房屋信息
     * @return 结果
     */
    public int insertTbHouse(TbHouse tbHouse);

    /**
     * 修改房屋信息
     * 
     * @param tbHouse 房屋信息
     * @return 结果
     */
    public int updateTbHouse(TbHouse tbHouse);

    /**
     * 删除房屋信息
     * 
     * @param id 房屋信息主键
     * @return 结果
     */
    public int deleteTbHouseById(Long id);
}
