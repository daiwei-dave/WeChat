package com.imooc.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * �������ݿ�����
 * @author Administrator
 *
 */
public class DBHelper {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://119.29.143.41:3306/dd?useUnicode=true&characterEncoding=UTF-8";
	private static final String username="daiwei";
	private static final String password="dw2016";
	private static Connection conn=null;
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception {
		if(conn==null){
			conn=DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	/**
	 * �������ݿ�����״̬
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Connection conn=DBHelper.getConnection();
			if(conn!=null){
				System.out.println("���ݿ�����������");
			}
			else{
				System.out.println("���ݿ������쳣��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
