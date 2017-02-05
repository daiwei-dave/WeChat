package com.imooc.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Seller;


public class MaiFangDaoTest {

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
			//测试查询书籍通过书名
//			Seller m=SellerDao.selectBookByBook_name("fpja");
//			System.out.println(m.toString());
			//测试通过查询书名返回list集合
			List<Seller> gs = new ArrayList<Seller>();
			gs= SellerDao.selectBooksByBook_name("信");
			for (Seller seller : gs) {
				System.out.println(seller.getBook_name());
				System.out.println(seller.getZuozhe_name());
				System.out.println(seller.getChubanshe_name());
				System.out.println("--------------------------");
			}
	//		System.out.println(m.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test
//	public void testSellerDao() {
//		try {
//			List<Seller> gs = new ArrayList<Seller>();
//			Seller m=(Seller) SellerDao.selectBooksByBook_name("单片机");
//			System.out.println(m.toString());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
