package com.team2.controller.sys;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.team2.service.cmt.IMService;
import org.apache.tomcat.util.bcel.Const;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.team2.controller.base.BaseController;
import com.team2.dao.sys.UserDao;
import com.team2.pojo.ResultResponse;
import com.team2.pojo.base.BaseRecord;
import com.team2.pojo.base.UserInfo;
import com.team2.pojo.sys.User;
import com.team2.service.sys.UserService;
import com.team2.utils.FileNameUtil;
import com.team2.utils.FileUploadUtil;
import com.team2.utils.FileUtil;
import com.team2.utils.UUIDUtil;
import com.team2.utils.UserUtil;
import com.team2.vo.sys.UserQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "用户")
@RestController
@Validated
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	public UserService userService;
	@Autowired
	public UserDao userDao;

	@Autowired
	public IMService imService;
	@Value("${files.path}")
	private String filesPath;

	@ApiOperation(value = "删除记录")
	@DeleteMapping(value = "/del")
	public ResultResponse<Long> delById(@ApiParam(required = true, value = "查询编号") @RequestBody BaseRecord recode) {
		Long count = userService.delById(recode.getId());
		return new ResultResponse<Long>(count);
	}

	@ApiOperation(value = "新增记录")
	@PostMapping(value = "/add")
	public ResultResponse<User> save(@ApiParam(required = true, value = "添加User") @Valid @RequestBody User record) {
		Long accid = userService.save(record);
		int status=imService.CreateAccount(accid.toString(),record.getNickname());
		return new ResultResponse<User>(status, "ok", record);
	}

	@ApiOperation(value = "根据ID查询记录")
	@PutMapping(value = "/get")
	public ResultResponse<User> getById() {
		User record = userService.getUser();
		return new ResultResponse<User>(record);
	}
	
	@ApiOperation(value = "获取用户信息")
	@PutMapping(value = "/getUserInfo")
	public ResultResponse<User> getByUserId(@ApiParam(required = true, value = "user的id") @RequestBody BaseRecord recode) {
		User record = userService.getUserById(recode.getId());
		return new ResultResponse<User>(record);
	}

	@ApiOperation(value = "修改内容")
	@PutMapping(value = "/edit")
	public ResultResponse<User> editById(@ApiParam(required = true, value = "修改User") @Valid @RequestBody User record) {
		userService.editById(record);
		return new ResultResponse<User>(0, "ok", record);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@ApiOperation(value = "封禁用户")
	@PutMapping(value = "/lockUser")
	public ResultResponse<Long> lockUser(@ApiParam(required = true, value = "User的id") @Valid @RequestBody BaseRecord record) {
		userService.lockUser(record.getId());
		return new ResultResponse<Long>(0, "ok", record.getId());
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@ApiOperation(value = "解除封禁")
	@PutMapping(value = "/unlockUser")
	public ResultResponse<Long> unlockUser(@ApiParam(required = true, value = "User的id") @Valid @RequestBody BaseRecord record) {
		userService.unlockUser(record.getId());
		return new ResultResponse<Long>(0, "ok", record.getId());
	}

	@ApiOperation(value = "详细列表查询")
	@PutMapping(value = "/list")
	public ResultResponse<PageInfo<User>> list(
			@ApiParam(required = false, value = "查询参数") @Valid @RequestBody UserQuery param) {
		return new ResultResponse<PageInfo<User>>(userService.list(param.getPageNum(), param.getPageSize(), param));
	}
	
	@ApiOperation(value = "修改密码")
	@PutMapping(value = "/editPassword")
	public ResultResponse<String> editPassword(
			@ApiParam(required = false, value = "查询参数") @Valid @RequestBody UserInfo info) {
		String s=userService.editPassword(info);
		return new ResultResponse<String>(0,s);
	}

	@ApiOperation(value = "上传头像")
	@PostMapping(value = "/imgUpdate")
	public ResultResponse<String> imgUpdate(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		String fileOrigName = file.getOriginalFilename();
		if (!fileOrigName.contains(".")) {
			throw new IllegalArgumentException("Lack of suffix name.");
		}
		//文件存储位置
        ServletContext scontext = request.getSession().getServletContext();
        // 获取绝对路径
        String path = scontext.getRealPath("") + "portrait";
//        System.out.println(path);

		fileOrigName = fileOrigName.substring(fileOrigName.lastIndexOf("."));
//		System.out.println(fileOrigName);
		String pathname = "/"+UUIDUtil.getUUID() +fileOrigName;
//		String fullPath = filesPath + pathname;
		String fullPath = path + pathname;
		System.out.println(fullPath);
		FileUtil.saveFile(file, fullPath);

		User user = UserUtil.getLoginUser();
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		userService.setHeadImg(fullPath, user.getId());

		return new ResultResponse<>(0, fullPath);

	}
	@ApiOperation("头像上传(新)")
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

            User user = UserUtil.getLoginUser();
    		System.out.println(user.getId());
    		System.out.println(user.getUsername());
    		userService.setHeadImg(url, user.getId());

            return new ResultResponse<>(0, url);

        }       
        // 返回
        return new ResultResponse<>(-1,"未知错误导致上传失败");
    }

}
