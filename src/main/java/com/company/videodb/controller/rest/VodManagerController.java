package com.company.videodb.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.videodb.Const.VideodbConst;
import com.company.videodb.domain.CourseClass;
import com.company.videodb.domain.Courses;
import com.company.videodb.service.CoursesManagerService;
import com.xinwei.nnl.common.domain.ProcessResult;

@RestController
@RequestMapping("/vodManagerDb")
public class VodManagerController {
	@Resource(name="coursesManagerService")
	private CoursesManagerService coursesManagerService;
	/**
	 * 老师发布视频到发布库，不是线上运营库
	 * @param courseId
	 * @param userId
	 * @param courses
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,value = "{userId}/{courseId}/confCourses")
	public  ProcessResult configureCourses(@PathVariable String courseId,@PathVariable long userId,@RequestBody Courses courses) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			
			processResult= coursesManagerService.configureCourses(userId,courses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	@RequestMapping(method = RequestMethod.POST,value = "{userId}/{courseId}/delCourses")
	public  ProcessResult deleteCourses(@PathVariable String courseId,@PathVariable long userId,@RequestBody Courses courses) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			processResult= coursesManagerService.deleteCourse(userId, courses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}
	/**
	 * 老师发布课程到线上运营库
	 * @param courseId
	 * @param userId
	 * @param courses
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,value = "{userId}/{courseId}/publishCourses")
	public  ProcessResult publishCourses(@PathVariable String courseId,@PathVariable long userId,@RequestBody Courses courses) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			processResult= coursesManagerService.publishCourses(userId, courses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	@RequestMapping(method = RequestMethod.POST,value = "{userId}/{courseId}/confClass")
	public  ProcessResult configureClass(@PathVariable String courseId,@PathVariable long userId,@RequestBody CourseClass courseClass) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			List<CourseClass> lists = new ArrayList<CourseClass>();
			lists.add(courseClass);
			processResult= coursesManagerService.configureClass(userId, lists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	@RequestMapping(method = RequestMethod.POST,value = "{userId}/{courseId}/delClass")
	public  ProcessResult delClass(@PathVariable String courseId,@PathVariable long userId,@RequestBody CourseClass courseClass) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			List<CourseClass> lists = new ArrayList<CourseClass>();
			lists.add(courseClass);
			processResult= coursesManagerService.deleteClass(userId, lists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}
	/**
	 * 老师发布课时
	 * @param courseId
	 * @param userId
	 * @param courseClass
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,value = "{userId}/{courseId}/publishClass")
	public  ProcessResult publishClass(@PathVariable String courseId,@PathVariable long userId,@RequestBody CourseClass courseClass) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		try {
			//List<CourseClass> lists = new ArrayList<CourseClass>();
			processResult= coursesManagerService.publishClass(userId, courseClass.getCourseId(), courseClass.getChapterId(), courseClass.getClassId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}
	
}
