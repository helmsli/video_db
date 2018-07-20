package com.company.userOrder.controller.rest;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.company.userOrder.domain.QueryUserOrderRequest;
import com.company.userOrder.domain.UserOrder;
import com.company.userOrder.service.UserOrderDbService;
import com.company.userOrderPlatform.domain.UserOrderConst;
import com.xinwei.nnl.common.domain.ProcessResult;
import com.xinwei.nnl.common.util.JsonUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

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
	@ApiOperation(value="查询用户某个类型所有的订单", notes="根据订单类型和用户ID查询所有订单")
    @ApiImplicitParam(name = "queryUserOrderRequest", value = "用户详细实体user", required = true, dataType = "QueryUserOrderRequest")
	@RequestMapping(method = RequestMethod.POST, value = "{category}/{userid}/queryUserOrder")
	public ProcessResult queryUserAllOrder(@PathVariable String category, @PathVariable String userid,
			@RequestBody QueryUserOrderRequest queryUserOrderRequest) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		try {
			queryUserOrderRequest.setCategory(category);
			if(queryUserOrderRequest.getStatus()==QueryUserOrderRequest.STATUS_NULL)
			{
				processResult = userOrderDbService.selOrdersByUser(queryUserOrderRequest);
			}
			else
			{
				processResult = userOrderDbService.selOrderByUserStatus(queryUserOrderRequest);
					
			}
			
			//toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ControllerUtils.getFromResponse(e, UserOrderConst.RESULT_FAILURE, null);
			
		}
		return processResult;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "{category}/{userid}/queryUserOrderConst")
	public ProcessResult queryUserAllOrderConst(@PathVariable String category, @PathVariable String userid,
			@RequestBody QueryUserOrderRequest queryUserOrderRequest) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		try {
			queryUserOrderRequest.setCategory(category);
			UserOrder userOrder = new UserOrder();
			queryUserOrderRequest.setStartCreateTime(userOrder.getConstCreateDate());
			Calendar end = Calendar.getInstance();
			end.setTime(userOrder.getConstCreateDate());
			end.add(Calendar.SECOND, 1);
			queryUserOrderRequest.setEndCreateTime(end.getTime());
			if(queryUserOrderRequest.getStatus()==QueryUserOrderRequest.STATUS_NULL)
			{
				processResult = userOrderDbService.selOrdersByUser(queryUserOrderRequest);
			}
			else
			{
				processResult = userOrderDbService.selOrderByUserStatus(queryUserOrderRequest);
					
			}
			
			//toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ControllerUtils.getFromResponse(e, UserOrderConst.RESULT_FAILURE, null);
			
		}
		return processResult;
	}
	/**
	 * 按照orderId排序
	 * @param category
	 * @param userid
	 * @param queryUserOrderRequest
	 * @return
	 */
	@PostMapping(value = "{category}/{userid}/queryOrderSortByOrderId")
	public ProcessResult queryUserAllOrderSortByOrderId(@PathVariable String category, @PathVariable String userid,
			@RequestBody QueryUserOrderRequest queryUserOrderRequest) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		try {
			queryUserOrderRequest.setCategory(category);
			
			processResult = userOrderDbService.selOrdersByUserSortByOrderId(queryUserOrderRequest);
			
			
			//toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ControllerUtils.getFromResponse(e, UserOrderConst.RESULT_FAILURE, null);
			
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
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		try {
			queryUserOrderRequest.setCategory(category);
			processResult = userOrderDbService.selOrderByUserStatus(queryUserOrderRequest);
			//toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ControllerUtils.getFromResponse(e, UserOrderConst.RESULT_FAILURE, null);
			
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
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		try {			
			processResult = userOrderDbService.configureUserOrder(userOrder);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ControllerUtils.getFromResponse(e, UserOrderConst.RESULT_FAILURE, null);
			
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
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		try {
			processResult = userOrderDbService.updateUserOrderStatus(userOrder);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ControllerUtils.getFromResponse(e, UserOrderConst.RESULT_FAILURE, null);
			
		}
		return processResult;
	}

	/**
	 * 用于将用户的状态+1
	 * @param category
	 * @param userid
	 * @param userOrder
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "{category}/{userid}/plusUserStatus")
	public ProcessResult plusUserOrderStatus(@PathVariable String category, @PathVariable String userid,
			@RequestBody UserOrder userOrder) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		try {
			processResult = userOrderDbService.plusUserAmount(userOrder);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ControllerUtils.getFromResponse(e, UserOrderConst.RESULT_FAILURE, null);
			
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
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		try {
			processResult = userOrderDbService.delUserOrder(userOrder);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ControllerUtils.getFromResponse(e, UserOrderConst.RESULT_FAILURE, null);
			
		}
		return processResult;
	}

	@RequestMapping(method = RequestMethod.POST, value = "{category}/{userid}/queryOneOrder")
	public ProcessResult queryOneUserOrder(@PathVariable String category, @PathVariable String userid,
			@RequestBody UserOrder userOrder) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(UserOrderConst.RESULT_FAILURE);
		try {
			processResult = userOrderDbService.selByUserOrderId(userOrder);
			toJsonSimpleProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ControllerUtils.getFromResponse(e, UserOrderConst.RESULT_FAILURE, null);
			
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
