package com.company.userOrder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dbplatform.domain.UserOrderConst;
import com.company.userOrder.domain.QueryUserOrderRequest;
import com.company.userOrder.domain.UserOrder;
import com.company.userOrder.mapper.UserOrderMapper;
import com.company.userOrder.service.UserOrderDbService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinwei.nnl.common.domain.ProcessResult;

@Service("userOrderDbService")
public class UserOrderDbServiceImpl implements UserOrderDbService {
	@Autowired
	private UserOrderMapper userOrderMapper;

	protected ProcessResult getDefaultErrorResult() {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		return processResult;
	}

	@Override
	public ProcessResult selOrdersByUser(QueryUserOrderRequest queryUserOrderRequest) {
		// TODO Auto-generated method stub
		ProcessResult processResult = getDefaultErrorResult();

		PageHelper.startPage(queryUserOrderRequest.getPageNum(), queryUserOrderRequest.getPageSize());
		List<UserOrder> list = userOrderMapper.selOrdersByUser(queryUserOrderRequest.getStartCreateTime(),
				queryUserOrderRequest.getEndCreateTime(), queryUserOrderRequest.getUserid());
		PageInfo pageInfo = new PageInfo(list);
		processResult.setResponseInfo(pageInfo);
		processResult.setRetCode(UserOrderConst.RESULT_SUCCESS);
		// Page page = (Page) list;
		// return "PageInfo: " + JSON.toJSONString(pageInfo) + ", Page: " +
		// JSON.toJSONString(page);
		return processResult;
	}

	@Override
	public ProcessResult selOrderByUserStatus(QueryUserOrderRequest queryUserOrderRequest) {
		// TODO Auto-generated method stub
		ProcessResult processResult = getDefaultErrorResult();

		PageHelper.startPage(queryUserOrderRequest.getPageNum(), queryUserOrderRequest.getPageSize());
		List<UserOrder> list = userOrderMapper.selOrderByUserStatus(queryUserOrderRequest.getStartCreateTime(),
				queryUserOrderRequest.getEndCreateTime(), queryUserOrderRequest.getUserid(),
				queryUserOrderRequest.getStatus());
		PageInfo pageInfo = new PageInfo(list);
		// Page page = (Page) list;
		// return "PageInfo: " + JSON.toJSONString(pageInfo) + ", Page: " +
		// JSON.toJSONString(page);
		processResult.setResponseInfo(pageInfo);
		processResult.setRetCode(UserOrderConst.RESULT_SUCCESS);
		return processResult;
	}

	@Override
	public ProcessResult configureUserOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		ProcessResult processResult = getDefaultErrorResult();

		UserOrder queryUserOrder = userOrderMapper.selectUserOrderById(userOrder);
		if(queryUserOrder!=null)
		{
			int updateNumbers = userOrderMapper.updateUserOrder(userOrder);
			if(updateNumbers==1)
			{
				processResult.setRetCode(UserOrderConst.RESULT_SUCCESS);
			}
		}
		else
		{
			userOrderMapper.insertUserOrder(userOrder);
			processResult.setRetCode(UserOrderConst.RESULT_SUCCESS);
		}
				
		return processResult;
	}

	@Override
	public ProcessResult delUserOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		ProcessResult processResult = getDefaultErrorResult();
		userOrderMapper.delUserOrder(userOrder);
		processResult.setRetCode(UserOrderConst.RESULT_SUCCESS);
		return processResult;
	}

	@Override
	public ProcessResult updateUserOrderStatus(UserOrder userOrder) {
		// TODO Auto-generated method stub
		ProcessResult processResult = getDefaultErrorResult();
		int updateNumbers = userOrderMapper.updateUserOrderStatus(userOrder);
		if(updateNumbers==1)
		{
			processResult.setRetCode(UserOrderConst.RESULT_SUCCESS);
		}
		return processResult;
	
	}

}