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

/**Permission*/
public class Permission implements Serializable {

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "")
	private Long parentId;

	@ApiModelProperty(value = "名称(字符长度为1-50)")
	@Size(min=1, max=50,message="名称字符长度为1-50")
	@Excel(name="名称",orderNum="2")
	private String name;

	@ApiModelProperty(value = "权限(字符长度为1-50)")
	@Size(min=1, max=50,message="权限字符长度为1-50")
	@Excel(name="权限",orderNum="3")
	private String permission;

	@ApiModelProperty(value = "种类")
	private Long sort;

	@ApiModelProperty(value = "路由(字符长度为1-255)")
	@Size(min=1, max=255,message="路由字符长度为1-255")
	@Excel(name="路由",orderNum="5")
	private String route;


    private static final long serialVersionUID = 1L;

	public Long getId () {   
		return id;
	}
		
	public void setId (Long id) {
		this.id= id ;
	}

	public Long getParentId () {   
		return parentId;
	}
		
	public void setParentId (Long parentId) {
		this.parentId= parentId ;
	}

    public String getName () {   
    	 return name;
    }

    public void setName (String name) {
    	 this.name= name == null ? null : name.trim();
    }

    public String getPermission () {   
    	 return permission;
    }

    public void setPermission (String permission) {
    	 this.permission= permission == null ? null : permission.trim();
    }

	public Long getSort () {   
		return sort;
	}
		
	public void setSort (Long sort) {
		this.sort= sort ;
	}

    public String getRoute () {   
    	 return route;
    }

    public void setRoute (String route) {
    	 this.route= route == null ? null : route.trim();
    }


	public void difference(Permission obj) {
		String defString = "";
		if (!Objects.equals(this.id,obj.getId())){
			defString += "从" + this.id + "修改为" + obj.getId();
		}

		if (!Objects.equals(this.parentId,obj.getParentId())){
			defString += "从" + this.parentId + "修改为" + obj.getParentId();
		}

	   if(!this.name.equals(obj.getName())) {
			 defString += "名称从" + this.name +"修改为" +obj.getName();
		}

	   if(!this.permission.equals(obj.getPermission())) {
			 defString += "权限从" + this.permission +"修改为" +obj.getPermission();
		}

		if (!Objects.equals(this.sort,obj.getSort())){
			defString += "种类从" + this.sort + "修改为" + obj.getSort();
		}

	   if(!this.route.equals(obj.getRoute())) {
			 defString += "路由从" + this.route +"修改为" +obj.getRoute();
		}


    }
}