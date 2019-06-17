package com.team2.controller.sys;
import java.util.List;
import javax.validation.Valid;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.team2.vo.sys.RolePermissionQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
//
import com.github.pagehelper.PageInfo;
import com.team2.controller.base.BaseController;
import com.team2.pojo.ResultResponse;
import com.team2.pojo.base.BaseRecord;
import com.team2.pojo.sys.RolePermission;
import com.team2.service.sys.RolePermissionService;
@Api(tags = "RolePermission")
@RestController
@Validated
@RequestMapping("/rolePermission")
public class RolePermissionController extends BaseController {
//
	@Autowired
	public RolePermissionService rolePermissionService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =rolePermissionService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }
//
    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<RolePermission> save(@ApiParam(required = true, value = "添加RolePermission")@Valid
        @RequestBody RolePermission record) {
        rolePermissionService.save(record);
        return new ResultResponse<RolePermission>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<RolePermission> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        RolePermission record=rolePermissionService.getById(recode.getId());
        return new ResultResponse<RolePermission>(record);
    }
//
    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<RolePermission> editById(@ApiParam(required=true,value="修改RolePermission") @Valid
        @RequestBody RolePermission record) {
        rolePermissionService.editById(record);
        return new ResultResponse<RolePermission>(0,"ok", record);
    }
//
    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageInfo<RolePermission>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody RolePermissionQuery param) {
        return new ResultResponse<PageInfo<RolePermission>>(
            rolePermissionService.list(param.getPageNum(), param.getPageSize(), param));
    }


}
