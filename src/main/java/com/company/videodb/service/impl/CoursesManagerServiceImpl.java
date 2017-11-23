package com.company.videodb.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import com.company.videodb.Const.VideodbConst;
import com.company.videodb.domain.CourseClass;
import com.company.videodb.domain.Courses;
import com.company.videodb.mapper.CourseClassMapper;
import com.company.videodb.mapper.CoursesMapper;
import com.company.videodb.service.CoursesManagerService;
import com.xinwei.nnl.common.domain.ProcessResult;
@Service("coursesManagerService")
public class CoursesManagerServiceImpl implements CoursesManagerService {
	@Autowired
	private CoursesMapper coursesMapper;
	@Autowired
	private CourseClassMapper courseClassMapper;
	@Value("{course.dbCrcKey:courese!@#$}")
	private String dbCrcKey;
	
	/**
	 * 生成课程的crc校验和
	 * @param courses
	 * @return
	 */
	protected String createCoureseCrc(Courses courses)
	{
		StringBuilder str  = new StringBuilder();
		str.append(courses.getCourseId());
		str.append(DbAlgorithm.Prop_split);
		str.append(courses.getOwner());
		str.append(DbAlgorithm.Prop_split);
		
		long lAmount =Math.round(courses.getRealPrice()*100);	
		str.append(lAmount);
		str.append(DbAlgorithm.Prop_split);
		String crcCheck = DbAlgorithm.EncoderByMd5(this.dbCrcKey, str.toString());
		
		return crcCheck;
	}
	/**
	 * 
	 * @param courses
	 * @return
	 */
	protected boolean checkCoureseCrc(Courses courses)
	{
		String crcCheck = this.createCoureseCrc(courses);
		return crcCheck.equalsIgnoreCase(courses.getCheckCrc());
	}
	
	protected String createCoureseClassCrc(CourseClass courseClass)
	{
		StringBuilder str  = new StringBuilder();
		str.append(courseClass.getCourseId());
		str.append(DbAlgorithm.Prop_split);
		str.append(courseClass.getOwner());
		str.append(DbAlgorithm.Prop_split);
		long lAmount =Math.round(courseClass.getRealPrice()*100);	
		str.append(lAmount);
		str.append(DbAlgorithm.Prop_split);
		str.append(courseClass.getVodeoId());
		str.append(DbAlgorithm.Prop_split);
		str.append(courseClass.getVoidurl());
		str.append(DbAlgorithm.Prop_split);
		String crcCheck = DbAlgorithm.EncoderByMd5(this.dbCrcKey, str.toString());
		
		return crcCheck;
	}
	/**
	 * 
	 * @param courses
	 * @return
	 */
	protected boolean checkCoureseClassCrc(CourseClass courses)
	{
		String crcCheck = this.createCoureseClassCrc(courses);
		return crcCheck.equalsIgnoreCase(courses.getCheckCrc());
	}
	
	/**
	 * 先从数据库查询出对应的数据，如果数据不为空，则覆盖目标的属性
	 * @param sourceCourses
	 * @param destCourses
	 * @return
	 */
	protected Courses getCourses(Courses sourceCourses,Courses destCourses)
	{
		Courses courses= destCourses;
		
		
		if(!StringUtils.isEmpty(sourceCourses.getPartitionId()))
		{
			courses.setPartitionId(sourceCourses.getPartitionId());
		}
		if(!StringUtils.isEmpty(sourceCourses.getCategory()))
		{
			courses.setCategory(sourceCourses.getCategory());
		}
		if(!StringUtils.isEmpty(sourceCourses.getCourseAvatar()))
		{
			courses.setCourseAvatar(sourceCourses.getCourseAvatar());
		}
		if(!StringUtils.isEmpty(sourceCourses.getCourseChapter()))
		{
			courses.setCourseChapter(sourceCourses.getCourseChapter());
		}
		if(!StringUtils.isEmpty(sourceCourses.getCourseInfo()))
		{
			courses.setCourseInfo(sourceCourses.getCourseInfo());
		}
		if(!StringUtils.isEmpty(sourceCourses.getDetail()))
		{
			courses.setDetail(sourceCourses.getDetail());
		}
		if(!StringUtils.isEmpty(sourceCourses.getDifficultyLevel()))
		{
			courses.setDifficultyLevel(sourceCourses.getDifficultyLevel());
		}
		if(sourceCourses.getExpireDate()!=null)
		{
			courses.setExpireDate(sourceCourses.getExpireDate());
		}
		if(!StringUtils.isEmpty(sourceCourses.getFitPeople()))
		{
			courses.setFitPeople(sourceCourses.getFitPeople());
		}
		if(sourceCourses.getOriginalPrice()!=0)
		{
			courses.setOriginalPrice(sourceCourses.getOriginalPrice());
		}
		if(!StringUtils.isEmpty(sourceCourses.getOwner()))
		{
			courses.setOwner(sourceCourses.getOwner());
		}
		if(sourceCourses.getPriceVer()!=0)
		{
			courses.setPriceVer(sourceCourses.getPriceVer());
		}
		
		if(sourceCourses.getRealPrice()!=0)
		{
			courses.setRealPrice(sourceCourses.getRealPrice());
		}
		if(!StringUtils.isEmpty(sourceCourses.getSearchKeys()))
		{
			courses.setSearchKeys(sourceCourses.getSearchKeys());
		}
		if(!StringUtils.isEmpty(sourceCourses.getTitle()))
		{
			courses.setTitle(sourceCourses.getTitle());
		}
		if(sourceCourses.getStatus()!=0)
		{
			courses.setStatus(sourceCourses.getStatus());
		}
		
		if(!StringUtils.isEmpty(sourceCourses.getTeacherName()))
		{
			courses.setTeacherName(sourceCourses.getTeacherName());
		}
		if(!StringUtils.isEmpty(sourceCourses.getTeacherResume()))
		{
			courses.setTeacherResume(sourceCourses.getTeacherResume());
		}
		
		return courses;
	}
	
	
	protected CourseClass getCourseClass(CourseClass sourceClass,CourseClass destClass)
	{
		CourseClass courseClass= destClass;
		
		if(!StringUtils.isEmpty(sourceClass.getPartitionId()))
		{
			courseClass.setPartitionId(sourceClass.getPartitionId());
		}
		
		if(!StringUtils.isEmpty(sourceClass.getChapterId()))
		{
			courseClass.setChapterId(courseClass.getChapterId());
		}
		if(!StringUtils.isEmpty(sourceClass.getCheckCrc()))
		{
			courseClass.setCheckCrc(sourceClass.getCheckCrc());
		}
		if(!StringUtils.isEmpty(sourceClass.getClassId()))
		{
			courseClass.setClassId(sourceClass.getClassId());
		}
		
		if(!StringUtils.isEmpty(sourceClass.getClassTitle()))
		{
			courseClass.setClassTitle(sourceClass.getClassTitle());
		}
		if(!StringUtils.isEmpty(sourceClass.getCourseId()))
		{
			courseClass.setCourseId(sourceClass.getCourseId());
		}
		if(!StringUtils.isEmpty(sourceClass.getCourseseqId()))
		{
			courseClass.setCourseseqId(sourceClass.getCourseseqId());
		}
		
		
		if(!StringUtils.isEmpty(sourceClass.getDetail()))
		{
			courseClass.setDetail(sourceClass.getDetail());
		}
		
		if(sourceClass.getDurationSeconds()!=0)
		{
			courseClass.setDurationSeconds(sourceClass.getDurationSeconds());
		}
		if(sourceClass.getFreeDurations()!=0)
		{
			courseClass.setFreeDurations(sourceClass.getFreeDurations());
		}
		if(sourceClass.getFreePercent()!=0)
		{
			courseClass.setFreePercent(sourceClass.getFreePercent());
		}
		if(sourceClass.getOriginalPrice()!=0)
		{
			courseClass.setOriginalPrice(sourceClass.getOriginalPrice());
		}
		if(sourceClass.getPriceVer()!=0)
		{
			courseClass.setPriceVer(sourceClass.getPriceVer());
		}
		
		if(sourceClass.getRealPrice()!=0)
		{
			courseClass.setRealPrice(sourceClass.getRealPrice());
		}
		
		
		if(!StringUtils.isEmpty(sourceClass.getSearchKeys()))
		{
			courseClass.setSearchKeys(sourceClass.getSearchKeys());
		}
		
		if(sourceClass.getStatus()!=0)
		{
			courseClass.setStatus(sourceClass.getStatus());
		}
		if(!StringUtils.isEmpty(sourceClass.getVodeoId()))
		{
			courseClass.setVodeoId(sourceClass.getVodeoId());
		}
		if(!StringUtils.isEmpty(sourceClass.getVoidurl()))
		{
			courseClass.setVoidurl(sourceClass.getVoidurl());
		}

		if(!StringUtils.isEmpty(sourceClass.getTeacherName()))
		{
			courseClass.setTeacherName(sourceClass.getTeacherName());
		}
		if(!StringUtils.isEmpty(sourceClass.getTeacherResume()))
		{
			courseClass.setTeacherResume(sourceClass.getTeacherResume());
		}
		
		return courseClass;
	}
	
	@Override
	public ProcessResult configureCourses(Courses courses) {
		// TODO Auto-generated method stub
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		//从数据库中查询课程是否存在
		processResult = queryCourses(courses.getPartitionId(),courses.getCourseId());
		//如果数据库中不存在数据，则插入
		if(processResult.getRetCode()==VideodbConst.RESULT_Error_dbNotExist)
		{
			courses.setCreateTime(Calendar.getInstance().getTime());
			String newCrc = createCoureseCrc(courses);
			courses.setCheckCrc(newCrc);
			coursesMapper.insertCourses(courses);
			processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
		}
		//如果存在数据
		else if(processResult.getRetCode()==VideodbConst.RESULT_SUCCESS)
		{
			//用传入的新数据覆盖数据库中的数据，如果传入的数据为空，或者为0，则不替换
			Courses dbCourses = (Courses)processResult.getResponseInfo();
			//判断是否有人篡改过
			
			if(!this.checkCoureseCrc(dbCourses))
			{
				processResult.setRetCode(VideodbConst.RESULT_Error_Crc);
				return processResult;
			}
			
			dbCourses = getCourses(courses,dbCourses);
			dbCourses.setCreateTime(Calendar.getInstance().getTime());
			String newCrc = createCoureseCrc(dbCourses);
			dbCourses.setCheckCrc(newCrc);
			int updateNum = coursesMapper.updateCourses(dbCourses);
			if(updateNum==1)
			{
				processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
				processResult.setResponseInfo(dbCourses);
			}
			else
			{
				processResult.setRetCode(VideodbConst.RESULT_FAILURE);
			}
		}
		return processResult;
	}

	@Transactional
	protected boolean dbConfigClass(List<CourseClass> courseClassList)
	{
		// TODO Auto-generated method stub
		//删除老的记录信息
		if(courseClassList.size()>0)
		{
			CourseClass dbCourseClass = courseClassList.get(0);
			this.courseClassMapper.deleteByCourseid(dbCourseClass.getPartitionId(), dbCourseClass.getCourseId());
		}
		for(CourseClass courseClass:courseClassList)
		{
			
			//查询课程
			//CourseClass dbCourseClass = courseClassMapper.selectByClassid(courseClass.getPartitionId(), courseClass.getCourseId(),  courseClass.getClassId());
			//如果课程存在
			//if(dbCourseClass!=null)
			CourseClass dbCourseClass = null;
			if(false)
			{
				if(!this.checkCoureseClassCrc(dbCourseClass))
				{
					throw new RuntimeException(dbCourseClass.toString());
				}
				dbCourseClass = getCourseClass(courseClass,dbCourseClass);
				String checkCrc = this.createCoureseClassCrc(dbCourseClass);
				dbCourseClass.setCreateTime(Calendar.getInstance().getTime());
				dbCourseClass.setCheckCrc(checkCrc);
				courseClassMapper.updateClass(dbCourseClass);
			}
			//如果不存在，则插入
			else
			{
				courseClass.setCreateTime(Calendar.getInstance().getTime());
				String checkCrc = this.createCoureseClassCrc(courseClass);
				courseClass.setCheckCrc(checkCrc);
				courseClassMapper.insertCourseClass(courseClass);
			}
		}
		return true;
	}
	
	@Override
	public ProcessResult configureClass(List<CourseClass> courseClassList) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		
		// TODO Auto-generated method stub
		try {
			dbConfigClass(courseClassList);
			processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}

	@Transactional
	protected boolean dbdelClass(List<CourseClass> courseClassList)
	{
		// TODO Auto-generated method stub
		for(CourseClass courseClass:courseClassList)
		{
			
			//查询课程
			courseClassMapper.deleteByClassid(courseClass.getPartitionId(), courseClass.getCourseId(), courseClass.getChapterId(), courseClass.getClassId());
		}
		return true;
	}
	@Override
	public ProcessResult deleteClass(List<CourseClass> courseClassList) {
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		
		// TODO Auto-generated method stub
		try {
			dbdelClass(courseClassList);
			processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processResult;
	}

	@Override
	public ProcessResult deleteCourse(Courses courses) {
		// TODO Auto-generated method stub
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		//删除课程
		int delNumbers = this.coursesMapper.deleteCourses(courses.getPartitionId(),courses.getCourseId());
		if(delNumbers==1)
		{
			processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
		}
		return processResult;
	}

	
	public ProcessResult publishCourses(Courses courses) {
		/**
		 * 将状态修改为发布
		 */
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		
		courses.setStatus(CourseClass.STATUS_Published);
		//删除课程
		int delNumbers = this.coursesMapper.updateStatus(courses);
		if(delNumbers==1)
		{
			processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
		}
		return processResult;
	}

	
	public ProcessResult queryMyCourses(long userId, String catetory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessResult queryMyClass(long userId, String courseId, String chapterId, String classId) {
		return null;
	}

	@Override
	public ProcessResult queryCourses(String partitionId,String courseId) {
		/**
		 * 将状态修改为发布
		 */
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		Courses courses = this.coursesMapper.selectCoursesByid(partitionId,courseId);
		if(courses!=null)
		{
			if(this.checkCoureseCrc(courses))
			{
				processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
				processResult.setResponseInfo(courses);
			}
			else
			{
				processResult.setRetCode(VideodbConst.RESULT_Error_Crc);
				
			}
		}
		else
		{
			processResult.setRetCode(VideodbConst.RESULT_Error_dbNotExist);
		}
		return processResult;

	}
    
	@Override
	public ProcessResult queryClass(String partitionId,String courseId) {
		/**
		 * 将状态修改为发布
		 */
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		List<CourseClass> courseLists = this.courseClassMapper.selectByCourseId(partitionId, courseId);
		if(courseLists!=null)
		{
			
				processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
				processResult.setResponseInfo(courseLists);
			
		}
		else
		{
			processResult.setRetCode(VideodbConst.RESULT_Error_dbNotExist);
		}
		return processResult;

	}

	
	@Override
	public ProcessResult publishClass(long userId, String courseId, String chapterId, String classId) {
		/**
		 * 将状态修改为发布
		 */
		ProcessResult processResult = new ProcessResult();
		processResult.setRetCode(VideodbConst.RESULT_FAILURE);
		CourseClass courseClass = new CourseClass();
		courseClass.setOwner(String.valueOf(userId));
		courseClass.setStatus(CourseClass.STATUS_Published);
		courseClass.setChapterId(chapterId);
		courseClass.setCourseId(courseId);
		courseClass.setClassId(classId);
		//删除课程
		int delNumbers = this.courseClassMapper.updateStatus(courseClass);
		if(delNumbers==1)
		{
			processResult.setRetCode(VideodbConst.RESULT_SUCCESS);
		}
		return processResult;
	}


	public ProcessResult stopSaleCourses(long userId, Courses courses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessResult stopSaleClass(long userId, String courseId, String chapterId, String classId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProcessResult stopSaleCourses(Courses courses) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProcessResult queryMyCourses(String catetory) {
		// TODO Auto-generated method stub
		return null;
	}

}
