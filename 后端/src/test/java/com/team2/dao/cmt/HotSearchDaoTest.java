package com.team2.dao.cmt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.team2.pojo.base.SearchInfo;
import com.team2.pojo.cmt.HotSearch;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.HotSearchQuery;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class HotSearchDaoTest {
	
	@Autowired
	public HotSearchDao hotSearchDao;

	@Test
	public void testDelById() {
		System.out.println(hotSearchDao.delById(4L));
	}

	@Test
	public void testSave() {
		HotSearch record=new HotSearch();
		record.setHotWord("test");
		record.setFrequency(1L);
		hotSearchDao.save(record);
		
	}

	@Test
	public void testGetById() {
		HotSearch record=hotSearchDao.getById(1L);
		System.out.println(record.toString());
	}

	@Test
	public void testEditById() {
		HotSearch record=new HotSearch();
		record.setFrequency(100L);
		record.setHotWord("ceshi");
		record.setId(4L);
		hotSearchDao.editById(record);
	}

	@Test
	public void testList() {
		HotSearchQuery param=new HotSearchQuery();
		List<HotSearch>lists=hotSearchDao.list(param);
		System.out.println(lists.get(0).toString());
	}

	@Test
	public void testGetByHotWord() {
		HotSearch record=new HotSearch();
		if(hotSearchDao.getByHotWord("车")!=null)
		  System.out.println(record.toString());
	}

}
