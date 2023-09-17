package com.house.springboot.bean;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单信息对象 tb_order
 * 
 * @date 2023-03-20
 */
public class TbOrder
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 房屋ID */
    private Long houseId;

    // 房屋名称
    private String houseName;

    /** 用户ID */
    private Long userId;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    /** 用户姓名 */
    private String username;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHouseId(Long houseId) 
    {
        this.houseId = houseId;
    }

    public Long getHouseId() 
    {
        return houseId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
}
