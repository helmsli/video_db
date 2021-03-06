package com.company.userOrder.service;

import java.util.Date;
import java.util.List;

import com.company.userOrder.domain.UserOrder;
import com.company.userOrder.domain.QueryUserOrderRequest;

import com.xinwei.nnl.common.domain.ProcessResult;

public interface UserOrderDbService {
	
	/**
	 * 按照用户查询所有用户
	 * @param queryUserOrderRequest
	 * @return
	 */
	public ProcessResult selOrdersByUser(QueryUserOrderRequest queryUserOrderRequest);
	
	
	/**
	 * 按照用户查询所有用户
	 * @param queryUserOrderRequest
	 * @return
	 */
	public ProcessResult selOrdersByUserSortByOrderId(QueryUserOrderRequest queryUserOrderRequest);
	
	/**
	 * 按照userid,orderId查询订单信息
	 * @param queryUserOrderRequest
	 * @return
	 */
	public ProcessResult selByUserOrderId(UserOrder userOrder);
	
	
	/**
	 * 按照用户的状态查询订单信息
	 * @param queryUserOrderRequest
	 * @return
	 */
	public ProcessResult selOrderByUserStatus(QueryUserOrderRequest queryUserOrderRequest);
	/**
	 * 
	 * @param userOrder
	 * @return
	 */
	public ProcessResult configureUserOrder(UserOrder userOrder);

	
	/**
	 * 增加用户订单的amount
	 * @param userOrder
	 * @return
	 */
	public ProcessResult plusUserAmount(UserOrder userOrder);

	/**
	 * 
	 * @param userOrder
	 * @return
	 */
	public ProcessResult delUserOrder(UserOrder userOrder);

	/**
	 * 
	 * @param userOrder
	 * @return
	 */
	public ProcessResult updateUserOrderStatus(UserOrder userOrder);
}
