package com.team2.dao.cmt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.team2.pojo.cmt.Category;
import com.team2.vo.cmt.CategoryQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class CategoryDaoTest {
	@Autowired
	public CategoryDao categoryDao;

	@Test
	public void testDelById() {
		System.out.println(categoryDao.delById(11L));
	}

	@Test
	public void testSave() {
		Category record=new Category();
		record.setName("测试");
		record.setType("0");
	}

	@Test
	public void testGetById() {
		Category record=categoryDao.getById(10L);
		System.out.println(record.getName());
	}

	@Test
	public void testEditById() {
		Category record=new Category();
		record.setName("测试2");
		record.setId(10L);
		record.setType("0");
		categoryDao.editById(record);
	}

	@Test
	public void testList() {
		CategoryQuery param =new CategoryQuery();
		List<Category>lists=categoryDao.list(param);
		System.out.println(lists.get(0).toString());
	}

}
