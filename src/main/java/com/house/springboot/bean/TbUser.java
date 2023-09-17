package com.house.springboot.bean;

/**
 * 用户信息对象 tb_user
 * 
 * @date 2023-03-20
 */
public class TbUser
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 姓名 */
    private String username;

    /** 密码 */
    private String password;

    /** 手机号 */
    private String phone;

    // 租赁房屋数量
    private int housenum;

    // 旧密码
    private String oldpassword;

    // 新密码
    private String newpassword;

    // 角色
    private String role;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public int getHousenum() {
        return housenum;
    }

    public void setHousenum(int housenum) {
        this.housenum = housenum;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
