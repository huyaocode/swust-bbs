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
import com.team2.pojo.base.SearchInfo;
import com.team2.pojo.cmt.HotSearch;
import com.team2.vo.cmt.HotSearchQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
@Transactional
public class HotSearchControllerTest {
	@Autowired
	public HotSearchController hotSearchController;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(hotSearchController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDelById() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(12L);
		
		String jsonStr = JSONObject.toJSONString(record);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/hotSearch/del");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testSave() throws Exception {
		HotSearch hotSearch=new HotSearch();
		hotSearch.setHotWord("just test");
		hotSearch.setFrequency(2L);
		String jsonStr = JSONObject.toJSONString(hotSearch);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/hotSearch/add");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testGetById() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(12L);
		String jsonStr = JSONObject.toJSONString(record);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/hotSearch/get");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testEditById() throws Exception {
		HotSearch hotSearch=new HotSearch();
		hotSearch.setFrequency(5L);
		hotSearch.setHotWord("just edit the test");
		hotSearch.setId(12l);
		String jsonStr = JSONObject.toJSONString(hotSearch);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/hotSearch/edit");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testDoSearch() throws Exception {
		SearchInfo info=new SearchInfo();
		info.setSearchContent("车");
		info.setType("0");
		String jsonStr = JSONObject.toJSONString(info);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/hotSearch/doSearch");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testList() throws Exception {
		HotSearchQuery param=new HotSearchQuery();
		param.setHotWord("车");
		String jsonStr = JSONObject.toJSONString(param);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/hotSearch/list");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

}
