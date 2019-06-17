package com.team2.pojo.cmt;

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

/**Report*/
public class Report implements Serializable {

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "信息id")
	private Long informationId;

	@ApiModelProperty(value = "用户id")
	private Long userId;

	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;

	@ApiModelProperty(value = "修改时间")
	private Timestamp updateTime;

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

	@ApiModelProperty(value = "备注(字符长度为1-255)")
	@Size(min=1, max=255,message="备注字符长度为1-255")
	private String memo;

	@ApiModelProperty(value = "信息状态0：未审核1：已审核(字符长度为1-1)")
	@Size(min=1, max=1,message="信息状态0：未审核1：已审核字符长度为1-1")
	private String status;


    private static final long serialVersionUID = 1L;

	public Long getId () {   
		return id;
	}
		
	public void setId (Long id) {
		this.id= id ;
	}

	public Long getInformationId () {   
		return informationId;
	}
		
	public void setInformationId (Long informationId) {
		this.informationId= informationId ;
	}

	public Long getUserId () {   
		return userId;
	}
		
	public void setUserId (Long userId) {
		this.userId= userId ;
	}

    public String getMemo () {   
    	 return memo;
    }

    public void setMemo (String memo) {
    	 this.memo= memo == null ? null : memo.trim();
    }

    public String getStatus () {   
    	 return status;
    }

    public void setStatus (String status) {
    	 this.status= status == null ? null : status.trim();
    }


	public void difference(Report obj) {
		String defString = "";
		if (!Objects.equals(this.id,obj.getId())){
			defString += "从" + this.id + "修改为" + obj.getId();
		}

		if (!Objects.equals(this.informationId,obj.getInformationId())){
			defString += "信息id从" + this.informationId + "修改为" + obj.getInformationId();
		}

		if (!Objects.equals(this.userId,obj.getUserId())){
			defString += "用户id从" + this.userId + "修改为" + obj.getUserId();
		}

	   if(!this.memo.equals(obj.getMemo())) {
			 defString += "备注从" + this.memo +"修改为" +obj.getMemo();
		}

	   if(!this.status.equals(obj.getStatus())) {
			 defString += "信息状态0：未审核1：已审核从" + this.status +"修改为" +obj.getStatus();
		}


    }
}