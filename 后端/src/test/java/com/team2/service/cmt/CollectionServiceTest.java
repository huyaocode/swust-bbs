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
import com.team2.pojo.cmt.Collection;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class CollectionServiceTest {
	@Autowired
	public CollectionService collectionService;

	@Test
	public void testDelById() {
		System.out.println(collectionService.delById(2L));
	}

//	@Test
//	public void testSave() {
//		Collection collection=new Collection();
//		collection.setInformationId(107L);
//		collection.setUserId(1L);
//		System.out.println(collectionService.save(collection));
//	}

	@Test
	public void testGetById() {
		Collection collection=collectionService.getById(1L);
		System.out.println(collection.toString());
	}

//	@Test
//	public void testEditById() {
//		Collection collection=collectionService.getById(1L);
//		collection.setUserId(2L);
//		System.out.println(collectionService.editById(collection));
//		
//	}

	@Test
	public void testList() {
		PageInfo<Collection>lists=collectionService.list(1, 5, null);
		System.out.println(lists.getSize());
		System.out.println(lists.getList().get(0).toString());
	}

	@Test
	public void testListAll() {
		List<Collection>lists=collectionService.listAll(null);
		System.out.println(lists.get(0).toString());
	}

//	@Test
//	public void testGetMyCollection() {
//		collectionService.get
//	}

}
