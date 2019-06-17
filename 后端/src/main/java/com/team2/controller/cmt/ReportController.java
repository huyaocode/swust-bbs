package com.team2.controller.cmt;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.team2.pojo.base.ReportInfo;
import com.team2.pojo.cmt.Report;
import com.team2.service.cmt.ReportService;
import com.team2.vo.cmt.ReportQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "举报")
@RestController
@Validated
@RequestMapping("/report")
public class ReportController extends BaseController {

	@Autowired
	public ReportService reportService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =reportService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Report> save(@ApiParam(required = true, value = "添加Report")@Valid
        @RequestBody Report record) {
        reportService.save(record);
        return new ResultResponse<Report>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Report> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Report record=reportService.getById(recode.getId());
        return new ResultResponse<Report>(record);
    }
    
   // @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "1：封禁:0：不封禁")
    @PutMapping(value = "/setBanned")
    public ResultResponse<Long> setBanned(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid ReportInfo recode) {
        reportService.setBanned(recode);
        return new ResultResponse<Long>(recode.getId());
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Report> editById(@ApiParam(required=true,value="修改Report") @Valid
        @RequestBody Report record) {
        reportService.editById(record);
        return new ResultResponse<Report>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageInfo<Report>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody ReportQuery param) {
        return new ResultResponse<PageInfo<Report>>(
            reportService.list(param.getPageNum(), param.getPageSize(), param));
    }

}
