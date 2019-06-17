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
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.InformationQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class InformationServiceTest {
	@Autowired
	public InformationService informationService;

	@Test
	public void testDelById() {
		System.out.println(informationService.delById(107L));
	}

//	@Test
//	public void testSave() {
//		Information information=new Information();
//		information.setCategoryId(1L);
//		information.setContent("测试");
//		information.setType("0");
//		information.setTitle("测试");
//		information.setUserId(1L);
//		information.setStatus("0");
//		System.out.println(informationService.save(information));
//	}

	@Test
	public void testGetById() {
		System.out.println(informationService.getById(110L).toString());
	}

	@Test
	public void testEditById() {
		Information information=new Information();
		information.setContent("just test");
		information.setUserId(1L);
		information.setId(107L);
		
		System.out.println(informationService.editById(information));
	}

	@Test
	public void testList() {
		InformationQuery param=new InformationQuery();
		param.setPageSize(5);
		PageInfo<Information>lists=informationService.list(param.getPageNum(), param.getPageNum(), param);
		System.out.println(lists.getSize());
		System.out.println(lists.getList().get(0).toString());
	}

	@Test
	public void testListDetail() {
		InformationQuery param=new InformationQuery();
		param.setPageSize(5);
		PageInfo<Information>lists=informationService.listDetail(param.getPageNum(), param.getPageNum(), param);
		System.out.println(lists.getSize());
		System.out.println(lists.getList().get(0).toString());
	}

	@Test
	public void testListAll() {
		List<Information>lists=informationService.listAll(null);
		System.out.println(lists.size());
		System.out.println(lists.get(0).toString());
	}

//	@Test
//	public void testGetMyInfo() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testSetResolved() {
		System.out.println(informationService.setResolved(107l));
	}

}
