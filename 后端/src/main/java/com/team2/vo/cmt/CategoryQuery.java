package com.team2.vo.cmt;

import com.team2.vo.base.BaseParamQuery;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class CategoryQuery extends BaseParamQuery{
    @ApiModelProperty(value = "类型0：需求1：资源(字符长度为1-1)")
    @Size(min=1, max=1,message="类型0：需求1：资源字符长度为1-1")
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}