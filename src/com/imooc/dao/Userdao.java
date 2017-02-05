package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;




import java.sql.ResultSet;





import com.imooc.util.DBHelper;

import entity.Users;

public class Userdao {
	/**
	 * �����û����ݵ����ݿ�
	 * @param g
	 * @throws Exception
	 */
	public static void addUsers(Users u) throws Exception{
		//�������ݿ�
		Connection conn=DBHelper.getConnection();
		//sql���
		String sql="" +
				"insert into user" +
				"(user_name,sex,email,phone,introduce,password)" +
				"values(" +
				"?,?,?,?,?,?)";
		//Ԥ����sql���
		PreparedStatement ptmt=conn.prepareStatement(sql);	
		
		ptmt.setString(1,u.getUsername());
		ptmt.setString(2, u.getGender());
		ptmt.setString(3, u.getEmail());
		ptmt.setString(4, u.getPhone());
		ptmt.setString(5, u.getIntroduce());
		ptmt.setString(6, u.getMypassword());
		//ִ��sql���
		ptmt.execute();
	}
	/**
	 * ��ѯ���ݿ�ͨ���û���
	 * @param username
	 * @return
	 * @throws Exception 
	 */
	public static Users selectUsersByUsername(String username) throws Exception{
		Users u=null;
		//�������ݿ�
		Connection conn=DBHelper.getConnection();
		//sql���
		String sql=""+
		"select * from user where user_name=?";
		//Ԥ����sql���
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, username);
		//ִ��sql��ѯ���ؽ����
		ResultSet rs=ptmt.executeQuery();
		//��װ��ѯ��Ľ��
		while(rs.next()){
			u=new Users();		
			u.setUsername(rs.getString("user_name"));	
			u.setEmail(rs.getString("email"));
			u.setPhone(rs.getString("phone"));
			u.setGender(rs.getString("sex"));
			u.setIntroduce(rs.getString("introduce"));
			u.setMypassword(rs.getString("password"));		
		}
		return u;
	}
}
