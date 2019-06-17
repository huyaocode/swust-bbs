package com.team2.service.sys.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.dao.sys.LogsDao;
import com.team2.pojo.sys.Logs;
import com.team2.vo.sys.LogsQuery;
import com.team2.service.sys.LogsService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class LogsServiceImpl implements LogsService{

	@Autowired
	public LogsDao logsDao;
	@Override
	public Long delById(Long id) {
	   logsDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Logs record) {
		logsDao.save(record);
		return record.getId();
	}

	@Override
	public Logs getById(Long id) {
		return logsDao.getById(id);
	}


	@Override
	public Long editById(Logs record) {
		logsDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<Logs> list(int pagenum, int pagesize,LogsQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Logs> datalist = logsDao.list(param);
		PageInfo<Logs> resultPage = new PageInfo<Logs>(datalist);
		return resultPage;
	}

@Override
	public List<Logs> listAll(LogsQuery param) {
		List<Logs> datalist = logsDao.list(param);
		return datalist;
	}

}
