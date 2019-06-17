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

/**HotSearch*/
public class HotSearch implements Serializable {

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "热度名词(字符长度为1-255)")
	@Size(min=1, max=255,message="热度名词字符长度为1-255")
	private String hotWord;

	@ApiModelProperty(value = "搜索次数")
	private Long frequency;


    private static final long serialVersionUID = 1L;

	public Long getId () {   
		return id;
	}
		
	public void setId (Long id) {
		this.id= id ;
	}

    public String getHotWord () {   
    	 return hotWord;
    }

    public void setHotWord (String hotWord) {
    	 this.hotWord= hotWord == null ? null : hotWord.trim();
    }

	public Long getFrequency () {   
		return frequency;
	}
		
	public void setFrequency (Long frequency) {
		this.frequency= frequency ;
	}


	public void difference(HotSearch obj) {
		String defString = "";
		if (!Objects.equals(this.id,obj.getId())){
			defString += "从" + this.id + "修改为" + obj.getId();
		}

	   if(!this.hotWord.equals(obj.getHotWord())) {
			 defString += "热度名词从" + this.hotWord +"修改为" +obj.getHotWord();
		}

		if (!Objects.equals(this.frequency,obj.getFrequency())){
			defString += "搜索次数从" + this.frequency + "修改为" + obj.getFrequency();
		}


    }
}