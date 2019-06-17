package com.team2.controller.sys;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.team2.controller.base.BaseController;
import com.team2.pojo.ResultResponse;
import com.team2.pojo.base.BaseRecord;
import com.team2.pojo.sys.Permission;
import com.team2.service.sys.PermissionService;
import com.team2.vo.sys.PermissionQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "权限")
@RestController
@Validated
@RequestMapping("/permission")

public class PermissionController extends BaseController {

	@Autowired
	public PermissionService permissionService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =permissionService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Permission> save(@ApiParam(required = true, value = "添加Permission")@Valid
        @RequestBody Permission record) {
        permissionService.save(record);
        return new ResultResponse<Permission>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Permission> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Permission record=permissionService.getById(recode.getId());
        return new ResultResponse<Permission>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Permission> editById(@ApiParam(required=true,value="修改Permission") @Valid
        @RequestBody Permission record) {
        permissionService.editById(record);
        return new ResultResponse<Permission>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageInfo<Permission>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody PermissionQuery param) {
        return new ResultResponse<PageInfo<Permission>>(
            permissionService.list(param.getPageNum(), param.getPageSize(), param));
    }


}
