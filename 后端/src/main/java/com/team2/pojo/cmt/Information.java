package com.team2.pojo.cmt;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include; 
import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
@JsonInclude(Include.NON_NULL)

/**Information*/
public class Information implements Serializable {

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "标题(字符长度为1-255)")
	@Size(min=1, max=255,message="标题字符长度为1-255")
	private String title;

	@ApiModelProperty(value = "正文内容(字符长度为1-255)")
	@Size(min=1, max=255,message="正文内容字符长度为1-255")
	private String content;
	
	@ApiModelProperty(value = "分类名称")
	private String name;

	@ApiModelProperty(value = "图片(字符长度为1-255)")
	@Size(min=1, max=255,message="图片字符长度为1-255")
	private String picture;

	@ApiModelProperty(value = "信息状态0：未交易1：已交易2：涉嫌违规(字符长度为1-1)")
	@Size(min=1, max=1,message="信息状态0：未交易1：已交易2：涉嫌违规字符长度为1-1")
	private String status;

	@ApiModelProperty(value = "信息类型0：需求1：资源(字符长度为1-1)")
	@Size(min=1, max=1,message="信息类型0：需求1：资源字符长度为1-1")
	private String type;

	@ApiModelProperty(value = "分类id")
	private Long categoryId;
	
	@ApiModelProperty(value = "用户id")
	private Long userId;

	@ApiModelProperty(value = "用户昵称")
	private String userNickName;

	@ApiModelProperty(value = "用户头像URL")
	private String userHeadUrl;

	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;

	@ApiModelProperty(value = "修改时间")
	private Timestamp updateTime;

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "失效时间")
	private Date endTime;


    private static final long serialVersionUID = 1L;

	public Long getId () {   
		return id;
	}
		
	public void setId (Long id) {
		this.id= id ;
	}

    public String getTitle () {   
    	 return title;
    }

    public void setTitle (String title) {
    	 this.title= title == null ? null : title.trim();
    }

    public String getContent () {   
    	 return content;
    }

    public void setContent (String content) {
    	 this.content= content == null ? null : content.trim();
    }

    public String getPicture () {   
    	 return picture;
    }

    public void setPicture (String picture) {
    	 this.picture= picture == null ? null : picture.trim();
    }

    public String getStatus () {   
    	 return status;
    }

    public void setStatus (String status) {
    	 this.status= status == null ? null : status.trim();
    }

    public String getType () {   
    	 return type;
    }

    public void setType (String type) {
    	 this.type= type == null ? null : type.trim();
    }

	public Long getCategoryId () {   
		return categoryId;
	}
		
	public void setCategoryId (Long categoryId) {
		this.categoryId= categoryId ;
	}

	public Date getEndTime () {   
	    return endTime;
	}

	public void setEndTime (Date endTime) {
	    this.endTime= endTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserHeadUrl() {
		return userHeadUrl;
	}

	public void setUserHeadUrl(String userHeadUrl) {
		this.userHeadUrl = userHeadUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}