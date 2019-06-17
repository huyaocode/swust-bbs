package com.team2.service.cmt.impl;

import java.util.List;

import com.team2.dao.sys.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team2.dao.cmt.CollectionDao;
import com.team2.pojo.base.BaseInfo;
import com.team2.pojo.cmt.Collection;
import com.team2.pojo.cmt.Information;
import com.team2.pojo.sys.User;
import com.team2.vo.cmt.CollectionQuery;
import com.team2.service.cmt.CollectionService;
import com.team2.utils.UserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	public CollectionDao collectionDao;
	@Autowired
	public UserDao userDao;

	@Override
	public Long delById(Long id) {
		collectionDao.delById(id);
		return id;
	}

	@Override
	public Long save(Collection record) {
		User user = UserUtil.getLoginUser();
		record.setUserId(user.getId());
		int count = collectionDao.getCollectCount(record.getInformationId(), record.getUserId());
		if (count == 0) {
			collectionDao.save(record);
			return record.getId();
		} else {
			return -1L;
		}
	}

	@Override
	public Collection getById(Long id) {
		return collectionDao.getById(id);
	}

	@Override
	public Long editById(Collection record) {
		User user = UserUtil.getLoginUser();
		record.setUserId(user.getId());
		collectionDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<Collection> list(int pagenum, int pagesize, CollectionQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Collection> datalist = collectionDao.list(param);
		PageInfo<Collection> resultPage = new PageInfo<Collection>(datalist);
		return resultPage;
	}

	@Override
	public List<Collection> listAll(CollectionQuery param) {
		List<Collection> datalist = collectionDao.list(param);
		return datalist;
	}

	private void addUserInfo(List<Information> informationList) {
		for (Information information : informationList) {
			User user = userDao.getById(information.getUserId());
			information.setUserNickName(user.getNickname());
			information.setUserHeadUrl(user.getHeadImgUrl());
		}
	}

	@Override
	public List<Information> getMyCollection() {
		User user = UserUtil.getLoginUser();
		List<Information> collections = collectionDao.getCollection(user.getId());
		addUserInfo(collections);
		return collections;
	}

}
