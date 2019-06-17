package com.team2.service.cmt.impl;

import java.util.Date;
import java.util.List;

import com.team2.dao.sys.UserDao;
import com.team2.pojo.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team2.dao.cmt.CollectionDao;
import com.team2.dao.cmt.InformationDao;
import com.team2.dao.cmt.ReportDao;
import com.team2.pojo.base.BaseInfo;
import com.team2.pojo.base.CountInfo;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.InformationQuery;
import com.team2.service.cmt.InformationService;
import com.team2.utils.UserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class InformationServiceImpl implements InformationService{

	@Autowired
	public InformationDao informationDao;
	@Autowired
	public ReportDao  reportDao;
	@Autowired
	public UserDao userDao;
	@Autowired
	public CollectionDao collectionDao;
	@Override
	@Transactional
	public Long delById(Long id) {
	   reportDao.delByInfoId(id);
	   collectionDao.delByInfoId(id);
	   informationDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Information record) {
		User user=UserUtil.getLoginUser();
		record.setUserId(user.getId());
		record.setStatus("0");
		informationDao.save(record);
		return record.getId();
	}

	@Override
	public Information getById(Long id) {
		Information information = informationDao.getById(id);
		User user = userDao.getById(information.getUserId());
		information.setUserNickName(user.getNickname());
		information.setUserHeadUrl(user.getHeadImgUrl());
		return information;
	}


	@Override
	public Long editById(Information record) {
		informationDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<Information> list(int pagenum, int pagesize,InformationQuery param) {
		param.setEndTime(new Date());
		PageHelper.startPage(pagenum, pagesize);
		List<Information> datalist = informationDao.list(param);
		addUserInfo(datalist);
		PageInfo<Information> resultPage = new PageInfo<Information>(datalist);
		return resultPage;
	}

	@Override
	public List<Information> listAll(InformationQuery param) {
		List<Information> datalist = informationDao.list(param);
		addUserInfo(datalist);
		return datalist;
	}

	private void addUserInfo(List<Information> informationList){
		for(Information information : informationList){
			User user = userDao.getById(information.getUserId());
			information.setUserNickName(user.getNickname());
			information.setUserHeadUrl(user.getHeadImgUrl());
		}
	}

	@Override
	public List<Information> getMyInfo(BaseInfo info) {
		User user=UserUtil.getLoginUser();
		List<Information>infos=informationDao.getMyInfo(info.getType(), user.getId());
		addUserInfo(infos);
        return infos;
	}

	@Override
	public Long setResolved(Long id) {
		informationDao.setResolved(id);
		return null;
	}

	@Override
	public PageInfo<Information> listDetail(int pagenum, int pagesize, InformationQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Information> datalist = informationDao.listAll(param);
		addUserInfo(datalist);
		PageInfo<Information> resultPage = new PageInfo<Information>(datalist);
		return resultPage;
	}

	@Override
	public Long setBanned(Long id) {
		informationDao.setBanned(id);
		return id;
	}

	@Override
	public CountInfo getCountInfo() {
		CountInfo info=new CountInfo();
		info.setInfoCount(informationDao.getInfoCount());
		info.setUserCount(userDao.getUserCount());
		return info;
	}

}
