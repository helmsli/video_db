package com.company.videodb.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.company.videodb.domain.CourseClass;



@Mapper
public interface CourseClassMapper {
	/**
	 * 
	 * @param CourseClass
	 */
	@Insert("INSERT INTO courseClass(classId,courseId,chapterId,courseseqId,classTitle,searchKeys,"
			+ "durationSeconds,owner,createTime,originalPrice,realPrice,priceVer,checkCrc,freeDurations,"
			+ "freePercent,detail,vodeoId,voidurl,status,teacherName,teacherResume) VALUES("
			+ "#{classId},#{courseId},#{chapterId},#{courseseqId},#{classTitle},#{searchKeys},"
			+ "#{durationSeconds},#{owner},#{createTime},#{originalPrice},#{realPrice},#{priceVer},#{checkCrc},#{freeDurations},"
			+ "#{freePercent},#{detail},#{vodeoId},#{voidurl},#{status},#{teacherName},#{teacherResume})")	   
	public void insertCourseClass(CourseClass CourseClass);
	
	/**
	 * 
	 * @param courseId
	 * @return
	 */
	@Select("SELECT * FROM courseClass where owner=#{owner} and courseId = #{courseId} and chapterId=#{chapterId} and classId=#{classId}")
	public CourseClass selectByClassid(@Param("owner") String owner,@Param("courseId") String courseId,@Param("chapterId") String chapterId,@Param("classId") String classId);
	
	/**
	 * 
	 * @param courseId
	 * @return
	 */
	@Update("update courseClass set "
			 +"courseseqId=#{courseseqId},classTitle=#{classTitle},searchKeys=#{searchKeys},"
			+ "durationSeconds=#{durationSeconds},owner=#{owner},createTime=#{createTime},originalPrice=#{originalPrice},realPrice=#{realPrice},"
			+ "priceVer=#{priceVer},checkCrc=#{checkCrc},freeDurations=#{freeDurations},"
			+ "freePercent=#{freePercent},detail=#{detail},vodeoId=#{vodeoId},voidurl=#{voidurl},status=#{status},teacherName=#{teacherName},teacherResume=#{teacherResume}"
			+"where owner=#{owner} and courseId = #{courseId} and chapterId=#{chapterId} and classId=#{classId}")
	public int updateClass(CourseClass courseClass);
	
	/**
	 * 修改课时的状态
	 * @param courseClass
	 * @return
	 */
	@Update("update courseClass set status=#{status}"
			+"where owner=#{owner} and courseId = #{courseId} and chapterId=#{chapterId} and classId=#{classId}")
	public int updateStatus(CourseClass courseClass);
	
	@Update("update originalPrice=#{originalPrice},realPrice=#{realPrice}"
			+"where owner=#{owner} and courseId = #{courseId} and chapterId=#{chapterId} and classId=#{classId}")
	public int updatePrice(CourseClass courseClass);
	
	
	/**
	 * 
	 * @param courseId
	 * @param chapterId
	 * @param classId
	 * @return
	 */
	@Delete("delete  FROM courseClass where owner=#{owner} and courseId = #{courseId} and chapterId=#{chapterId} and classId=#{classId}")
	public int deleteByClassid(@Param("owner") String owner,@Param("courseId") String courseId,@Param("chapterId") String chapterId,@Param("classId") String classId);
	
}
