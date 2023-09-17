package com.house.springboot.bean;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 建议信息对象 tb_liuyan
 * 
 * @date 2023-03-20
 */
public class TbLiuyan
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户ID */
    private Long userid;

    /** 类型 */
    private String type;

    /** 建议内容 */
    private String comment;

    /** 创建时间 */
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
    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
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
