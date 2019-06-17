package com.team2.controller.cmt;

import static org.junit.Assert.*;

import org.apache.poi.hssf.record.RecalcIdRecord;
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
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.InformationQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class InformationControllerTest {
	@Autowired
	public InformationController informationController;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(informationController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDelById() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(122L);
		String jsonStr = JSONObject.toJSONString(record);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/information/add");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testSave() throws Exception {
		Information information=new Information();
		information.setCategoryId(1L);
		information.setContent("测试");
		information.setType("0");
		information.setTitle("测试");
		information.setStatus("0");
		String jsonStr = JSONObject.toJSONString(information);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/information/add");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testGetById() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(106L);
		String jsonStr = JSONObject.toJSONString(record);
		
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/information/get");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testSetResolved() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(107L);
		String jsonStr = JSONObject.toJSONString(record);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/information/setResolved");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testEditById() throws Exception {
		Information information=new Information();
		information.setContent("just test");
		information.setTitle("测试");
		information.setUserId(1L);
		information.setId(107L);
		information.setStatus("0");
		information.setType("0");
		information.setCategoryId(1l);
	
		
		String jsonStr = JSONObject.toJSONString(information);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/information/edit");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testGetMyInfo() throws Exception {
		String jsonStr = JSONObject.toJSONString(null);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/information/add");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testList() throws Exception {
		InformationQuery param=new InformationQuery();
		param.setPageNum(2);
		String jsonStr = JSONObject.toJSONString(param);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/information/list");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testListDetail() throws Exception {
		InformationQuery param=new InformationQuery();
		param.setPageNum(2);
		String jsonStr = JSONObject.toJSONString(param);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/information/listDetail");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

//	@Test
//	public void testImgUpdate() {
//		String jsonStr = JSONObject.toJSONString(category);
//
//		
//		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/category/add");
//		builder.contentType(MediaType.APPLICATION_JSON);
//		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
//		builder.content(jsonStr);
//		MvcResult result = mockMvc.perform(builder).andReturn();
//		System.out.println(result);
//	}

}
