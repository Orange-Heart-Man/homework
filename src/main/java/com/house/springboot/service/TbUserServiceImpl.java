package com.house.springboot.service;

import java.util.List;

import com.house.springboot.bean.TbUser;
import com.house.springboot.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息Service业务层处理
 * 
 * @date 2023-03-20
 */
@Service
public class TbUserServiceImpl
{
    @Autowired
    private TbUserMapper tbUserMapper;

    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    public TbUser selectTbUserById(Long id)
    {
        return tbUserMapper.selectTbUserById(id);
    }

    /**
     * 查询用户信息列表
     * 
     * @param tbUser 用户信息
     * @return 用户信息
     */
    public List<TbUser> selectTbUserList(TbUser tbUser)
    {
        return tbUserMapper.selectTbUserList(tbUser);
    }

    /**
     * 新增用户信息
     * 
     * @param tbUser 用户信息
     * @return 结果
     */
    public int insertTbUser(TbUser tbUser)
    {
        return tbUserMapper.insertTbUser(tbUser);
    }

    /**
     * 修改用户信息
     * 
     * @param tbUser 用户信息
     * @return 结果
     */
    public int updateTbUser(TbUser tbUser)
    {
        return tbUserMapper.updateTbUser(tbUser);
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    public int deleteTbUserById(Long id)
    {
        return tbUserMapper.deleteTbUserById(id);
    }
}
