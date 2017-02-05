package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


import com.imooc.util.DBHelper;

import entity.Seller;


public class SellerDao {
	/**
	 * 增加卖方数据到数据库
	 * 
	 * @param g
	 * @throws Exception
	 */
	public static void addMaiFang(Seller m) throws Exception {
		// 连接数据库
		Connection conn = DBHelper.getConnection();
		// sql语句
		String sql = "" + "insert into maifang"
				+ "(book_name,zuozhe_name,chubanshe_name,phone,maifang_name)"
				+ "values(" + "?,?,?,?,?)";
		// 预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, m.getBook_name());
		ptmt.setString(2, m.getZuozhe_name());
		ptmt.setString(3, m.getChubanshe_name());
		ptmt.setString(4, m.getPhone());
		ptmt.setString(5, m.getMaifang_name());
		// 执行sql语句
		ptmt.execute();
	}

	/**
	 * 查询书籍通过书名
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
/**
 * 通过查询书名返回list集合
 * @param book_name
 * @return
 * @throws Exception
 */
	public static List<Seller> selectBooksByBook_name(String book_name)
			throws Exception {
		// 连接数据库
		Connection conn = DBHelper.getConnection();
		// sql语句（关键字查询）
		String sql = "" + "select * from maifang where book_name like ?";
		// 预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, "%"+book_name+"%");
		//创建list集合
		List<Seller> gs = new ArrayList<Seller>();
		Seller g = null;
		// 执行sql查询返回结果集
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new Seller();
			g.setBook_name(rs.getString("book_name"));
			g.setZuozhe_name(rs.getString("zuozhe_name"));
			g.setChubanshe_name(rs.getString("chubanshe_name"));
			gs.add(g);
		}
		return gs;
	}
}
