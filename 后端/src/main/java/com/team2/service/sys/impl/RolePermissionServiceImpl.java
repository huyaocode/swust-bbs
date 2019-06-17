package com.team2.service.sys.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.dao.sys.RolePermissionDao;
import com.team2.pojo.sys.Permission;
import com.team2.pojo.sys.RolePermission;
import com.team2.vo.sys.RolePermissionQuery;
import com.team2.service.sys.RolePermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class RolePermissionServiceImpl implements RolePermissionService{

	@Autowired
	public RolePermissionDao rolePermissionDao;
	@Override
	public Long delById(Long id) {
	   rolePermissionDao.delById(id);
	   return id;
	}

	@Override
	public Long save(RolePermission record) {
		rolePermissionDao.save(record);
		return record.getRoleId();
	}

	@Override
	public RolePermission getById(Long id) {
		return rolePermissionDao.getById(id);
	}


	@Override
	public Long editById(RolePermission record) {
		rolePermissionDao.editById(record);
		return record.getRoleId();
	}

	@Override
	public PageInfo<RolePermission> list(int pagenum, int pagesize,RolePermissionQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<RolePermission> datalist = rolePermissionDao.list(param);
		PageInfo<RolePermission> resultPage = new PageInfo<RolePermission>(datalist);
		return resultPage;
	}

@Override
	public List<RolePermission> listAll(RolePermissionQuery param) {
		List<RolePermission> datalist = rolePermissionDao.list(param);
		return datalist;
	}

@Override
public List<Permission> listByRoleId(Long id) {
	List<Permission>permissions=rolePermissionDao.listByRoleId(id);
	return permissions;
}

}
