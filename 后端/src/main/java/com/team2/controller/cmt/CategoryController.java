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
import com.team2.pojo.cmt.Category;
import com.team2.service.cmt.CategoryService;
import com.team2.vo.cmt.CategoryQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "分类")
@RestController
@Validated
@RequestMapping("/category")
public class CategoryController extends BaseController {

	@Autowired
	public CategoryService categoryService;

	//@PreAuthorize("hasAuthority('ADMIN')")
	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =categoryService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

	//@PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Category> save(@ApiParam(required = true, value = "添加Category")@Valid
        @RequestBody Category record) {
        categoryService.save(record);
        return new ResultResponse<Category>(0,"ok", record);
    }

	
    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Category> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Category record=categoryService.getById(recode.getId());
        return new ResultResponse<Category>(record);
    }

   // @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Category> editById(@ApiParam(required=true,value="修改Category") @Valid
        @RequestBody Category record) {
        categoryService.editById(record);
        return new ResultResponse<Category>(0,"ok", record);
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageInfo<Category>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody CategoryQuery param) {
        return new ResultResponse<PageInfo<Category>>(
            categoryService.list(param.getPageNum(), param.getPageSize(), param));
    }


}
