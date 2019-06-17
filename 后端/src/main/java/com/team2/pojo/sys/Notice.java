package com.team2.pojo.sys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include; 
import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
@JsonInclude(Include.NON_NULL)

/**Notice*/
public class Notice implements Serializable {

	private Long id;

	@ApiModelProperty(value = "标题(字符长度为1-128)")
	@Size(min=1, max=128,message="标题字符长度为1-128")
	@Excel(name="标题",orderNum="1")
	private String title;

	@ApiModelProperty(value = "内容")
	@Excel(name="内容",orderNum="2")
	private String content;

	@ApiModelProperty(value = "状态")
	private Integer status;

	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;

	@ApiModelProperty(value = "更新时间")
	private Timestamp updateTime;

	@ApiModelProperty(value = "备注(字符长度为1-255)")
	@Size(min=1, max=255,message="备注字符长度为1-255")
	@Excel(name="备注",orderNum="6")
	private String memo;


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

	public Integer getStatus () {   
		  return status;
	}
	
	public void setStatus (Integer status) {
		  this.status= status ;
	}

    public String getMemo () {   
    	 return memo;
    }

    public void setMemo (String memo) {
    	 this.memo= memo == null ? null : memo.trim();
    }


	public void difference(Notice obj) {
		String defString = "";
		if (!Objects.equals(this.id,obj.getId())){
			defString += "从" + this.id + "修改为" + obj.getId();
		}

	   if(!this.title.equals(obj.getTitle())) {
			 defString += "标题从" + this.title +"修改为" +obj.getTitle();
		}

	   if(!this.content.equals(obj.getContent())) {
			 defString += "内容从" + this.content +"修改为" +obj.getContent();
		}

		if ( !Objects.equals(this.status , obj.getStatus())){
			defString += "状态从" + this.status + "修改为" + obj.getStatus();
		}

	   if(!this.memo.equals(obj.getMemo())) {
			 defString += "备注从" + this.memo +"修改为" +obj.getMemo();
		}


    }
}