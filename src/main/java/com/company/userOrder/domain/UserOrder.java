package com.company.userOrder.domain;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * Model class of userOrder.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class UserOrder implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private transient byte[] orderDataByte;
	 private  transient final String DEFAULT_CHARSET = "utf-8";
	

	/** 创建时间. */
	private Date createTime;

	/** 用户ID. */
	private String userId;

	/** 订单ID. */
	private String orderId;

	/** 订单类型. */
	private String category;

	/** 订单状态. */
	private int status;

	private Date updateTime;

	private String orderDataType;
	/** 订单数据. */
	private String orderData;

	public UserOrder() {
		this.setCreateTime(Calendar.getInstance().getTime());
		this.setUpdateTime(Calendar.getInstance().getTime());
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setConstCreateTime() {
		Date date = getConstCreateDate();
		this.createTime = date;
	}

	public void setCreateTime(Date createTime) {

		this.createTime = formatDate(createTime);

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOrderData() {
		return orderData;
	}

	public void setOrderData(String orderData) {
		this.orderData = orderData;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = formatDate(updateTime);
	}

	public String getOrderDataType() {
		return orderDataType;
	}

	public void setOrderDataType(String orderDataType) {
		this.orderDataType = orderDataType;
	}

	protected Date formatDate(Date sourceDate) {
		if (sourceDate != null) {
			Calendar calenCreate = Calendar.getInstance();
			calenCreate.setTime(sourceDate);
			calenCreate.set(Calendar.MILLISECOND, 0);
			return calenCreate.getTime();
		}
		return sourceDate;
	}

	/**
	 * 构造一个初始时间
	 * @return
	 */
	public Date getConstCreateDate() {
		Calendar calenCreate = Calendar.getInstance();
		calenCreate.set(2017, 11, 30, 0, 0, 0);
		calenCreate.set(Calendar.MILLISECOND, 0);
		return calenCreate.getTime();

	
	}
	public  byte[] getOrderDataByte() {
		try {
			if(!StringUtils.isEmpty(this.getOrderData()))
			{
				return getOrderData().getBytes(DEFAULT_CHARSET);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
				
	}

	public void setOrderDataByte(byte[] orderDataByte) {
		//this.orderDataByte = orderDataByte;
		try {
			if(orderDataByte!=null)
			{
				this.setOrderData(new String(orderDataByte, DEFAULT_CHARSET));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public String toString() {
		return "UserOrder [createTime=" + createTime + ", userId=" + userId + ", orderId=" + orderId + ", category="
				+ category + ", status=" + status + ", updateTime=" + updateTime + ", orderDataType=" + orderDataType
				+ ", orderData=" + orderData + "]";
	}

}
