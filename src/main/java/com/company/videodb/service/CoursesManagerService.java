package com.company.videodb.service;

import java.util.List;

import com.company.videodb.domain.CourseClass;
import com.company.videodb.domain.Courses;
import com.xinwei.nnl.common.domain.ProcessResult;

public interface CoursesManagerService {
	/**
	 * 配置课程信息
	 * @param courses
	 * @return
	 */
	public ProcessResult configureCourses(long userId,Courses courses);
	
	/**
	 * 配置课时信息
	 * @param courseClass
	 * @return
	 */
	public ProcessResult configureClass(long userId,List<CourseClass> courseClassList);
	
	/**
	 * 删除课时信息
	 * @param courseClass
	 * @return
	 */
	public ProcessResult deleteClass(long userId,List<CourseClass> courseClassList);
	
	/**
	 * 删除课程信息
	 * @param courseClass
	 * @return
	 */
	public ProcessResult deleteCourse(long userId,Courses courses);
	
	/**
	 * 发布课程
	 * @param courses
	 * @return
	 */
	public ProcessResult publishCourses(long userId,Courses courses);
	
	/**
	 * 
	 * @param userId
	 * @param courses
	 * @return
	 */
	public ProcessResult stopSaleCourses(long userId,Courses courses);
	
	
	/**
	 * 
	 * @param userId
	 * @return  -- 返回所有课程的信息列表；
	 */
	public ProcessResult queryMyCourses(long userId,String catetory);
	
	/**
	 * 查询单个课程信息
	 * @param courseId
	 * @return
	 */
	public ProcessResult queryCourses(long userId,String courseId);
	
	/**
	 * 查询单个课程
	 * @param userId -- 用户ID
	 * @param courseId -- 课程id，不能为空，
	 * @param chapterId -- 章节ID，如果为空，查询所有章节
	 * @param classId  -- 课时ID，如果为空，查询所有课时
	 * @return
	 */
	public ProcessResult queryMyClass(long userId,String courseId,String chapterId,String classId);
	
	/**
	 * 查询单个课程信息
	 * @param courseId
	 * @return
	 */
	public ProcessResult publishClass(long userId,String courseId,String chapterId,String classId);
	
	/**
	 * 
	 * @param userId
	 * @param courseId
	 * @param chapterId
	 * @param classId
	 * @return
	 */
	public ProcessResult stopSaleClass(long userId,String courseId,String chapterId,String classId);
	
}
