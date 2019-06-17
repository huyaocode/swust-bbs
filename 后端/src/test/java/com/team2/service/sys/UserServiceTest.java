package com.team2.service.sys;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.sys.User;
import com.team2.vo.sys.UserQuery;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
public class UserServiceTest {
	@Autowired
	public UserService userService;

	@Test
	public void testDelById() {
		System.out.println(userService.delById(6L));
	}

	@Test
	public void testSave() {
		User user=new User();
		user.setUsername("test2");
		user.setPassword("123");
		user.setNickname("test");
		System.out.println(userService.save(user));
	}

//	@Test
//	public void testGetUser() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testEditById() {
		User user=userService.getByUsername("12345");
		user.setNickname("test2");
		System.out.println(userService.editById(user));

	}

	@Test
	public void testList() {
		UserQuery param=new UserQuery();
		param.setPageSize(5);;
		PageInfo<User>lists=userService.list(param.getPageNum(), param.getPageSize(), param);
		System.out.println(lists.getSize());
		System.out.println(lists.getList().get(0).toString());
	}

	@Test
	public void testListAll() {
		List<User>lists=userService.listAll(null);
		System.out.println(lists.size());
		System.out.println(lists.get(0).toString());
	}

	@Test
	public void testGetByUsername() {
		System.out.println(userService.getByUsername("12345").toString());
	}

//	@Test
//	public void testSetHeadImg() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testLockUser() {
		System.out.println(userService.lockUser(6L));
	}

	@Test
	public void testUnlockUser() {
		System.out.println(userService.unlockUser(6L));
	}

}
