package com.team2.controller.cmt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.team2.pojo.base.BaseRecord;
import com.team2.pojo.cmt.Category;
import com.team2.pojo.cmt.Collection;
import com.team2.vo.cmt.CollectionQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class CollectionControllerTest {
	@Autowired
	public CollectionController collectionController;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(collectionController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDelById() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(11L);
		String jsonStr = JSONObject.toJSONString(record);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/collection/del");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testSave() throws Exception {
		Collection collection=new Collection();
		collection.setInformationId(110L);
		
		String jsonStr = JSONObject.toJSONString(collection);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/collection/add");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testGetById() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(11L);
		String jsonStr = JSONObject.toJSONString(record);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/collection/get");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}
//
//	@Test
//	public void testEditById() throws Exception {
//		Collection collection=new Collection();
//		collection.setId(1l);
//		collection.setInformationId(107L);
//		
//		String jsonStr = JSONObject.toJSONString(collection);
//
//		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/collection/edit");
//		builder.contentType(MediaType.APPLICATION_JSON);
//		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
//		builder.content(jsonStr);
//		MvcResult result = mockMvc.perform(builder).andReturn();
//		System.out.println(result);
//	}

	@Test
	public void testList() throws Exception {
		CollectionQuery param=new CollectionQuery();
		param.setPageNum(2);
		String jsonStr = JSONObject.toJSONString(param);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/collection/list");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

//	@Test
//	public void testGetMyCollection() {
//		String jsonStr = JSONObject.toJSONString(category);
//
//		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/category/add");
//		builder.contentType(MediaType.APPLICATION_JSON);
//		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
//		builder.content(jsonStr);
//		MvcResult result = mockMvc.perform(builder).andReturn();
//		System.out.println(result);
//	}

}
