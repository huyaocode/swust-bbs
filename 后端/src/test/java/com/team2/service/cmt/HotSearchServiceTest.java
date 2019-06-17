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
import com.team2.pojo.base.SearchInfo;
import com.team2.pojo.cmt.HotSearch;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.HotSearchQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class HotSearchServiceTest {
	@Autowired
	public HotSearchService hotSearchService;

	@Test
	public void testDelById() {
		System.out.println(hotSearchService.delById(5L));
	}

	@Test
	public void testSave() {
		HotSearch hotSearch=new HotSearch();
		hotSearch.setHotWord("just test");
		hotSearch.setFrequency(2L);
		System.out.println(hotSearchService.save(hotSearch));
	}

	@Test
	public void testGetById() {
		HotSearch hotSearch=hotSearchService.getById(10L);
		System.out.println(hotSearch.toString());
	}

	@Test
	public void testEditById() {
		HotSearch hotSearch=hotSearchService.getById(10L);
		hotSearch.setFrequency(100L);
		System.out.println(hotSearchService.editById(hotSearch));
	}

	@Test
	public void testList() {
		HotSearchQuery param=new HotSearchQuery();
		param.setPageSize(5);
		
		PageInfo<HotSearch>lists=hotSearchService.list(param.getPageNum(), param.getPageSize(), param);
		System.out.println(lists.getSize());
		System.out.println(lists.getList().get(0).toString());
	}

	@Test
	public void testListAll() {
		List<HotSearch>lists=hotSearchService.listAll(null);
		System.out.println(lists.size());
		System.out.println(lists.get(0).toString());
	}

//	@Test
//	public void testDoSearch() {
//		SearchInfo searchInfo=new SearchInfo();
//		searchInfo.setSearchContent("车");
//		searchInfo.setType("0");
//		PageInfo<Information>lists=hotSearchService.doSearch(searchInfo);
//		System.out.println(lists.getList().get(0).toString());
//	}

}
