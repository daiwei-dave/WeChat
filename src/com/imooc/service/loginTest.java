package com.imooc.service;



import com.imooc.dao.Userdao;
/**
 * 校验用户名和密码
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
