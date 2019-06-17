package com.team2.service.sys.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.dao.sys.NoticeDao;
import com.team2.pojo.sys.Notice;
import com.team2.vo.sys.NoticeQuery;
import com.team2.service.sys.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	public NoticeDao noticeDao;
	@Override
	public Long delById(Long id) {
	   noticeDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Notice record) {
		noticeDao.save(record);
		return record.getId();
	}

	@Override
	public Notice getById(Long id) {
		return noticeDao.getById(id);
	}


	@Override
	public Long editById(Notice record) {
		noticeDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<Notice> list(int pagenum, int pagesize,NoticeQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Notice> datalist = noticeDao.list(param);
		PageInfo<Notice> resultPage = new PageInfo<Notice>(datalist);
		return resultPage;
	}

@Override
	public List<Notice> listAll(NoticeQuery param) {
		List<Notice> datalist = noticeDao.list(param);
		return datalist;
	}

}
