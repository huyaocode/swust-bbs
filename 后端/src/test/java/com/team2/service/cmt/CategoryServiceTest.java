package com.team2.service.cmt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.cmt.Category;

import javassist.expr.NewArray;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class CategoryServiceTest {
	@Autowired
	public CategoryService categoryService;

	@Test
	public void testDelById() {
		System.out.println(categoryService.delById(17L));
	}

	@Test
	public void testSave() {
		Category category= new Category();
		category.setName("测试");
		category.setType("0");
		System.out.println(categoryService.save(category));
	}

	@Test
	public void testGetById() {
		Category category=categoryService.getById(1L);
		System.out.println(category.toString());
	}

	@Test
	public void testEditById() {
		Category category=categoryService.getById(17L);
		category.setType("1");
		System.out.println(categoryService.editById(category));
	}

	@Test
	public void testList() {
		PageInfo<Category>lists=categoryService.list(1, 2, null);
		System.out.println(lists.getList().get(0).toString());
		
	}

	@Test
	public void testListAll() {
		List<Category>lists=categoryService.listAll(null);
		System.out.println(lists.get(0).toString());
	}

}
