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

/**RolePermission*/
public class RolePermission implements Serializable {

	@ApiModelProperty(value = "角色id")
	private Long roleId;

	@ApiModelProperty(value = "权限id")
	private Long permissionId;


    private static final long serialVersionUID = 1L;

	public Long getRoleId () {   
		return roleId;
	}
		
	public void setRoleId (Long roleId) {
		this.roleId= roleId ;
	}

	public Long getPermissionId () {   
		return permissionId;
	}
		
	public void setPermissionId (Long permissionId) {
		this.permissionId= permissionId ;
	}


	public void difference(RolePermission obj) {
		String defString = "";
		if (!Objects.equals(this.roleId,obj.getRoleId())){
			defString += "角色id从" + this.roleId + "修改为" + obj.getRoleId();
		}

		if (!Objects.equals(this.permissionId,obj.getPermissionId())){
			defString += "权限id从" + this.permissionId + "修改为" + obj.getPermissionId();
		}


    }
}