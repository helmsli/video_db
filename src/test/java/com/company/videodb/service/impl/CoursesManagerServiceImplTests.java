package com.company.videodb.service.impl;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.videodb.Const.VideodbConst;
import com.company.videodb.domain.Courses;
import com.company.videodb.service.CoursesManagerService;
import com.xinwei.nnl.common.domain.ProcessResult;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursesManagerServiceImplTests {
	@Resource(name="coursesManagerService")
	private CoursesManagerService coursesManagerService;
	
	@Before
	public void setUp() throws Exception {
		 
	}

	protected Courses createTestCourse()
	{
		Courses courses= new Courses();
		courses.setCatrgory("catetory");
		courses.setCheckCrc("checkCrc");
		courses.setCourseAvatar("courseAvatar");
		courses.setCourseChapter("courseChapter");
		courses.setCourseId("courseid");
		courses.setCourseInfo("courseInfo");
		Calendar now = Calendar.getInstance();
		now.set(Calendar.MILLISECOND, 0);
		courses.setCreateTime(now.getTime());
		courses.setDetail("detail");
		courses.setDifficultyLevel("difficultyLevel");
		now.add(Calendar.HOUR_OF_DAY, 1);
		
		courses.setExpireDate(now.getTime());
		courses.setFitPeople("fitPeople");
		courses.setOriginalPrice(100.001f);
		courses.setOwner("1000");
		courses.setPriceVer(10);
		courses.setRealPrice(50.02f);
		courses.setSearchKeys("searchkeys");
		courses.setStatus(1);
		courses.setTeacherName("teacherName");
		courses.setTeacherResume("teacherResume");
		courses.setTitle("title");
		return courses;
	}
	
	@Test
	public void testConfigureCourses()
	{
		long userId=1000;
		Courses courses = this.createTestCourse();
		courses.setCourseId(String.valueOf(userId));
		coursesManagerService.deleteCourse(userId, courses);
		ProcessResult processResult = coursesManagerService.configureCourses(userId, courses);
		assertEquals("testConfigureCourses configure error",VideodbConst.RESULT_SUCCESS,processResult.getRetCode());
		ProcessResult queryProcessResult = coursesManagerService.queryCourses(userId, courses.getCourseId());
		assertEquals("testConfigureCourses query result",VideodbConst.RESULT_SUCCESS,queryProcessResult.getRetCode());
		Courses queryCourse = (Courses)queryProcessResult.getResponseInfo();
		assertEquals("testConfigureCourses configure not equal",queryCourse.toString(),courses.toString());
		
		
	}
}
