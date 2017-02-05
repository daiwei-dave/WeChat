package com.imooc.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Users;

public class UserdaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * 测试Userdao中的方法
	 */
	@Test
	public void testUserdao() {
		try {
			Users u=Userdao.selectUsersByUsername("daiwei");
			System.out.println(u.getMypassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
