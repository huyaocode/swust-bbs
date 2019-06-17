package com.team2.dao.cmt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.InformationQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class InformationDaoTest {
	@Autowired
	public InformationDao informationDao;

	@Test
	public void testDelById() {
		System.out.println(informationDao.delById(105L));
	}

	@Test
	public void testSave() {
		Information record=new Information();
		record.setCategoryId(1L);
		record.setType("1");
		record.setContent("测试");
		record.setTitle("测试");
		record.setStatus("0");
		record.setUserId(1L);
		informationDao.save(record);
	}

	@Test
	public void testGetById() {
		Information record=informationDao.getById(1L);
		System.out.println(record.toString());
	}

	@Test
	public void testEditById() {
		Information information=informationDao.getById(118L);
		information.setTitle("测试");
		informationDao.editById(information);
		
	}

	@Test
	public void testList() {
		List<Information>lists=informationDao.list(null);
		System.out.println(lists.get(0).toString());
	}

	@Test
	public void testGetMyInfo() {
		List<Information>lists=informationDao.getMyInfo("0", 1L);
		if(lists.size()!=0)
		System.out.println(lists.get(0).toString());
		
	}

	@Test
	public void testSetResolved() {
		informationDao.setResolved(107L);
	}

	@Test
	public void testSetBanned() {
		informationDao.setBanned(107L);
	}

}
