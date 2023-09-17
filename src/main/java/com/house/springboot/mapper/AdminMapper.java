package com.house.springboot.mapper;

import com.house.springboot.bean.Admin;

import java.util.List;

/**
 * 用户信息Mapper接口
 * 
 * @date 2023-03-20
 */
public interface AdminMapper 
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    public Admin selectAdminById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param admin 用户信息
     * @return 用户信息集合
     */
    public List<Admin> selectAdminList(Admin admin);

    /**
     * 新增用户信息
     * 
     * @param admin 用户信息
     * @return 结果
     */
    public int insertAdmin(Admin admin);

    /**
     * 修改用户信息
     * 
     * @param admin 用户信息
     * @return 结果
     */
    public int updateAdmin(Admin admin);

    /**
     * 删除用户信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    public int deleteAdminById(Long id);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdminByIds(String[] ids);
}
