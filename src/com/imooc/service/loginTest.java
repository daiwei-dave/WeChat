package com.imooc.service;



import com.imooc.dao.Userdao;
/**
 * У���û���������
 * @author Administrator
 *
 */
public class loginTest {
	public static boolean logintest(String username, String mypassword)
			throws Exception {
		if ((Userdao.selectUsersByUsername(username).getMypassword())
				.equals(mypassword)) {
			return true;
		} else {
			return false;
		}

	}

}
