package com.company.videodb.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Model class of course.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Courses implements Serializable {



	/** 课程编号. */
	private String courseId;

	/** 课程标题. */
	private String title;

	/** 课程简介. */
	private String courseInfo;

	/** 课程章节信息. */
	private String courseChapter;

	/** 课程详情. */
	private String detail;

	/** 适用人群. */
	private String fitPeople;

	/** 标签. */
	private String searchKeys;

	/** 课程分类. */
	private String category;

	/** 课程头像. */
	private String courseAvatar;

	/** 课程难度级别. */
	private String difficultyLevel;

	/** 发布者. */
	private String owner;

	/** 发布时间. */
	private Date createTime;

	/** 发布的原价. */
	private float originalPrice=0;

	/** 实际成交价格. */
	private float realPrice=0;

	/** 课程下架时间. */
	private Date expireDate=null;

	/** 价格版本. */
	private long priceVer=0;

	/** 课程保护字段. */
	private String checkCrc;

	
	private int status=0;
	
	private String teacherName;
	
	private String teacherResume;
	
	/**
	 * Constructor.
	 */
	public Courses() {
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}

	public String getCourseChapter() {
		return courseChapter;
	}

	public void setCourseChapter(String courseChapter) {
		this.courseChapter = courseChapter;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getFitPeople() {
		return fitPeople;
	}

	public void setFitPeople(String fitPeople) {
		this.fitPeople = fitPeople;
	}

	public String getSearchKeys() {
		return searchKeys;
	}

	public void setSearchKeys(String searchKeys) {
		this.searchKeys = searchKeys;
	}

	public String getCatrgory() {
		return catrgory;
	}

	public void setCatrgory(String catrgory) {
		this.catrgory = catrgory;
	}

	public String getCourseAvatar() {
		return courseAvatar;
	}

	public void setCourseAvatar(String courseAvatar) {
		this.courseAvatar = courseAvatar;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public float getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}

	public float getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(float realPrice) {
		this.realPrice = realPrice;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public long getPriceVer() {
		return priceVer;
	}

	public void setPriceVer(long priceVer) {
		this.priceVer = priceVer;
	}

	public String getCheckCrc() {
		return checkCrc;
	}

	public void setCheckCrc(String checkCrc) {
		this.checkCrc = checkCrc;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherResume() {
		return teacherResume;
	}

	public void setTeacherResume(String teacherResume) {
		this.teacherResume = teacherResume;
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", title=" + title + ", courseInfo=" + courseInfo + ", courseChapter="
				+ courseChapter + ", detail=" + detail + ", fitPeople=" + fitPeople + ", searchKeys=" + searchKeys
				+ ", catrgory=" + catrgory + ", courseAvatar=" + courseAvatar + ", difficultyLevel=" + difficultyLevel
				+ ", owner=" + owner + ", createTime=" + createTime + ", originalPrice=" + originalPrice
				+ ", realPrice=" + realPrice + ", expireDate=" + expireDate + ", priceVer=" + priceVer + ", checkCrc="
				+ checkCrc + ", status=" + status + ", teacherName=" + teacherName + ", teacherResume=" + teacherResume
				+ "]";
	}

	

		
	
}