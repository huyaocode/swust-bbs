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

/**User*/
public class User implements Serializable {

	@ApiModelProperty(value = "")
	private Long id;
	
	@ApiModelProperty(value = "用户名(手机号)")
	private String username;

	@ApiModelProperty(value = "昵称(字符长度为1-255)")
	@Size(min=1, max=255,message="昵称字符长度为1-255")
	@Excel(name="昵称",orderNum="1")
	private String nickname;

	@ApiModelProperty(value = "手机(字符长度为1-255)")
	@Size(min=1, max=255,message="手机字符长度为1-255")
	@Excel(name="手机",orderNum="2")
	private String telephone;

	@ApiModelProperty(value = "密码(字符长度为1-255)")
	//@Size(min=1, max=255,message="密码字符长度为1-255")
	@Excel(name="密码",orderNum="3")
	private String password;

	@ApiModelProperty(value = "头像(字符长度为1-255)")
	@Size(min=1, max=255,message="头像字符长度为1-255")
	@Excel(name="头像",orderNum="4")
	private String headImgUrl;

	@ApiModelProperty(value = "生日")
	private Date birthday;

	@ApiModelProperty(value = "性别(字符长度为1-1)")
	@Size(min=1, max=1,message="性别字符长度为1-1")
	@Excel(name="性别",orderNum="6")
	private String sex;

	@ApiModelProperty(value = "状态：不可用 0;可用 1;锁定2;")
	private String status;

	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;

	@ApiModelProperty(value = "修改时间")
	private Timestamp updateTime;

	@ApiModelProperty(value = "个性签名(字符长度为1-255)")
	@Size(min=1, max=255,message="个性签名字符长度为1-255")
	@Excel(name="个性签名",orderNum="10")
	private String signature;

	@ApiModelProperty(value = "家乡(字符长度为1-255)")
	@Size(min=1, max=255,message="家乡字符长度为1-255")
	@Excel(name="家乡",orderNum="11")
	private String hometown;

	@ApiModelProperty(value = "角色id")
	private Long roleId;

	@ApiModelProperty(value = "学院(字符长度为1-255)")
	@Size(min=1, max=255,message="学院字符长度为1-255")
	@Excel(name="学院",orderNum="13")
	private String college;

	@ApiModelProperty(value = "专业(字符长度为1-255)")
	@Size(min=1, max=255,message="专业字符长度为1-255")
	@Excel(name="专业",orderNum="14")
	private String profession;

	@ApiModelProperty(value = "班级(字符长度为1-255)")
	@Size(min=1, max=255,message="班级字符长度为1-255")
	@Excel(name="班级",orderNum="15")
	private String classes;


    private static final long serialVersionUID = 1L;

	public Long getId () {   
		return id;
	}
		
	public void setId (Long id) {
		this.id= id ;
	}

    public String getNickname () {   
    	 return nickname;
    }

    public void setNickname (String nickname) {
    	 this.nickname= nickname == null ? null : nickname.trim();
    }

    public String getTelephone () {   
    	 return telephone;
    }

    public void setTelephone (String telephone) {
    	 this.telephone= telephone == null ? null : telephone.trim();
    }

    public String getPassword () {   
    	 return password;
    }

    public void setPassword (String password) {
    	 this.password= password == null ? null : password.trim();
    }

    public String getHeadImgUrl () {   
    	 return headImgUrl;
    }

    public void setHeadImgUrl (String headImgUrl) {
    	 this.headImgUrl= headImgUrl == null ? null : headImgUrl.trim();
    }

	public Date getBirthday () {   
	    return birthday;
	}

	public void setBirthday (Date birthday) {
	    this.birthday= birthday;
	}

    public String getSex () {   
    	 return sex;
    }

    public void setSex (String sex) {
    	 this.sex= sex == null ? null : sex.trim();
    }

    public String getSignature () {   
    	 return signature;
    }

    public void setSignature (String signature) {
    	 this.signature= signature == null ? null : signature.trim();
    }

    public String getHometown () {   
    	 return hometown;
    }

    public void setHometown (String hometown) {
    	 this.hometown= hometown == null ? null : hometown.trim();
    }

	public Long getRoleId () {   
		return roleId;
	}
		
	public void setRoleId (Long roleId) {
		this.roleId= roleId ;
	}

    public String getCollege () {   
    	 return college;
    }

    public void setCollege (String college) {
    	 this.college= college == null ? null : college.trim();
    }

    public String getProfession () {   
    	 return profession;
    }

    public void setProfession (String profession) {
    	 this.profession= profession == null ? null : profession.trim();
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

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public interface Status {
		String DISABLED = "0";
		String VALID = "1";
		String LOCKED = "2";
	}
	
	

	

	

    
}