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
import com.team2.pojo.sys.Logs;
import com.team2.service.sys.LogsService;
import com.team2.vo.sys.LogsQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "日志")
@RestController
@Validated
@RequestMapping("/logs")
public class LogsController extends BaseController {

	@Autowired
	public LogsService logsService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =logsService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Logs> save(@ApiParam(required = true, value = "添加Logs")@Valid
        @RequestBody Logs record) {
        logsService.save(record);
        return new ResultResponse<Logs>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Logs> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Logs record=logsService.getById(recode.getId());
        return new ResultResponse<Logs>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Logs> editById(@ApiParam(required=true,value="修改Logs") @Valid
        @RequestBody Logs record) {
        logsService.editById(record);
        return new ResultResponse<Logs>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageInfo<Logs>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody LogsQuery param) {
        return new ResultResponse<PageInfo<Logs>>(
            logsService.list(param.getPageNum(), param.getPageSize(), param));
    }


}
