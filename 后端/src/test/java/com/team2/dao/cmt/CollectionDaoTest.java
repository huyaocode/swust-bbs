package com.team2.dao.cmt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.team2.pojo.cmt.Collection;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.CollectionQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class CollectionDaoTest {
	@Autowired
	public CollectionDao collectionDao;

	@Test
	public void testDelById() {
		System.out.println(collectionDao.delById(3L));
	}

	@Test
	public void testSave() {
		Collection record=new Collection();
		record.setInformationId(115L);
		record.setUserId(1L);
		collectionDao.save(record);
	}

	@Test
	public void testGetById() {
		Collection record=collectionDao.getById(1L);
		System.out.println(record.toString());
	}

	@Test
	public void testEditById() {
		Collection record=new Collection();
		record.setInformationId(3L);
		record.setId(3L);
		record.setUserId(1L);
		collectionDao.editById(record);
	}

	@Test
	public void testList() {
		CollectionQuery param =new CollectionQuery();
		List<Collection>lists=collectionDao.list(param);
		System.out.println(lists.get(0).toString());
	}

	@Test
	public void testGetCollection() {
		List<Information>records= collectionDao.getCollection(1L);
		System.out.println(records.get(0).toString());
	}

}
