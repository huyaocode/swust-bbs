package com.team2.controller.cmt;
import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.team2.controller.base.BaseController;
import com.team2.pojo.ResultResponse;
import com.team2.pojo.base.BaseInfo;
import com.team2.pojo.base.BaseRecord;
import com.team2.pojo.base.CountInfo;
import com.team2.pojo.cmt.Information;
import com.team2.pojo.sys.User;
import com.team2.service.cmt.InformationService;
import com.team2.utils.FileNameUtil;
import com.team2.utils.FileUploadUtil;
import com.team2.utils.FileUtil;
import com.team2.utils.UUIDUtil;
import com.team2.utils.UserUtil;
import com.team2.vo.cmt.InformationQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "信息")
@RestController
@Validated
@RequestMapping("/information")
public class InformationController extends BaseController {

	@Autowired
	public InformationService informationService;
	
	@Value("${files.picpath}")
	private String filesPath;

	@ApiOperation(value="删除记录")
	@DeleteMapping(value="/del")
	public ResultResponse<Long> delById(@ApiParam(required=true,value="查询编号")
        @RequestBody BaseRecord recode) {
        Long count =informationService.delById(recode.getId());
        return new ResultResponse<Long>(count);
    }

    @ApiOperation(value="新增记录")
    @PostMapping(value="/add")
    public ResultResponse<Information> save(@ApiParam(required = true, value = "添加Information")@Valid
        @RequestBody Information record) {
        Long long1=informationService.save(record);
        return new ResultResponse<Information>(0,"ok", record);
    }

    @ApiOperation(value = "根据ID查询记录")
    @PutMapping(value = "/get")
    public ResultResponse<Information> getById(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
        Information record=informationService.getById(recode.getId());
        return new ResultResponse<Information>(record);
    }
    
    @ApiOperation(value = "设置信息已解决")
    @PutMapping(value = "/setResolved")
    public ResultResponse<String> setResolved(
    @ApiParam(required = true, value = "查询编号")
    @RequestBody @Valid BaseRecord recode) {
       Long id=informationService.setResolved(recode.getId());
       return new ResultResponse<String>(0,"设置成功");
    }

   // @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "封禁信息")
    @PutMapping(value = "/setBanned")
    public ResultResponse<String> setBanned(
            @ApiParam(required = true, value = "查询编号")
            @RequestBody @Valid BaseRecord recode) {
        Long id=informationService.setBanned(recode.getId());
        return new ResultResponse<String>(0,"封禁成功");
    }

    @ApiOperation(value = "修改内容")
    @PutMapping(value = "/edit")
    public ResultResponse<Information> editById(@ApiParam(required=true,value="修改Information") @Valid
        @RequestBody Information record) {
        informationService.editById(record);
        return new ResultResponse<Information>(0,"ok", record);
    }
    
    @ApiOperation(value = "获取我的发布的需求/资源信息")
    @PutMapping(value = "/getMyInfo")
    public ResultResponse<List<Information>> getMyInfo(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody BaseInfo info) {
        return new ResultResponse<List<Information>>(
            informationService.getMyInfo(info));
    }

    @ApiOperation(value = "详细列表查询")
    @PutMapping(value = "/list")
    public ResultResponse<PageInfo<Information>> list(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody InformationQuery param) {
        return new ResultResponse<PageInfo<Information>>(
            informationService.list(param.getPageNum(), param.getPageSize(), param));
    }
    
    @ApiOperation(value = "详细列表查询(包括分类信息)")
    @PutMapping(value = "/listDetail")
    public ResultResponse<PageInfo<Information>> listDetail(@ApiParam(required = false, value = "查询参数")
        @Valid @RequestBody InformationQuery param) {
        return new ResultResponse<PageInfo<Information>>(
            informationService.listDetail(param.getPageNum(), param.getPageSize(), param));
    }
    
    @ApiOperation(value = "获取统计数据")
    @PutMapping(value = "/getCountInfo")
    public ResultResponse<CountInfo> getCountInfo() {
        return new ResultResponse<CountInfo>(
            informationService.getCountInfo());
    }
    
    @ApiOperation(value = "上传图片")
	@PostMapping(value = "/imgUpdate")
	public ResultResponse<String> imgUpdate(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		String fileOrigName = file.getOriginalFilename();
		if (!fileOrigName.contains(".")) {
			throw new IllegalArgumentException("Lack of suffix name.");
		}
		//文件存储位置
        ServletContext scontext = request.getSession().getServletContext();
        // 获取绝对路径
        String path = scontext.getRealPath("") + "pictures";
 

		fileOrigName = fileOrigName.substring(fileOrigName.lastIndexOf("."));
		String pathname = "/"+UUIDUtil.getUUID() +fileOrigName;

		String fullPath = path + pathname;
		FileUtil.saveFile(file, fullPath);

		return new ResultResponse<>(0, fullPath);

	}
    @ApiOperation("图片上传(新)")
    @PostMapping(value="/uploadImg")
    public ResultResponse<String> upload(@RequestParam("file")MultipartFile file,HttpServletRequest request) {
        //定义要上传文件 的存放路径
        String localPath="D:/bbs/";
        //获得文件名字
        String fileName=file.getOriginalFilename();
        fileName= FileNameUtil.getFileName(fileName);
        File dest = new File(localPath + fileName);
        if(FileUploadUtil.upload(file, localPath, fileName)){
            // 将上传的文件写入到服务器端文件夹
            // 获取当前项目运气的完整url
            String requestURL = request.getRequestURL().toString();
            // 获取当前项目的请求路径url
            String requestURI = request.getRequestURI();
            // 得到去掉了url的路径
            String url = requestURL.substring(0, requestURL.length()-requestURI.length() + 1);
            url="statics/"+ fileName;

            
            return new ResultResponse<>(0, url);

        }       
        // 返回
        return new ResultResponse<>(-1,"未知错误导致上传失败");
    }


}
