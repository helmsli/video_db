package com.company.userOrder.domain;

import java.util.Calendar;
import java.util.Date;

import com.company.dbplatform.domain.QueryPageRequest;

public class QueryUserOrderRequest extends QueryPageRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1578752993197351755L;
	private Date startCreateTime;
	private Date endCreateTime;
	private String userid;
	private int status;
	public Date getStartCreateTime() {
		return startCreateTime;
	}
	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = formatDate(startCreateTime);
		
	}
	public Date getEndCreateTime() {
		return endCreateTime;
	}
	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = formatDate(endCreateTime);
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	protected Date formatDate(Date sourceDate)
	{
		if(sourceDate!=null)
		{
			Calendar calenCreate = Calendar.getInstance();
			calenCreate.setTime(sourceDate);
			calenCreate.set(Calendar.MILLISECOND,0);
			return calenCreate.getTime();
		}
		return sourceDate;
	}
}
