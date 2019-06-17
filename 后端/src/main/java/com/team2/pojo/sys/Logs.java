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

/**Logs*/
public class Logs implements Serializable {

	@ApiModelProperty(value = "主键id")
	private Long id;

	@ApiModelProperty(value = "用户名")
	private Long userId;

	@ApiModelProperty(value = "模块名(字符长度为1-200)")
	@Size(min=1, max=200,message="模块名字符长度为1-200")
	@Excel(name="模块名",orderNum="2")
	private String module;

	@ApiModelProperty(value = "成功失败")
	private Integer flag;

	@ApiModelProperty(value = "备注")
	@Excel(name="备注",orderNum="4")
	private String memo;

	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;


    private static final long serialVersionUID = 1L;

	public Long getId () {   
		return id;
	}
		
	public void setId (Long id) {
		this.id= id ;
	}

	public Long getUserId () {   
		return userId;
	}
		
	public void setUserId (Long userId) {
		this.userId= userId ;
	}

    public String getModule () {   
    	 return module;
    }

    public void setModule (String module) {
    	 this.module= module == null ? null : module.trim();
    }

	public Integer getFlag () {   
		  return flag;
	}
	
	public void setFlag (Integer flag) {
		  this.flag= flag ;
	}

    public String getMemo () {   
    	 return memo;
    }

    public void setMemo (String memo) {
    	 this.memo= memo == null ? null : memo.trim();
    }


	public void difference(Logs obj) {
		String defString = "";
		if (!Objects.equals(this.id,obj.getId())){
			defString += "主键id从" + this.id + "修改为" + obj.getId();
		}

		if (!Objects.equals(this.userId,obj.getUserId())){
			defString += "用户名从" + this.userId + "修改为" + obj.getUserId();
		}

	   if(!this.module.equals(obj.getModule())) {
			 defString += "模块名从" + this.module +"修改为" +obj.getModule();
		}

		if ( !Objects.equals(this.flag , obj.getFlag())){
			defString += "成功失败从" + this.flag + "修改为" + obj.getFlag();
		}

	   if(!this.memo.equals(obj.getMemo())) {
			 defString += "备注从" + this.memo +"修改为" +obj.getMemo();
		}


    }
}