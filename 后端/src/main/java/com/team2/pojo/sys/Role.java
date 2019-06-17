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

/**Role*/
public class Role implements Serializable {

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "用户身份(字符长度为1-50)")
	@Size(min=1, max=50,message="用户身份字符长度为1-50")
	@Excel(name="用户身份",orderNum="1")
	private String name;

	@ApiModelProperty(value = "描述(字符长度为1-100)")
	@Size(min=1, max=100,message="描述字符长度为1-100")
	@Excel(name="描述",orderNum="2")
	private String description;

	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;

	@ApiModelProperty(value = "更新时间")
	private Timestamp updateTime;

	@ApiModelProperty(value = "备注(字符长度为1-255)")
	@Size(min=1, max=255,message="备注字符长度为1-255")
	@Excel(name="备注",orderNum="5")
	private String memo;


    private static final long serialVersionUID = 1L;

	public Long getId () {   
		return id;
	}
		
	public void setId (Long id) {
		this.id= id ;
	}

    public String getName () {   
    	 return name;
    }

    public void setName (String name) {
    	 this.name= name == null ? null : name.trim();
    }

    public String getDescription () {   
    	 return description;
    }

    public void setDescription (String description) {
    	 this.description= description == null ? null : description.trim();
    }

    public String getMemo () {   
    	 return memo;
    }

    public void setMemo (String memo) {
    	 this.memo= memo == null ? null : memo.trim();
    }


	public void difference(Role obj) {
		String defString = "";
		if (!Objects.equals(this.id,obj.getId())){
			defString += "从" + this.id + "修改为" + obj.getId();
		}

	   if(!this.name.equals(obj.getName())) {
			 defString += "用户身份从" + this.name +"修改为" +obj.getName();
		}

	   if(!this.description.equals(obj.getDescription())) {
			 defString += "描述从" + this.description +"修改为" +obj.getDescription();
		}

	   if(!this.memo.equals(obj.getMemo())) {
			 defString += "备注从" + this.memo +"修改为" +obj.getMemo();
		}


    }
}