package com.team2.controller.sys;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.alibaba.fastjson.JSONObject;
import com.team2.controller.cmt.ReportController;
import com.team2.pojo.base.BaseRecord;
import com.team2.pojo.sys.User;
import com.team2.vo.sys.UserQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
public class UserControllerTest {
	@Autowired
	public ReportController reportController;
	
	private MockMvc mockMvc;

	@Test
	public void testDelById() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(107L);
		String jsonStr = JSONObject.toJSONString(record);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/user/del");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testSave() throws Exception {
		User user=new User();;
		user.setUsername("test2");
		user.setPassword("123");
		user.setNickname("test2");
	
		String jsonStr = JSONObject.toJSONString(user);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/user/del");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

//	@Test
//	public void testGetById() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testEditById() throws Exception {
		User user=new User();;
		user.setNickname("test22");
		String jsonStr = JSONObject.toJSONString(user);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/user/del");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testLockUser() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(6L);
		String jsonStr = JSONObject.toJSONString(record);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/user/del");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testUnlockUser() throws Exception {
		BaseRecord record=new BaseRecord();
		record.setId(6L);
		String jsonStr = JSONObject.toJSONString(record);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/user/del");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

	@Test
	public void testList() throws Exception {
		UserQuery param=new  UserQuery();
		param.setPageSize(5);
		String jsonStr = JSONObject.toJSONString(param);

		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/user/del");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "79cfc8df-4b6d-4aa0-80bf-22a79d92a9a5");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);
	}

//	@Test
//	public void testImgUpdate() {
//		fail("Not yet implemented");
//	}

}
