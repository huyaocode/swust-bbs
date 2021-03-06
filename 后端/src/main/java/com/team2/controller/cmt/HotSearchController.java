package com.team2.controller.cmt;
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
import com.team2.pojo.base.SearchInfo;
import com.team2.pojo.cmt.HotSearch;
import com.team2.pojo.cmt.Information;
import com.team2.service.cmt.HotSearchService;
import com.team2.vo.cmt.HotSearchQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "热度搜索")
@RestController
@Validated
@RequestMapping("/hotSearch")
public class HotSearchController extends BaseController {

	@Autowired
	public HotSearchService hotSearchService;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =hotSearchService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<HotSearch> save(@ApiParam(required = true, value = "添加HotSearch")@Valid
        @RequestBody HotSearch record) {
        hotSearchService.save(record);
        return new ResultResponse<HotSearch>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<HotSearch> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        HotSearch record=hotSearchService.getById(recode.getId());
        return new ResultResponse<HotSearch>(record);
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<HotSearch> editById(@ApiParam(required=true,value="修改HotSearch") @Valid
        @RequestBody HotSearch record) {
        hotSearchService.editById(record);
        return new ResultResponse<HotSearch>(0,"ok", record);
    }
    
    @ApiOperation(value = "搜索")
    @PutMapping(value = "/doSearch")
    public ResultResponse<PageInfo<Information>> doSearch(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody SearchInfo info) {
        return new ResultResponse<PageInfo<Information>>(
            hotSearchService.doSearch(info));
    }
    

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageInfo<HotSearch>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody HotSearchQuery param) {
        return new ResultResponse<PageInfo<HotSearch>>(
            hotSearchService.list(param.getPageNum(), param.getPageSize(), param));
    }

}
