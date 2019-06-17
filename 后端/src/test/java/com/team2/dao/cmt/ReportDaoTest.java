package com.team2.dao.cmt;

import static org.junit.Assert.*;

import java.nio.channels.NonReadableChannelException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team2.pojo.cmt.Report;

import javassist.expr.NewArray;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
public class ReportDaoTest {
	
	@Autowired
	public ReportDao reportDao;

	@Test
	public void testDelById() {
		System.out.println(reportDao.delById(7L));
	}

	@Test
	public void testSave() {
		Report report =new Report();
		report.setInformationId(108L);
		report.setStatus("1");
		report.setUserId(1L);
		report.setMemo("测试");
		reportDao.save(report);
	}

	@Test
	public void testGetById() {
		Report report=reportDao.getById(5L);
		System.out.println(report.toString());
	}

	@Test
	public void testEditById() {
		Report report= reportDao.getById(5L);
		report.setMemo("测试2");
		reportDao.editById(report);
	}

	@Test
	public void testList() {
		List<Report>lists=reportDao.list(null);
		System.out.println(lists.get(0).toString());
	}

	@Test
	public void testSetVerified() {
		reportDao.setVerified(1L);
		System.out.println(reportDao.getById(5L).getStatus());
	}

}
