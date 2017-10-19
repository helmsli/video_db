package com.company.videodb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.company.videodb.domain.CourseClass;
import com.company.videodb.domain.Courses;

@Mapper
public interface CoursesMapper {
	/**
	 * 
	 * @param courses
	 */
	@Insert("INSERT INTO courses(courseId,title,courseInfo,courseChapter,detail,fitPeople,"
			+ "searchKeys,catrgory,courseAvatar,difficultyLevel,owner,createTime,originalPrice,realPrice,"
			+ "expireDate,priceVer,checkCrc,status,teacherName,teacherResume) VALUES("
			+ "#{courseId},#{title},#{courseInfo},#{courseChapter},#{detail},#{fitPeople},"
			+ "#{searchKeys},#{catrgory},#{courseAvatar},#{difficultyLevel},#{owner},#{createTime},#{originalPrice},#{realPrice},"
			+ "#{expireDate},#{priceVer},#{checkCrc},#{status},#{teacherName},#{teacherResume})")	   
	public void insertCourses(Courses courses);
	/**
	 * 
	 * @param courseId
	 * @return
	 */
	@Select("SELECT * FROM courses where owner=#{owner} and courseId = #{courseId} ")
	public Courses selectCoursesByid(@Param("owner") String owner,@Param("courseId") String courseId);
	
	/**
	 * 
	 * @param courses
	 * @return
	 */
	@Update("update courses set "
			+ "title=#{title},courseInfo=#{courseInfo},courseChapter=#{courseChapter},detail=#{detail},"
			+ "fitPeople=#{fitPeople},searchKeys=#{searchKeys},catrgory=#{catrgory},courseAvatar=#{courseAvatar},"
			+ "difficultyLevel=#{difficultyLevel},owner=#{owner},createTime=#{createTime},originalPrice=#{originalPrice},"
			+ "realPrice=#{realPrice},expireDate=#{expireDate},priceVer=#{priceVer},checkCrc=#{checkCrc},status=#{status} ,teacherName=#{teacherName},teacherResume=#{teacherResume} where owner=#{owner} and courseId = #{courseId}")
	public int updateCourses(Courses courses);	
	
	/**
	 * 
	 * @param courseId
	 * @return
	 */
	@Delete("delete FROM courses where owner=#{owner} and courseId = #{courseId}")
	public int deleteCourses(@Param("owner") String owner,@Param("courseId") String courseId);

	
	@Update("update courses set status=#{status} where owner=#{owner} and courseId = #{courseId}")
	public int updateStatus(Courses courses);
	
	@Update("update originalPrice=#{originalPrice},realPrice=#{realPrice}"
			+"where owner=#{owner} and courseId = #{courseId} ")
	public int updatePrice(Courses courses);
	
}
