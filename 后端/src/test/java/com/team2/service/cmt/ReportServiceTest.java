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
import com.team2.pojo.base.ReportInfo;
import com.team2.pojo.cmt.Report;
import com.team2.vo.cmt.ReportQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class ReportServiceTest {
	@Autowired
	public ReportService reportService;

	@Test
	public void testDelById() {
		System.out.println(reportService.delById(4L));
	}

//	@Test
//	public void testSave() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetById() {
		Report report=reportService.getById(8l);
		System.out.println(report.toString());
	}

	@Test
	public void testEditById() {
		Report report=reportService.getById(8l);
		report.setMemo("just for test");
		System.out.println(reportService.editById(report));
	}

	@Test
	public void testList() {
		ReportQuery param=new ReportQuery();
		param.setPageSize(5);
		PageInfo<Report>lists=reportService.list(param.getPageNum(), param.getPageSize(), param);
		System.out.println(lists.getSize());
		System.out.println(lists.getList().get(0).toString());
	}

	@Test
	public void testListAll() {
		List<Report>lists=reportService.listAll(null);
		System.out.println(lists.size());
		System.out.println(lists.get(0).toString());
	}

	@Test
	public void testSetBanned() {
		ReportInfo info=new ReportInfo();
		info.setId(4L);
		info.setType("0");
		System.out.println(reportService.setBanned(info));
	}

}
