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

/**Category*/
public class Category implements Serializable {

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "分类名称(字符长度为1-255)")
	@Size(min=1, max=255,message="分类名称字符长度为1-255")
	private String name;

	@ApiModelProperty(value = "类型0：需求1：资源(字符长度为1-1)")
	@Size(min=1, max=1,message="类型0：需求1：资源字符长度为1-1")
	private String type;


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

    public String getType () {   
    	 return type;
    }

    public void setType (String type) {
    	 this.type= type == null ? null : type.trim();
    }


	public void difference(Category obj) {
		String defString = "";
		if (!Objects.equals(this.id,obj.getId())){
			defString += "从" + this.id + "修改为" + obj.getId();
		}

	   if(!this.name.equals(obj.getName())) {
			 defString += "分类名称从" + this.name +"修改为" +obj.getName();
		}

	   if(!this.type.equals(obj.getType())) {
			 defString += "类型0：需求1：资源从" + this.type +"修改为" +obj.getType();
		}


    }
}