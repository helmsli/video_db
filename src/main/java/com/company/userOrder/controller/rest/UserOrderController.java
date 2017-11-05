package com.company.userOrder.controller.rest;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.userOrder.domain.QueryUserOrderRequest;
import com.company.userOrder.domain.UserOrder;
import com.company.userOrder.service.UserOrderDbService;
import com.company.videodb.Const.VideodbConst;
import com.company.videodb.domain.Courses;
import com.github.pagehelper.PageInfo;
import com.xinwei.nnl.common.domain.ProcessResult;
import com.xinwei.nnl.common.util.JsonUtil;

@RestController
@RequestMapping("/userOrderDb")
public class UserOrderController {

	@Resource(name = "userOrderDbService")
	private UserOrderDbService userOrderDbService;

	/**
	 * 从数据库查询用户一段时间内所有状态的订单
	 * 
	 * @param category
	 * @param userid
	 * @param queryUserOrderRequest
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "{category}/{userid}/queryUserOrder")
	public ProcessResult queryUserAllOrder(@PathVariable String category, @PathVariable String userid,
			@RequestBody QueryUserOrderRequest queryUserOrderRequest) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			processResult = userOrderDbService.selOrdersByUser(queryUserOrderRequest);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}

	/**
	 * 按照状态从数据库查询用户一段时间内的订单
	 * 
	 * @param category
	 * @param userid
	 * @param queryUserOrderRequest
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "{category}/{userid}/queryUserOrderByStatus")
	public ProcessResult queryUserOrderByStatus(@PathVariable String category, @PathVariable String userid,
			@RequestBody QueryUserOrderRequest queryUserOrderRequest) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			processResult = userOrderDbService.selOrdersByUser(queryUserOrderRequest);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}

	/**
	 * 配置用户订单，没有插入，有更新
	 * 
	 * @param category
	 * @param userid
	 * @param userOrder
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "{category}/{userid}/configUserOrder")
	public ProcessResult configUserOrder(@PathVariable String category, @PathVariable String userid,
			@RequestBody UserOrder userOrder) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			processResult = userOrderDbService.configureUserOrder(userOrder);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}

	/**
	 * 更新用户订单状态
	 * 
	 * @param category
	 * @param userid
	 * @param userOrder
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "{category}/{userid}/updateUserOrderStatus")
	public ProcessResult updateUserOrderStatus(@PathVariable String category, @PathVariable String userid,
			@RequestBody UserOrder userOrder) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			processResult = userOrderDbService.updateUserOrderStatus(userOrder);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}

	/**
	 * 删除用户订单
	 * 
	 * @param category
	 * @param userid
	 * @param userOrder
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "{category}/{userid}/delUserOrder")
	public ProcessResult delUserOrder(@PathVariable String category, @PathVariable String userid,
			@RequestBody UserOrder userOrder) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			processResult = userOrderDbService.delUserOrder(userOrder);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}

	protected void toJsonSimpleProcessResult(ProcessResult processResult) {
		Object object = processResult.getResponseInfo();
		if (object != null) {
			String jsonStr = JsonUtil.toJson(object);
			processResult.setResponseInfo(jsonStr);
		}
	}
}
