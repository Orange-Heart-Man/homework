package com.house.springboot.service;

import java.util.List;

import com.house.springboot.mapper.AdminMapper;
import com.house.springboot.bean.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息Service业务层处理
 * 
 * @date 2023-03-20
 */
@Service
public class AdminServiceImpl
{
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    public Admin selectAdminById(Long id)
    {
        return adminMapper.selectAdminById(id);
    }

    /**
     * 查询用户信息列表
     * 
     * @param admin 用户信息
     * @return 用户信息
     */
    public List<Admin> selectAdminList(Admin admin)
    {
        return adminMapper.selectAdminList(admin);
    }

    /**
     * 新增用户信息
     * 
     * @param admin 用户信息
     * @return 结果
     */
    public int insertAdmin(Admin admin)
    {
        return adminMapper.insertAdmin(admin);
    }

    /**
     * 修改用户信息
     * 
     * @param admin 用户信息
     * @return 结果
     */
    public int updateAdmin(Admin admin)
    {
        return adminMapper.updateAdmin(admin);
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    public int deleteAdminById(Long id)
    {
        return adminMapper.deleteAdminById(id);
    }
}
