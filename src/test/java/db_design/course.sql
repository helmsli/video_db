SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS courseClass;




/* Create Tables */

CREATE TABLE course
(
	-- 课程分组，类似于一门课程，通过groupID来标识一门课程；
	courseId varchar(64) COMMENT '课程分组，类似于一门课程，通过groupID来标识一门课程；',
	title varchar(128),
	courseInfo varchar(1024),
	-- 课程的章节信息
	courseChapter varchar(1024) COMMENT '课程的章节信息',
	-- 保存html格式的内容或者jason和模版。包括课程的介绍，课程须知，
	detail varchar(1024) COMMENT '保存html格式的内容或者jason和模版。包括课程的介绍，课程须知，',
	-- 课程发布者填写的该课程适用的人群
	fitPeople varchar(64) COMMENT '课程发布者填写的该课程适用的人群',
	-- 标签以\分割，可以保存多个标签，用于视频的关键字搜索
	searchKeys varchar(128) COMMENT '标签以\分割，可以保存多个标签，用于视频的关键字搜索',
	-- 视频分类，以/分割
	catrgory varchar(256) COMMENT '视频分类，以/分割',
	courseAvatar varchar(64),
	-- 初级/中级/高级
	difficultyLevel varchar(32) COMMENT '初级/中级/高级',
	-- 保存发布这ID和发布者姓名，保存json字符串
	owner varchar(256) COMMENT '保存发布这ID和发布者姓名，保存json字符串',
	createTime datetime,
	-- 原始价格
	originalPrice float(10,4) COMMENT '原始价格',
	realPrice float(10,4),
	-- 到期后，视频自动下架
	expireDate datetime COMMENT '到期后，视频自动下架',
	-- 保存价格的版本，任何一次价格变化都需要修改该数值。该数值保存修改价格的时间戳，单位到毫秒
	priceVer bigint COMMENT '保存价格的版本，任何一次价格变化都需要修改该数值。该数值保存修改价格的时间戳，单位到毫秒',
	-- 用于对课程的关键信息字段做crc，确保数据没有被篡改
	checkCrc varchar(256) COMMENT '用于对课程的关键信息字段做crc，确保数据没有被篡改',
	-- 1--准备发布
	-- 2--已经发布
	-- 3--已经发布后修改待二次发布
	-- 4--下架
	status int COMMENT '1--准备发布
2--已经发布
3--已经发布后修改待二次发布
4--下架',
	teacherName varchar(64),
	teacherResume varchar(256)
);


-- 用来保存课程的静态数据
CREATE TABLE courseClass
(
	classId varchar(64),
	-- 课程分组，类似于一门课程，通过groupID来标识一门课程；
	courseId varchar(64) COMMENT '课程分组，类似于一门课程，通过groupID来标识一门课程；',
	-- 通过章节ID来对每一节课的内容进行分类，类似于目录中的总标题
	chapterId varchar(64) COMMENT '通过章节ID来对每一节课的内容进行分类，类似于目录中的总标题',
	-- 显示顺序，课程->章节->课时序号,
	courseSeqID varchar(64) COMMENT '显示顺序，课程->章节->课时序号,',
	-- 课时的标题
	classTitle varchar(128) COMMENT '课时的标题',
	-- 标签以\分割，可以保存多个标签，用于视频的关键字搜索
	searchKeys varchar(128) COMMENT '标签以\分割，可以保存多个标签，用于视频的关键字搜索',
	-- 单位秒
	durationSeconds int COMMENT '单位秒',
	-- 保存发布这ID和发布者姓名，保存json字符串
	owner varchar(256) COMMENT '保存发布这ID和发布者姓名，保存json字符串',
	createTime datetime,
	-- 原始价格
	originalPrice float(10,4) COMMENT '原始价格',
	realPrice float(10,4),
	-- 保存价格的版本，任何一次价格变化都需要修改该数值。该数值保存修改价格的时间戳，单位到毫秒
	priceVer bigint COMMENT '保存价格的版本，任何一次价格变化都需要修改该数值。该数值保存修改价格的时间戳，单位到毫秒',
	-- 用于对课程的关键信息字段做crc，确保数据没有被篡改
	checkCrc varchar(256) COMMENT '用于对课程的关键信息字段做crc，确保数据没有被篡改',
	freeDurations int,
	-- 百分之多少
	freePercent int COMMENT '百分之多少',
	-- 保存html格式的内容或者jason和模版。包括课程的介绍，课程须知，
	detail varchar(1024) COMMENT '保存html格式的内容或者jason和模版。包括课程的介绍，课程须知，',
	vodeoId varchar(128),
	voidUrl varchar(128),
	-- 1--准备发布
	-- 2--已经发布
	-- 3--已经发布后修改待二次发布
	-- 4--下架
	status int COMMENT '1--准备发布
2--已经发布
3--已经发布后修改待二次发布
4--下架',
	teacherName varchar(64),
	teacherResume varchar(256)
) COMMENT = '用来保存课程的静态数据';



