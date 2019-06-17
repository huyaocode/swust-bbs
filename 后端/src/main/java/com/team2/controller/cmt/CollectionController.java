package com.team2.controller.cmt;

import java.util.List;

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
import com.team2.pojo.base.BaseInfo;
import com.team2.pojo.base.BaseRecord;
import com.team2.pojo.cmt.Collection;
import com.team2.pojo.cmt.Information;
import com.team2.service.cmt.CollectionService;
import com.team2.vo.cmt.CollectionQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "收藏")
@RestController
@Validated
@RequestMapping("/collection")
public class CollectionController extends BaseController {

	@Autowired
	public CollectionService collectionService;

	@ApiOperation(value = "删除记录")
	@DeleteMapping(value = "/del")
	public ResultResponse<Long> delById(@ApiParam(required = true, value = "查询编号") @RequestBody BaseRecord recode) {
		Long count = collectionService.delById(recode.getId());
		return new ResultResponse<Long>(count);
	}

	@ApiOperation(value = "新增记录")
	@PostMapping(value = "/add")
	public ResultResponse<Collection> save(
			@ApiParam(required = true, value = "添加Collection") @Valid @RequestBody Collection record) {
		Long l = collectionService.save(record);
		if (l > 0L) {
			return new ResultResponse<Collection>(0, "ok", record);
		} else {
			return new ResultResponse<Collection>(-1, "该条信息已收藏，不能收藏", record);
		}
	}

	@ApiOperation(value = "根据ID查询记录")
	@PutMapping(value = "/get")
	public ResultResponse<Collection> getById(
			@ApiParam(required = true, value = "查询编号") @RequestBody @Valid BaseRecord recode) {
		Collection record = collectionService.getById(recode.getId());
		return new ResultResponse<Collection>(record);
	}

	@ApiOperation(value = "修改内容")
	@PutMapping(value = "/edit")
	public ResultResponse<Collection> editById(
			@ApiParam(required = true, value = "修改Collection") @Valid @RequestBody Collection record) {
		Long l = collectionService.editById(record);
		return new ResultResponse<Collection>(0, "ok", record);
	}

	@ApiOperation(value = "详细列表查询")
	@PutMapping(value = "/list")
	public ResultResponse<PageInfo<Collection>> list(
			@ApiParam(required = false, value = "查询参数") @Valid @RequestBody CollectionQuery param) {
		return new ResultResponse<PageInfo<Collection>>(
				collectionService.list(param.getPageNum(), param.getPageSize(), param));
	}

	@ApiOperation(value = "获取我的收藏信息")
	@PutMapping(value = "/getMyCollection")
	public ResultResponse<List<Information>> getMyCollection() {
		return new ResultResponse<List<Information>>(collectionService.getMyCollection());
	}

}
