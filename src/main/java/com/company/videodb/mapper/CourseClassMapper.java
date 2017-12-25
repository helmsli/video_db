package com.company.videodb.mapper;

import java.util.List;

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
	@Insert("INSERT INTO courseClass(partitionId,classId,courseId,chapterId,courseseqId,category,classTitle,searchKeys,"
			+ "durationSeconds,owner,createTime,originalPrice,realPrice,priceVer,checkCrc,freeDurations,"
			+ "freePercent,detail,videoId,videoUrl,status,teacherName,teacherResume) VALUES("
			+ "#{partitionId},#{classId},#{courseId},#{chapterId},#{courseseqId},#{category},#{classTitle},#{searchKeys},"
			+ "#{durationSeconds},#{owner},#{createTime},#{originalPrice},#{realPrice},#{priceVer},#{checkCrc},#{freeDurations},"
			+ "#{freePercent},#{detailByte},#{videoId},#{videoUrl},#{status},#{teacherName},#{teacherResume})")	   
	public void insertCourseClass(CourseClass courseClass);
	
	/**
	 * 
	 * @param courseId
	 * @return
	 */
	@Select("SELECT partitionId,classId,courseId,chapterId,courseseqId,category,classTitle,searchKeys,"
			+ "durationSeconds,owner,createTime,originalPrice,realPrice,priceVer,checkCrc,freeDurations,"
			+ "freePercent,detail as detailByte,videoId,videoUrl,status,teacherName,teacherResume "
			+ "FROM courseClass where partitionId=#{partitionId} and courseId = #{courseId}  and classId=#{classId}")
	public CourseClass selectByClassid(@Param("partitionId") String partitionId,@Param("courseId") String courseId,@Param("classId") String classId);
	
	/**
	 * 按照课程查询
	 * @param partitionId
	 * @param courseId
	 * @return
	 */
	@Select("SELECT partitionId,classId,courseId,chapterId,courseseqId,category,classTitle,searchKeys,"
			+ "durationSeconds,owner,createTime,originalPrice,realPrice,priceVer,checkCrc,freeDurations,"
			+ "freePercent,detail as detailByte,videoId,videoUrl,status,teacherName,teacherResume "
			+ " FROM courseClass where partitionId=#{partitionId} and courseId = #{courseId} order by partitionId asc,courseId asc,chapterId asc,classId asc")
	public List<CourseClass> selectByCourseId(@Param("partitionId") String partitionId,@Param("courseId") String courseId);
	
	/**
	 * 
	 * @param courseId
	 * @return
	 */
	@Update("update courseClass set "
			 +"courseseqId=#{courseseqId},category=#{category},classTitle=#{classTitle},searchKeys=#{searchKeys},"
			+ "durationSeconds=#{durationSeconds},owner=#{owner},createTime=#{createTime},originalPrice=#{originalPrice},realPrice=#{realPrice},"
			+ "priceVer=#{priceVer},checkCrc=#{checkCrc},freeDurations=#{freeDurations},"
			+ "freePercent=#{freePercent},detail=#{detailByte},videoId=#{videoId},videoUrl=#{videoUrl},status=#{status},teacherName=#{teacherName},teacherResume=#{teacherResume}"
			+" where partitionId=#{partitionId} and courseId = #{courseId} and chapterId=#{chapterId} and classId=#{classId}")
	public int updateClass(CourseClass courseClass);
	
	/**
	 * 修改课时的状态
	 * @param courseClass
	 * @return
	 */
	@Update("update courseClass set status=#{status}"
			+" where partitionId=#{partitionId} and courseId = #{courseId} and chapterId=#{chapterId} and classId=#{classId}")
	public int updateStatus(CourseClass courseClass);
	
	@Update("update originalPrice=#{originalPrice},realPrice=#{realPrice}"
			+" where partitionId=#{partitionId} and courseId = #{courseId} and chapterId=#{chapterId} and classId=#{classId}")
	public int updatePrice(CourseClass courseClass);
	
	
	/**
	 * 
	 * @param courseId
	 * @param chapterId
	 * @param classId
	 * @return
	 */
	@Delete("delete  FROM courseClass where partitionId=#{partitionId} and courseId = #{courseId} and chapterId=#{chapterId} and classId=#{classId}")
	public int deleteByClassid(@Param("partitionId") String partitionId,@Param("courseId") String courseId,@Param("chapterId") String chapterId,@Param("classId") String classId);
	
	@Delete("delete  FROM courseClass where partitionId=#{partitionId} and courseId = #{courseId}")
	public int deleteByCourseid(@Param("partitionId") String partitionId,@Param("courseId") String courseId);
	
}
