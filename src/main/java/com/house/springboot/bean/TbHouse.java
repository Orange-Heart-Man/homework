package com.house.springboot.bean;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 房屋信息对象 tb_house
 * 
 * @date 2023-03-20
 */
public class TbHouse
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 房屋描述 */
    private String houseDesc;

    /** 分类ID */
    private Long categoryId;

    // 分类名称
    private String categoryName;

    /** 房屋面积 */
    private int houseArea;

    private int houseAreaStart;

    private int houseAreaEnd;

    /** 房屋楼层 */
    private String houseFloor;

    /** 房屋类型 */
    private String houseType;

    /** 房屋价格 */
    private int housePrice;

    private int housePriceStart;

    private int housePriceEnd;

    /** 房屋地址 */
    private String houseAddress;

    /** 房屋小区 */
    private String housePlot;

    /**
     * 房屋封面
     */
    private String poster;

    /** 联系电话 */
    private String houseTel;

    /** 发布者ID */
    private Long publisherId;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date publisherTime;

    private String longitude;

    private String latitude;

    // 是否被预定（1：已预定  0：未预定）
    private int isBook;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHouseDesc(String houseDesc) 
    {
        this.houseDesc = houseDesc;
    }

    public String getHouseDesc() 
    {
        return houseDesc;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setHouseArea(int houseArea)
    {
        this.houseArea = houseArea;
    }

    public int getHouseArea()
    {
        return houseArea;
    }
    public void setHouseFloor(String houseFloor) 
    {
        this.houseFloor = houseFloor;
    }

    public String getHouseFloor() 
    {
        return houseFloor;
    }
    public void setHouseType(String houseType) 
    {
        this.houseType = houseType;
    }

    public String getHouseType() 
    {
        return houseType;
    }
    public void setHousePrice(int housePrice)
    {
        this.housePrice = housePrice;
    }

    public int getHousePrice()
    {
        return housePrice;
    }
    public void setHouseAddress(String houseAddress) 
    {
        this.houseAddress = houseAddress;
    }

    public String getHouseAddress() 
    {
        return houseAddress;
    }
    public void setHousePlot(String housePlot) 
    {
        this.housePlot = housePlot;
    }

    public String getHousePlot() 
    {
        return housePlot;
    }
    public void setHouseTel(String houseTel) 
    {
        this.houseTel = houseTel;
    }

    public String getHouseTel() 
    {
        return houseTel;
    }
    public void setPublisherId(Long publisherId) 
    {
        this.publisherId = publisherId;
    }

    public Long getPublisherId() 
    {
        return publisherId;
    }
    public void setPublisherTime(Date publisherTime) 
    {
        this.publisherTime = publisherTime;
    }

    public Date getPublisherTime() 
    {
        return publisherTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getIsBook() {
        return isBook;
    }

    public void setIsBook(int isBook) {
        this.isBook = isBook;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getHouseAreaStart() {
        return houseAreaStart;
    }

    public void setHouseAreaStart(int houseAreaStart) {
        this.houseAreaStart = houseAreaStart;
    }

    public int getHouseAreaEnd() {
        return houseAreaEnd;
    }

    public void setHouseAreaEnd(int houseAreaEnd) {
        this.houseAreaEnd = houseAreaEnd;
    }

    public int getHousePriceStart() {
        return housePriceStart;
    }

    public void setHousePriceStart(int housePriceStart) {
        this.housePriceStart = housePriceStart;
    }

    public int getHousePriceEnd() {
        return housePriceEnd;
    }

    public void setHousePriceEnd(int housePriceEnd) {
        this.housePriceEnd = housePriceEnd;
    }
}
