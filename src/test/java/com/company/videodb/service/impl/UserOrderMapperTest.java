package com.company.videodb.service.impl;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.userOrder.domain.UserOrder;
import com.company.userOrder.mapper.UserOrderMapper;
import com.xinwei.nnl.common.util.JsonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserOrderMapperTest {
	@Autowired
	private UserOrderMapper userOrderMapper;
	@Test
	public void test() {
		UserOrder userOrder = new UserOrder();
		userOrder.setCategory("123");
		userOrder.setCreateTime(Calendar.getInstance().getTime());
		userOrder.setOrderData("aaa");
		userOrder.setOrderId("");
		userOrder.setStatus(0);
		userOrder.setUpdateTime(Calendar.getInstance().getTime());
		userOrder.setUserId("111");
		System.out.println(userOrder.toString());
		userOrderMapper.selectUserOrderById(userOrder);
		userOrderMapper.selectCountById(userOrder);
		userOrderMapper.insertUserOrder(userOrder);
	}

}
