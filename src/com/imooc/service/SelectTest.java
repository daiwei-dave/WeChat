package com.imooc.service;

import java.util.ArrayList;

import com.imooc.dao.SellerDao;

import entity.Seller;

/**
 * У���û���������
 * 
 * @author Administrator
 *
 */
public class SelectTest {
	public static Seller selectTest(String book_name) throws Exception {
		Seller m = null;
		if (SellerDao.selectBookByBook_name(book_name) != null) {
			return SellerDao.selectBookByBook_name(book_name);
		} else {
			return null;
		}

	}

}
