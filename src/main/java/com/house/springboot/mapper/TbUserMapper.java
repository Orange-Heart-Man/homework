package com.house.springboot.mapper;

import com.house.springboot.bean.TbUser;

import java.util.List;

/**
 * 用户信息Mapper接口
 * 
 * @date 2023-03-20
 */
public interface TbUserMapper 
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    public TbUser selectTbUserById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param tbUser 用户信息
     * @return 用户信息集合
     */
    public List<TbUser> selectTbUserList(TbUser tbUser);

    /**
     * 新增用户信息
     * 
     * @param tbUser 用户信息
     * @return 结果
     */
    public int insertTbUser(TbUser tbUser);

    /**
     * 修改用户信息
     * 
     * @param tbUser 用户信息
     * @return 结果
     */
    public int updateTbUser(TbUser tbUser);

    /**
     * 删除用户信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    public int deleteTbUserById(Long id);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbUserByIds(String[] ids);
}
