package com.company.videodb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;


import com.company.userOrder.domain.QueryUserOrderRequest;
import com.company.userOrder.domain.UserOrder;
import com.company.userOrderPlatform.domain.QueryPageRequest;
import com.company.videodb.domain.Courses;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xinwei.nnl.common.domain.JsonRequest;
import com.xinwei.nnl.common.domain.ProcessResult;
import com.xinwei.nnl.common.util.JsonUtil;

import net.minidev.json.parser.JSONParser;


public class TestQuery {
	private RestTemplate restTemplate = new RestTemplate();
	private String category = "tcoursepub";
	public static void main(String[] args) {
		
		UserOrder dbUserOrder = new UserOrder();
		dbUserOrder.setOrderData("aaaa");
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.setSerializationInclusion(Include.NON_NULL);
	    mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
	    mapper.configure(MapperFeature.AUTO_DETECT_FIELDS, true);
	    // Jackson2ObjectMapperFactoryBean
		//mapper.configure(JsonParse., state)
	       try {
			String json = mapper.writeValueAsString(dbUserOrder);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		TestQuery testQuery = new TestQuery();
		testQuery.getUserOrder();
		testQuery.getCourse("10001030001");
		testQuery.getAllClass("10001030001");;
		testQuery.getAllCourse();
	}
	
	public void getUserOrder()
	{
		// TODO Auto-generated method stub
		String baseUrl = "http://huaxiahuizhi.cn:8080/userOrderDb";
		QueryUserOrderRequest jsonRequest =new QueryUserOrderRequest();
		jsonRequest.setCategory(category);
		UserOrder UserOrder = new UserOrder();
		jsonRequest.setEndCreateTime(UserOrder.getConstCreateDate());
		jsonRequest.setStartCreateTime(UserOrder.getConstCreateDate());
		jsonRequest.setUserId("110003007");
		jsonRequest.setPageNum(1);
		jsonRequest.setPageSize(100);
		
		ProcessResult processResult = restTemplate.postForObject(
				baseUrl + "/" + category + "/" + "1234567890" + "/"  +    "/queryUserOrder",
				jsonRequest,ProcessResult.class);
		System.out.println(processResult);
		
	}
	//15001040001
	public void getCourse(String courseId)
	{
		// TODO Auto-generated method stub
		String baseUrl = "http://huaxiahuizhi.cn:8080/studentCourse";
		ProcessResult processResult = restTemplate.getForObject(
				baseUrl + "/" + courseId  +  "/queryCourse" ,
				ProcessResult.class);
		System.out.println("course:" + processResult);
		
		baseUrl = "http://huaxiahuizhi.cn:8080/vodManagerDb";
		
		String dbid = Courses.getDbId(courseId);
		 processResult = restTemplate.getForObject(
				baseUrl + "/" + dbid + "/" + courseId  +  "/getCourse" ,
				ProcessResult.class);
		System.out.println("courseDB:" + processResult);
       
		
		
	}
	

	public void getAllClass(String courseId)
	{
		// TODO Auto-generated method stub
		String baseUrl = "http://huaxiahuizhi.cn:8080/studentCourse";
		ProcessResult processResult = restTemplate.getForObject(
				baseUrl + "/" + courseId  +  "/queryAllClass" ,
				ProcessResult.class);
		System.out.println(processResult);

	}
	public void getAllCourse()
	{
		///{category}/{dbId}/{orderId}/startOrder
		String baseUrl = "http://huaxiahuizhi.cn:8080/vodManagerDb";
		QueryPageRequest queryPageRequest = new QueryPageRequest();
		queryPageRequest.setPageNum(1);
		queryPageRequest.setPageSize(100);
		ProcessResult processResult = restTemplate.postForObject(
				baseUrl  + "/getAllCourse",queryPageRequest,
				ProcessResult.class);
		System.out.println("allcourse:" + processResult);
	}
	// 15001040001
}
