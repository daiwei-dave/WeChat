package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import com.imooc.util.DBHelper;

import entity.Buyer;
import entity.Seller;


public class BuyerDao {
	/**
	 * 增加买方数据到数据库
	 * 
	 * @param g
	 * @throws Exception
	 */
	public static void addBuyer(Buyer b) throws Exception {
		// 连接数据库
		Connection conn = DBHelper.getConnection();
		// sql语句
		String sql = "" + "insert into buyer"
				+ "(book_name,author,publishing_company,buyer_name,phone)"
				+ "values(?,?,?,?,?)";
		// 预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, b.getBook_name());
		ptmt.setString(2, b.getZuozhe_name());
		ptmt.setString(3, b.getChubanshe_name());
		ptmt.setString(4, b.getBuyer_name());
		ptmt.setString(5, b.getPhone());
		// 执行sql语句
		ptmt.execute();
	}

	/**
	 * 查询数据库通过用户名
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public static Seller selectBookByBook_name(String book_name)
			throws Exception {
		Seller m = null;
		// 连接数据库
		Connection conn = DBHelper.getConnection();
		// sql语句
		String sql = "" + "select * from maifang where book_name=?";
		// 预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, book_name);
		// 执行sql查询返回结果集
		ResultSet rs = ptmt.executeQuery();
		// 封装查询后的结果
		while (rs.next()) {
			m = new Seller();
			m.setBook_name(rs.getString("book_name"));
			m.setZuozhe_name(rs.getString("zuozhe_name"));
			m.setChubanshe_name(rs.getString("chubanshe_name"));

		}
		return m;
	}
}
