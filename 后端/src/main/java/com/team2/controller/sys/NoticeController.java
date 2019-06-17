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
import com.team2.pojo.sys.Notice;
import com.team2.service.sys.NoticeService;
import com.team2.vo.sys.NoticeQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "公告")
@RestController
@Validated
@RequestMapping("/notice")
public class NoticeController extends BaseController {

	@Autowired
	public NoticeService noticeService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =noticeService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Notice> save(@ApiParam(required = true, value = "添加Notice")@Valid
        @RequestBody Notice record) {
        noticeService.save(record);
        return new ResultResponse<Notice>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Notice> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Notice record=noticeService.getById(recode.getId());
        return new ResultResponse<Notice>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Notice> editById(@ApiParam(required=true,value="修改Notice") @Valid
        @RequestBody Notice record) {
        noticeService.editById(record);
        return new ResultResponse<Notice>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageInfo<Notice>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody NoticeQuery param) {
        return new ResultResponse<PageInfo<Notice>>(
            noticeService.list(param.getPageNum(), param.getPageSize(), param));
    }


}
