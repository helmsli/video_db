package com.company.videodb.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.userOrderPlatform.domain.QueryPageRequest;
import com.company.videodb.Const.VideodbConst;
import com.company.videodb.domain.CourseClass;
import com.company.videodb.domain.Courses;
import com.company.videodb.mapper.CourseClassMapper;
import com.company.videodb.mapper.CoursesMapper;
import com.company.videodb.service.CoursesManagerService;
import com.google.gson.reflect.TypeToken;
import com.xinwei.nnl.common.domain.JsonRequest;
import com.xinwei.nnl.common.domain.ProcessResult;
import com.xinwei.nnl.common.util.JsonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@Api("HelloController 接口")
@RestController
@RequestMapping("/vodManagerDb")
public class VodManagerController {
	@Resource(name="coursesManagerService")
	private CoursesManagerService coursesManagerService;
	@Autowired
	private CoursesMapper coursesMapper;
	@Autowired
	private CourseClassMapper courseClassMapper;
	/**
	 * 配置运行库中的数据
	 * @param courseId
	 * @param userId
	 * @param courses
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,value = "{dbid}/{courseId}/confCourses")
	public  ProcessResult configureCourses(@PathVariable String dbid,@PathVariable String courseId,@RequestBody Courses courses) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			
			processResult= coursesManagerService.configureCourses(courses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!StringUtils.isEmpty(e.getMessage()))
			{
				processResult.setRetMsg(e.getMessage().substring(0,128));
			}
		}
		return processResult;
	}
	/**
	 * 老师删除线上运营库和发布库的内容，如果还没有发布就删发布库的内容
	 * @param courseId
	 * @param userId
	 * @param courses
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,value = "{dbid}/{courseId}/delCourses")
	public  ProcessResult deleteCourses(@PathVariable String dbid,@PathVariable String courseId,@RequestBody Courses courses) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			processResult= coursesManagerService.deleteCourse(courses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!StringUtils.isEmpty(e.getMessage()))
			{
				processResult.setRetMsg(e.getMessage().substring(0,128));
			}
		}
		return processResult;
	}
	
	
	
	/**
	 * 老师配置课程的课时
	 * @param courseId
	 * @param userId
	 * @param courseClass
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,value = "{dbid}/{courseId}/confClass")
	public  ProcessResult configureClass(@PathVariable String dbid,@PathVariable String courseId,@RequestBody JsonRequest JsonRequest) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			List<CourseClass> courseClassList =JsonUtil.fromJson(JsonRequest.getJsonString(), new TypeToken<List<CourseClass>>() {}.getType());
			processResult= coursesManagerService.configureClass(courseClassList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!StringUtils.isEmpty(e.getMessage()))
			{
				processResult.setRetMsg(e.getMessage().substring(0,128));
			}
		}
		return processResult;
	}
	/**
	 * 老师删除课时
	 * @param courseId
	 * @param userId
	 * @param courseClass
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,value = "{dbid}/{courseId}/delClass")
	public  ProcessResult delClass(@PathVariable String dbid,@PathVariable String courseId,@RequestBody JsonRequest JsonRequest) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			List<CourseClass> courseClassList =JsonUtil.fromJson(JsonRequest.getJsonString(), new TypeToken<List<CourseClass>>() {}.getType());
			
			processResult= coursesManagerService.deleteClass(courseClassList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!StringUtils.isEmpty(e.getMessage()))
			{
				processResult.setRetMsg(e.getMessage().substring(0,128));
			}
		}
		return processResult;
	}
    
	@RequestMapping(method = RequestMethod.GET,value = "{dbid}/{courseId}/getCourse")
	public  ProcessResult getCourse(@PathVariable String dbid,@PathVariable String courseId) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
		//	List<CourseClass> courseClassList =JsonUtil.fromJson(JsonRequest.getJsonString(), new TypeToken<List<CourseClass>>() {}.getType());
			String partitionId = Courses.changePrititionId(courseId);
			processResult= coursesManagerService.queryCourses(partitionId, courseId);
			toJsonProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!StringUtils.isEmpty(e.getMessage()))
			{
				processResult.setRetMsg(e.getMessage().substring(0,128));
			}
		}
		return processResult;
	}
	
	@ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
	@ApiImplicitParam(name = "queryPageRequest", value = "用户ID", required = true, dataType = "QueryPageRequest")
	@RequestMapping(method = RequestMethod.POST,value = "/getAllCourse")
	public  ProcessResult getAllCourse(@RequestBody QueryPageRequest queryPageRequest) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
		//	List<CourseClass> courseClassList =JsonUtil.fromJson(JsonRequest.getJsonString(), new TypeToken<List<CourseClass>>() {}.getType());
			processResult= coursesManagerService.queryAllCourses(queryPageRequest);
			toJsonProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!StringUtils.isEmpty(e.getMessage()))
			{
				processResult.setRetMsg(e.getMessage().substring(0,128));
			}
		}
		return processResult;
	}
	@RequestMapping(method = RequestMethod.GET,value = "{dbid}/{courseId}/getClass")
	public  ProcessResult getCourseClass(@PathVariable String dbid,@PathVariable String courseId) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			String partitionId = Courses.changePrititionId(courseId);
			processResult= coursesManagerService.queryClass(partitionId, courseId);
			toJsonProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!StringUtils.isEmpty(e.getMessage()))
			{
				processResult.setRetMsg(e.getMessage().substring(0,128));
			}
		}
		return processResult;
	}
	@RequestMapping(method = RequestMethod.GET,value = "{dbid}/{courseId}/{classId}getOneClass")
	public  ProcessResult getOneClass(@PathVariable String dbid,@PathVariable String courseId,@PathVariable String classId) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			
			CourseClass courseClass= courseClassMapper.selectByClassid(Courses.changePrititionId(courseId), courseId, classId);
			if(courseClass!=null)
			{
				processResult.setResponseInfo(courseClass);
				processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
			}
			toJsonProcessResult(processResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!StringUtils.isEmpty(e.getMessage()))
			{
				processResult.setRetMsg(e.getMessage().substring(0,128));
			}
		}
		return processResult;
	}

	protected void toJsonProcessResult(ProcessResult processResult) {
		if (processResult.getRetCode() == 0) {

			Object object = processResult.getResponseInfo();
			if (object != null) {
				processResult.setResponseInfo(JsonUtil.toJson(object));
			}
		}
	}
} 
