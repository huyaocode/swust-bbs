package com.team2.service.sys.impl;

import java.util.List;

import org.apache.poi.hssf.record.OldCellRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.team2.dao.sys.UserDao;
import com.team2.pojo.base.LoginInfo;
import com.team2.pojo.base.UserInfo;
import com.team2.pojo.sys.User;
import com.team2.vo.sys.UserQuery;

import com.team2.service.sys.UserService;
import com.team2.utils.UUIDUtil;
import com.team2.utils.UserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Long delById(Long id) {
		userDao.delById(id);
		return id;
	}

	@Override
	public Long save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoleId(2L);
		user.setStatus("1");

//		SysUser i = UserUtil.getLoginUser();

//		int id=userDao.save(user);
//		 userDao.setUserRole((long)id,(long)user.getRoleId());
		userDao.save(user);
		return user.getId();
	}

	@Override
	public User getUser() {
		User user = UserUtil.getLoginUser();
		return userDao.getById(user.getId());
	}

	@Override
	public User getUserById(Long id) {
		User user = userDao.getById(id);
		return user;
	}

	@Override
	public Long editById(User record) {
		User loginUser = UserUtil.getLoginUser();
		if (record.getRoleId() == null)
			record.setRoleId(loginUser.getRoleId());
		record.setId(loginUser.getId());
		record.setStatus("1");
		userDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<User> list(int pagenum, int pagesize, UserQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<User> datalist = userDao.list(param);
		PageInfo<User> resultPage = new PageInfo<User>(datalist);
		return resultPage;
	}

	@Override
	public User getByUsername(String username) {
		User user = userDao.getByUsername(username);
		return user;
	}

	@Override
	public List<User> listAll(UserQuery param) {
		List<User> datalist = userDao.list(param);
		return datalist;
	}

	@Override
	public int setHeadImg(String headUrl, Long id) {
		int l = userDao.setHeadImg(headUrl, id);
		return l;
	}

	@Override
	public Long lockUser(Long id) {
		userDao.lockUser(id);
		return id;
	}

	@Override
	public Long unlockUser(Long id) {
		userDao.unlockUser(id);
		return id;
	}

	@Override
	public String editPassword(UserInfo record) {
		User user = UserUtil.getLoginUser();
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
		if (passwordEncoder.matches(record.getOldPassword(), user.getPassword())) {
			record.setNewPassword(passwordEncoder.encode(record.getNewPassword()));
			userDao.editPassword(record.getNewPassword(),user.getId());
		} else {
			return "密码不正确";
		}

		return "修改成功";
	}

}
