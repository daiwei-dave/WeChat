package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;




import java.sql.ResultSet;





import com.imooc.util.DBHelper;

import entity.Users;

public class Userdao {
	/**
	 * 增加用户数据到数据库
	 * @param g
	 * @throws Exception
	 */
	public static void addUsers(Users u) throws Exception{
		//连接数据库
		Connection conn=DBHelper.getConnection();
		//sql语句
		String sql="" +
				"insert into user" +
				"(user_name,sex,email,phone,introduce,password)" +
				"values(" +
				"?,?,?,?,?,?)";
		//预编译sql语句
		PreparedStatement ptmt=conn.prepareStatement(sql);	
		
		ptmt.setString(1,u.getUsername());
		ptmt.setString(2, u.getGender());
		ptmt.setString(3, u.getEmail());
		ptmt.setString(4, u.getPhone());
		ptmt.setString(5, u.getIntroduce());
		ptmt.setString(6, u.getMypassword());
		//执行sql语句
		ptmt.execute();
	}
	/**
	 * 查询数据库通过用户名
	 * @param username
	 * @return
	 * @throws Exception 
	 */
	public static Users selectUsersByUsername(String username) throws Exception{
		Users u=null;
		//连接数据库
		Connection conn=DBHelper.getConnection();
		//sql语句
		String sql=""+
		"select * from user where user_name=?";
		//预编译sql语句
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, username);
		//执行sql查询返回结果集
		ResultSet rs=ptmt.executeQuery();
		//封装查询后的结果
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
