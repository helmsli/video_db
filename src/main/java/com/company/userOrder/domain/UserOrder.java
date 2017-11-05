package com.company.userOrder.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Model class of userOrder.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class UserOrder implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

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

	/** 订单数据. */
	private String orderData;

	public UserOrder() {
		this.setCreateTime(Calendar.getInstance().getTime());
		this.setUpdateTime(Calendar.getInstance().getTime());
	}

	public Date getCreateTime() {
		return createTime;
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

	protected Date formatDate(Date sourceDate) {
		if (sourceDate != null) {
			Calendar calenCreate = Calendar.getInstance();
			calenCreate.setTime(sourceDate);
			calenCreate.set(Calendar.MILLISECOND, 0);
			return calenCreate.getTime();
		}
		return sourceDate;
	}

	@Override
	public String toString() {
		return "UserOrder [createTime=" + createTime + ", userId=" + userId + ", orderId=" + orderId + ", category="
				+ category + ", status=" + status + ", orderData=" + orderData + "]";
	}

}