package com.team2.service.sys.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.dao.sys.RoleDao;
import com.team2.pojo.sys.Role;
import com.team2.vo.sys.RoleQuery;
import com.team2.service.sys.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	public RoleDao roleDao;
	@Override
	public Long delById(Long id) {
	   roleDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Role record) {
		roleDao.save(record);
		return record.getId();
	}

	@Override
	public Role getById(Long id) {
		return roleDao.getById(id);
	}


	@Override
	public Long editById(Role record) {
		roleDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<Role> list(int pagenum, int pagesize,RoleQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Role> datalist = roleDao.list(param);
		PageInfo<Role> resultPage = new PageInfo<Role>(datalist);
		return resultPage;
	}

@Override
	public List<Role> listAll(RoleQuery param) {
		List<Role> datalist = roleDao.list(param);
		return datalist;
	}

}
