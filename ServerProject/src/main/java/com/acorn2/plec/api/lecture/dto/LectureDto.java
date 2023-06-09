package com.acorn2.plec.api.lecture.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("lectureDto")
public class LectureDto {
	private Integer lecNum;
	private Integer imageNum;
	private String teacher;
	private String lecWriter;
	private String title;
	private String describe;
	private String videoPath;
	private String userRegdate;
	private String updateDate;
	private Integer viewCount;
	private String largeCategory;
	private String smallCategory;
	private String updateId;
	private String serviceYnCode;
	
	public LectureDto() {}

	public LectureDto(Integer lecNum, Integer imageNum, String teacher, String lecWriter, String title, String describe,
			String videoPath, String userRegdate, String updateDate, Integer viewCount, String largeCategory,
			String smallCategory, String updateId, String serviceYnCode) {
		super();
		this.lecNum = lecNum;
		this.imageNum = imageNum;
		this.teacher = teacher;
		this.lecWriter = lecWriter;
		this.title = title;
		this.describe = describe;
		this.videoPath = videoPath;
		this.userRegdate = userRegdate;
		this.updateDate = updateDate;
		this.viewCount = viewCount;
		this.largeCategory = largeCategory;
		this.smallCategory = smallCategory;
		this.updateId = updateId;
		this.serviceYnCode = serviceYnCode;
	}

	public Integer getLecNum() {
		return lecNum;
	}

	public void setLecNum(Integer lecNum) {
		this.lecNum = lecNum;
	}

	public Integer getImageNum() {
		return imageNum;
	}

	public void setImageNum(Integer imageNum) {
		this.imageNum = imageNum;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getLecWriter() {
		return lecWriter;
	}

	public void setLecWriter(String lecWriter) {
		this.lecWriter = lecWriter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public String getLargeCategory() {
		return largeCategory;
	}

	public void setLargeCategory(String largeCategory) {
		this.largeCategory = largeCategory;
	}

	public String getSmallCategory() {
		return smallCategory;
	}

	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getServiceYnCode() {
		return serviceYnCode;
	}

	public void setServiceYnCode(String serviceYnCode) {
		this.serviceYnCode = serviceYnCode;
	}

		
	
	
}
