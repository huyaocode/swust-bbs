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

/**Collection*/
public class Collection implements Serializable {

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "信息id")
	private Long informationId;

	@ApiModelProperty(value = "用户id")
	private Long userId;

	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;


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


	public void difference(Collection obj) {
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


    }
}