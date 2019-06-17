package com.team2.dao.sys;

import static org.junit.Assert.*;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.sys.User;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest  
public class UserDaoTest {
	@Autowired
	public UserDao userDao;

	@Test
	public void testDelById() {
		System.out.println(userDao.delById(29L));
	}

	@Test
	public void testSave() {
		User user=new User();
		user.setUsername("test");
		user.setPassword("123");
		user.setNickname("test");
		user.setRoleId(2L);
		System.out.println(userDao.save(user));
	}

//	@Test
//	public void testGetById() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testEditById() {
		User user=userDao.getById(6L);
		user.setNickname("test");
		System.out.println(userDao.editById(user));
	}

	@Test
	public void testList() {
		List<User>lists=userDao.list(null);
		System.out.println(lists.size());
		System.out.println(lists.get(0).toString());
		
	}

	@Test
	public void testGetByUsername() {
		User user=userDao.getByUsername("12345");
		System.out.println(user.toString());
	}

//	@Test
//	public void testSetHeadImg() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testLockUser() {
		System.out.println(userDao.lockUser(6L));
		
	}
	@Test
	public void testUnlockUser() {
		System.out.println(userDao.unlockUser(6L));
	}

}
