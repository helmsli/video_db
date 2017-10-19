package com.company.videodb.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Model class of 一节课.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class CourseClass implements Serializable {
	/**
	 * 准备发布
	 */
	public static final int STATUS_WillPublish=1;
	/**
	 * 已经发布
	 */
	public static final int STATUS_Published=2;
	/**
	 * 发布后修改等待再次发布
	 */
	public static final int STATUS_WillPublishAgain=3;
	/**
	 * 停止销售，下架
	 */
	public static final int STATUS_StopSales=4;
	
	
	/** 课时ID，标识一个视频的唯一编号. */
	private String classId;

	/** 课程编号. */
	private String courseId;

	/** 章节. */
	private String chapterId;

	/** 课时序号. */
	private String courseseqId;

	/** 课时分类. 视频/ppt/语音*/
	private String category;
	
	/** 课时标题. */
	private String classTitle;

	/** 课时详情. */
	private String classDetail;

	
	/** 标签. */
	private String searchKeys;

	/** 课程时长. */
	private int durationSeconds;

	/** 发布者. */
	private String owner;

	/** 发布时间. */
	private Date createTime;

	/** 发布的原价. */
	private float originalPrice;

	/** 实际成交价格. */
	private float realPrice;

	/** 价格版本. */
	private long priceVer;

	/** 课程保护字段. */
	private String checkCrc;

	/** 免费观看的时长. 秒*/
	private int freeDurations;

	/** 免费观看百分比. */
	private int freePercent;
	
	/** 课程详情. */
	private String detail;

	/** 视频播放id. */
	private String vodeoId;

	/** 视频播放地址. */
	private String voidurl;
	/**
	 * 1--准备发布
2--已经发布
3--已经发布后修改待二次发布
4--下架
	 */
	private int  status;
	
	private String teacherName;
	
	private String teacherResume;
	
	
	
	/**
	 * Constructor.
	 */
	public CourseClass() {
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getChapterId() {
		return chapterId;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	public String getCourseseqId() {
		return courseseqId;
	}

	public void setCourseseqId(String courseseqId) {
		this.courseseqId = courseseqId;
	}

	public String getClassTitle() {
		return classTitle;
	}

	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}

	public String getSearchKeys() {
		return searchKeys;
	}

	public void setSearchKeys(String searchKeys) {
		this.searchKeys = searchKeys;
	}

	public int getDurationSeconds() {
		return durationSeconds;
	}

	public void setDurationSeconds(int durationSeconds) {
		this.durationSeconds = durationSeconds;
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

	public int getFreeDurations() {
		return freeDurations;
	}

	public void setFreeDurations(int freeDurations) {
		this.freeDurations = freeDurations;
	}

	public int getFreePercent() {
		return freePercent;
	}

	public void setFreePercent(int freePercent) {
		this.freePercent = freePercent;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getVodeoId() {
		return vodeoId;
	}

	public void setVodeoId(String vodeoId) {
		this.vodeoId = vodeoId;
	}

	public String getVoidurl() {
		return voidurl;
	}

	public void setVoidurl(String voidurl) {
		this.voidurl = voidurl;
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
		return "CourseClass [classId=" + classId + ", courseId=" + courseId + ", chapterId=" + chapterId
				+ ", courseseqId=" + courseseqId + ", classTitle=" + classTitle + ", searchKeys=" + searchKeys
				+ ", durationSeconds=" + durationSeconds + ", owner=" + owner + ", createTime=" + createTime
				+ ", originalPrice=" + originalPrice + ", realPrice=" + realPrice + ", priceVer=" + priceVer
				+ ", checkCrc=" + checkCrc + ", freeDurations=" + freeDurations + ", freePercent=" + freePercent
				+ ", detail=" + detail + ", vodeoId=" + vodeoId + ", voidurl=" + voidurl + ", status=" + status
				+ ", teacherName=" + teacherName + ", teacherResume=" + teacherResume + "]";
	}

	

	

	

	
}
