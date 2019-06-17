package com.team2.service.cmt.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team2.pojo.cmt.Category;
import com.team2.vo.cmt.CategoryQuery;

import com.team2.dao.cmt.CategoryDao;

import com.team2.service.cmt.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	public CategoryDao categoryDao;
	@Override
	public Long delById(Long id) {
	   categoryDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Category record) {
		categoryDao.save(record);
		return record.getId();
	}

	@Override
	public Category getById(Long id) {
		return categoryDao.getById(id);
	}


	@Override
	public Long editById(Category record) {
		categoryDao.editById(record);
		return record.getId();
	}

	@Override
	public PageInfo<Category> list(int pagenum, int pagesize,CategoryQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Category> datalist = categoryDao.list(param);
        PageInfo<Category> resultPage = new PageInfo<Category>(datalist);
		return resultPage;
	}

    @Override
	public List<Category> listAll(CategoryQuery param) {
		List<Category> datalist = categoryDao.list(param);
		return datalist;
	}

}
