package com.team2.service.sys.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.dao.sys.PermissionDao;
import com.team2.pojo.sys.Permission;
import com.team2.vo.sys.PermissionQuery;
import com.team2.service.sys.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	public PermissionDao permissionDao;
	@Override
	public Long delById(Long id) {
	   permissionDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Permission record) {
		permissionDao.save(record);
		return record.getId();
	}

	@Override
	public Permission getById(Long id) {
		return permissionDao.getById(id);
	}


	@Override
	public Long editById(Permission record) {
		permissionDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<Permission> list(int pagenum, int pagesize,PermissionQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Permission> datalist = permissionDao.list(param);
		PageInfo<Permission> resultPage = new PageInfo<Permission>(datalist);
		return resultPage;
	}

@Override
	public List<Permission> listAll(PermissionQuery param) {
		List<Permission> datalist = permissionDao.list(param);
		return datalist;
	}

}
