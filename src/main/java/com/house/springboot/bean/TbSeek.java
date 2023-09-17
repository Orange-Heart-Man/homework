package com.house.springboot.bean;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 求租信息对象 tb_seek
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
public class TbSeek
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 用户名 */
    private String userName;

    /** 手机号 */
    private String phone;

    /** 要求 */
    private String require;

    /** 价格区间 */
    private String price;

    /** 提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date submitdate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setRequire(String require) 
    {
        this.require = require;
    }

    public String getRequire() 
    {
        return require;
    }
    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getPrice() 
    {
        return price;
    }
    public void setSubmitdate(Date submitdate) 
    {
        this.submitdate = submitdate;
    }

    public Date getSubmitdate() 
    {
        return submitdate;
    }

}
