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
import com.team2.pojo.sys.Role;
import com.team2.service.sys.RoleService;
import com.team2.vo.sys.RoleQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "角色")
@RestController
@Validated
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	public RoleService roleService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =roleService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Role> save(@ApiParam(required = true, value = "添加Role")@Valid
        @RequestBody Role record) {
        roleService.save(record);
        return new ResultResponse<Role>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Role> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Role record=roleService.getById(recode.getId());
        return new ResultResponse<Role>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Role> editById(@ApiParam(required=true,value="修改Role") @Valid
        @RequestBody Role record) {
        roleService.editById(record);
        return new ResultResponse<Role>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageInfo<Role>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody RoleQuery param) {
        return new ResultResponse<PageInfo<Role>>(
            roleService.list(param.getPageNum(), param.getPageSize(), param));
    }


}
