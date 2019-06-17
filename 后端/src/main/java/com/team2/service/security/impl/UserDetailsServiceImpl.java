package com.team2.service.security.impl;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.team2.dao.sys.PermissionDao;
import com.team2.dao.sys.RolePermissionDao;
import com.team2.pojo.sys.LoginUser;
import com.team2.pojo.sys.Permission;
import com.team2.pojo.sys.User;
import com.team2.service.sys.UserService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private RolePermissionDao rolePermissionDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userService.getByUsername(username);
		if(user==null)
			throw new AuthenticationCredentialsNotFoundException("用户不存在");
		else  if(user.getStatus().equals("0"))
			throw new DisabledException("用户已作废");
		LoginUser loginUser=new LoginUser();
		BeanUtils.copyProperties(user, loginUser);
		
		//List<Permission>permissions=rolePermissionDao.listByRoleId(user.getRoleId());
		//loginUser.setPermissions(permissions);
		return loginUser;
	}

}
